package org.castiello.game.sudoku.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.SudokuElement;
import org.castiello.game.sudoku.algo.IAlgorithm;
import org.castiello.game.sudoku.algo.SudokuVerifyAlgorithm;

public class SudokuItem implements Serializable {
	public static Logger log = LogManager.getLogger(SudokuItem.class);
	private static final long serialVersionUID = 1L;

	private final String name;
	private SudokuEntry[][] sudokuEntrys = new SudokuEntry[9][9];
	private final Map<String, SudokuConstraint> instanceMap = new ConcurrentHashMap<>();
	private Function<String, SudokuConstraint> mapFunction = key -> instanceMap.computeIfAbsent(key, k -> new SudokuConstraint(k));

	public SudokuEntry[][] getSudokuEntrys() {
		return sudokuEntrys.clone();
	}

	public SudokuItem(String name) {
		this.name = name;
		init();
	}

	private void init() {
		for (int r = 0; r < 9; r++)
			for (int c = 0; c < 9; c++)
				sudokuEntrys[r][c] = new SudokuEntry(r, c, mapFunction);
	}

	public boolean setEntries(String vals) {
		for (int r = 0; r < 9; r++)
			for (int c = 0; c < 9; c++)
				setEntry(r, c, String.valueOf((char) vals.charAt(r * 9 + c)));
		return algorithm(new SudokuVerifyAlgorithm());
	}

	public boolean setEntry(int r, int c, String v) {
		if ("0".equals(v)) return true;

		SudokuElement tmp = SudokuElement.get(Integer.valueOf(v).intValue());
		boolean result = sudokuEntrys[r][c].setAns(tmp);
		if (!result) {
			log.info("r:{}, c:{}, v:{}, bool:{}", r, c, v, result);
			log.info(sudokuEntrys[r][c]);
		}
		return result && algorithm(new SudokuVerifyAlgorithm());
	}

	public void print(String... argStr) {
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < 9; r++) {
			if (r > 0 && r % 3 == 0) sb.append("---------+---------+---------\n");
			for (int c = 0; c < 9; c++) {
				if (c > 0 && c % 3 == 0) sb.append("|");
				sb.append(" ").append(sudokuEntrys[r][c].getAns()).append(" ");
			}
			sb.append("\n");
		}
		log.info("[name:{}]{}\n\n{}\n", name, argStr != null && argStr.length > 0 ? argStr[0] : "", sb.substring(0, sb.length() - 1));
	}

	public void printOptions() {
		Arrays.asList(sudokuEntrys)
				.stream()
				.flatMap(arrays -> Arrays.asList(arrays).stream())
				.filter(_sudokuEntry -> _sudokuEntry.getAns().ordinal() == 0)
				.forEach(_sudokuEntry -> log.info("{}: {}", _sudokuEntry.getId(), _sudokuEntry.getOptions()));
	}

	public boolean algorithm(IAlgorithm algorithm) {
		return algorithm.algorithm(sudokuEntrys);
	}

	@Override
	public String toString() {
		return Arrays.asList(sudokuEntrys)
				.stream()
				.flatMap(arrays -> Arrays.asList(arrays).stream())
				.map(e -> String.valueOf(e.getAns().ordinal()))
				.reduce((s, e) -> String.format("%s%s", s, e))
				.get();
	}
}
