package org.castiello.game.sudoku.algo;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.dto.SudokuEntry;

public class SudokuVerifyAlgorithm implements IAlgorithm {
	public static Logger log = LogManager.getLogger(SudokuVerifyAlgorithm.class);

	@Override
	public boolean algorithm(SudokuEntry[][] sudokuEntrys) {
		return Arrays.asList(sudokuEntrys)
				.stream()
				.flatMap(arrays -> Arrays.asList(arrays).stream())
				.allMatch(_sudokuEntry -> _sudokuEntry.getAns().ordinal() == 0 && _sudokuEntry.getOptions().size() == 0);
	}

}
