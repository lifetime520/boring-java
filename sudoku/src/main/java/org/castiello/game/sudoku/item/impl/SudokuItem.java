package org.castiello.game.sudoku.item.impl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.algo.ISolveAlgorithm;
import org.castiello.game.sudoku.algo.impl.GenerateKeyAlgorithm;
import org.castiello.game.sudoku.algo.impl.SudokuVerifyAlgorithm;
import org.castiello.game.sudoku.dto.SudokuConstraint;
import org.castiello.game.sudoku.dto.SudokuEntry;
import org.castiello.game.sudoku.enums.SudokuElement;

public class SudokuItem implements Serializable {
	public static final Logger log = LogManager.getLogger(SudokuItem.class);
	private static final long serialVersionUID = 1L;

	private final String name;
	private SudokuEntry[][] sudokuEntrys;
	private final Map<String, SudokuConstraint> instanceMap = new ConcurrentHashMap<>();
	private final Function<String, SudokuConstraint> mapFunction = key -> instanceMap.computeIfAbsent(key, k -> new SudokuConstraint(k));

	public SudokuItem(String name) {
		this.name = name;
	}

	public boolean setEntries(String vals) {
		final long start = System.currentTimeMillis();
		if (sudokuEntrys != null || vals.length() != 81) return false;

		sudokuEntrys = new SudokuEntry[9][9];
		final char[] charVals = vals.toCharArray();

		boolean verify = IntStream.range(0, 81).allMatch(idx -> {
			final int r = idx / 9;
			final int c = idx - r * 9;
			sudokuEntrys[r][c] = new SudokuEntry(r, c, mapFunction);
			final SudokuElement val = SudokuElement.get(charVals[idx]);
			return SudokuElement.EMPTY == val || setEntry(sudokuEntrys[r][c], val);
		});
		if (log.isTraceEnabled())
			log.trace("setEntries cost: {}ms", System.currentTimeMillis() - start);
		return verify;
	}

	public boolean setEntry(int r, int c, String v) {
		final SudokuElement val = SudokuElement.get(v);
		return SudokuElement.EMPTY == val || setEntry(sudokuEntrys[r][c], val);
	}

	private boolean setEntry(SudokuEntry sudokuEntry, SudokuElement val) {
		return sudokuEntry.setAns(val) && SudokuVerifyAlgorithm.INSTANCE.algorithm(sudokuEntrys);
	}

	public void print(String... argStr) {
		final long start = System.currentTimeMillis();
		final StringBuilder sb = new StringBuilder();
		for (int r = 0; r < 9; r++) {
			if (r == 3 || r == 6) sb.append("---------+---------+---------\n");
			for (int c = 0; c < 9; c++) {
				if (c == 3 || c == 6) sb.append("|");
				sb.append(" ").append(sudokuEntrys[r][c].getAns()).append(" ");
			}
			sb.append("\n");
		}
		log.info("{}\n[name:{}]\n{}", argStr != null && argStr.length > 0 ? argStr[0] : "", name, sb);
		if (log.isTraceEnabled())
			log.trace("print cost: {}ms", System.currentTimeMillis() - start);
	}

	public void printOptions() {
		final long start = System.currentTimeMillis();
		log.info("[name:{}] printOptions", name);
		Arrays.asList(sudokuEntrys)
				.stream()
				.flatMap(arrays -> Arrays.asList(arrays).stream().filter(_sudokuEntry -> _sudokuEntry.getAns() == SudokuElement.EMPTY))
				.forEach(_sudokuEntry -> log.info("{}: {}", _sudokuEntry.getId(), _sudokuEntry.getOptions()));

		if (log.isTraceEnabled())
			log.trace("print cost: {}ms", System.currentTimeMillis() - start);
	}

	public boolean isComplete() {
		return !instanceMap.values().stream().anyMatch(constraint -> !constraint.isFull());
	}

	public <R> R algorithm(ISolveAlgorithm<R> algorithm) {
		return algorithm.algorithm(sudokuEntrys);
	}

	@Override
	public String toString() {
		return GenerateKeyAlgorithm.INSTANCE.algorithm(sudokuEntrys);
	}
}
