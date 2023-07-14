package org.castiello.game.sudoku.algo;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.dto.SudokuEntry;

public class GenerateKeyAlgorithm implements IAlgorithm<String> {
	public static final Logger log = LogManager.getLogger(GenerateKeyAlgorithm.class);
	public static final GenerateKeyAlgorithm INSTANCE = new GenerateKeyAlgorithm();

	@Override
	public String algorithm(SudokuEntry[][] sudokuEntrys) {
		return Arrays.asList(sudokuEntrys)
				.stream()
				.flatMap(arrays -> Arrays.asList(arrays).stream())
				.map(e -> e.getAns().toZeroString())
				.reduce((s, e) -> String.format("%s%s", s, e))
				.get();
	}
}
