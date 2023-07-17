package org.castiello.game.sudoku.algo.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.algo.IAlgorithm;
import org.castiello.game.sudoku.dto.SudokuEntry;

public class DFSAlgorithm implements IAlgorithm<String> {
	public static final Logger log = LogManager.getLogger(DFSAlgorithm.class);
	public static final DFSAlgorithm INSTANCE = new DFSAlgorithm();

	@Override
	public String algorithm(SudokuEntry[][] sudokuEntrys) {
		return null;
	}
}
