package org.castiello.game.sudoku.algo;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.dto.SudokuEntry;

public class SudokuVerifyAlgorithm implements IAlgorithm<Boolean> {
	public static Logger log = LogManager.getLogger(SudokuVerifyAlgorithm.class);
	public static final SudokuVerifyAlgorithm INSTANCE = new SudokuVerifyAlgorithm();

	@Override
	public Boolean algorithm(SudokuEntry[][] sudokuEntrys) {
		return !Arrays.asList(sudokuEntrys)
				.stream()
				.flatMap(arrays -> Arrays.asList(arrays).stream())
				.anyMatch(_sudokuEntry -> _sudokuEntry.getAns().ordinal() == 0 && _sudokuEntry.getOptions().size() == 0);
	}

}
