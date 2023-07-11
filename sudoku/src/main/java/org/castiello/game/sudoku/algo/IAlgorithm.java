package org.castiello.game.sudoku.algo;

import org.castiello.game.sudoku.dto.SudokuEntry;

@FunctionalInterface
public interface IAlgorithm {

	public boolean algorithm(SudokuEntry[][] sudokuEntrys);
}
