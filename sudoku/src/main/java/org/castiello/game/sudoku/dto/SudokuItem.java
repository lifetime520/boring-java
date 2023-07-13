package org.castiello.game.sudoku.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.SudokuElement;
import org.castiello.game.sudoku.algo.GenerateKeyAlgorithm;
import org.castiello.game.sudoku.algo.IAlgorithm;
import org.castiello.game.sudoku.algo.SudokuVerifyAlgorithm;

public class SudokuItem implements Serializable {
	public static final Logger log = LogManager.getLogger(SudokuItem.class);
	private static final long serialVersionUID = 1L;

	private final String name;
	private final SudokuEntry[][] sudokuEntrys = new SudokuEntry[9][9];
	private final Map<String, SudokuConstraint> instanceMap = new ConcurrentHashMap<>();
	private final Function<String, SudokuConstraint> mapFunction = key -> instanceMap.computeIfAbsent(key, k -> new SudokuConstraint(k));

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
		if (vals.length() != 81) return false;
		final char[] charVals = vals.toCharArray();
		for (int r = 0; r < 9; r++)
			for (int c = 0; c < 9; c++)
				setEntry(r, c, String.valueOf(charVals[r * 9 + c]));
		return algorithm(SudokuVerifyAlgorithm.INSTANCE);
	}

	public boolean setEntry(int r, int c, String v) {
		return setEntry(r, c, v.charAt(0));
	}

	public boolean setEntry(int r, int c, char v) {
		if ('0' == v) return true;

		final SudokuElement tmp = SudokuElement.get(v);
		final boolean result = sudokuEntrys[r][c].setAns(tmp);
		if (!result && log.isDebugEnabled()) {
			log.debug("r:{}, c:{}, v:{}, bool:{}", r, c, v, result);
			log.debug(sudokuEntrys[r][c]);
		}
		return result && algorithm(SudokuVerifyAlgorithm.INSTANCE);
	}

	public void print(String... argStr) {
		final StringBuilder sb = new StringBuilder();
		for (int r = 0; r < 9; r++) {
			if (r > 0 && r % 3 == 0) sb.append("---------+---------+---------\n");
			for (int c = 0; c < 9; c++) {
				if (c > 0 && c % 3 == 0) sb.append("|");
				sb.append(" ").append(sudokuEntrys[r][c].getAns()).append(" ");
			}
			sb.append("\n");
		}
		log.info("[name:{}]{}\n\n{}", name, argStr != null && argStr.length > 0 ? argStr[0] : "", sb);
	}

	public void printOptions() {
		log.info("[name:{}]printOptions", name);
		Arrays.asList(sudokuEntrys)
				.stream()
				.flatMap(arrays -> Arrays.asList(arrays).stream().filter(_sudokuEntry -> _sudokuEntry.getAns() == SudokuElement.EMPTY))
				.forEach(_sudokuEntry -> log.info("{}: {}", _sudokuEntry.getId(), _sudokuEntry.getOptions()));
	}

	public boolean isComplete() {
		return instanceMap.values().parallelStream().allMatch(constraint -> constraint.isFull());
	}

	public <R> R algorithm(IAlgorithm<R> algorithm) {
		return algorithm.algorithm(sudokuEntrys);
	}

	@Override
	public String toString() {
		return GenerateKeyAlgorithm.INSTANCE.algorithm(sudokuEntrys);
	}
}
