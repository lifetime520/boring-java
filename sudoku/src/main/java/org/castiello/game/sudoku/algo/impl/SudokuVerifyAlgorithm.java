package org.castiello.game.sudoku.algo.impl;

import java.util.Arrays;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.algo.IAlgorithm;
import org.castiello.game.sudoku.dto.SudokuEntry;
import org.castiello.game.sudoku.enums.SudokuElement;

public class SudokuVerifyAlgorithm implements IAlgorithm<Boolean> {
	public static final Logger log = LogManager.getLogger(SudokuVerifyAlgorithm.class);
	public static final SudokuVerifyAlgorithm INSTANCE = new SudokuVerifyAlgorithm();

	@Override
	public Boolean algorithm(SudokuEntry[][] sudokuEntrys) {
		return !Arrays.asList(sudokuEntrys)
				.stream()
				.flatMap(arrays -> Arrays.asList(arrays).stream().filter(Objects::nonNull))
				.anyMatch(_sudokuEntry -> _sudokuEntry.getAns() == SudokuElement.EMPTY && _sudokuEntry.getOptions().isEmpty());
	}

}
