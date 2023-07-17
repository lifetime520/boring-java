package org.castiello.game.sudoku.algo;

import org.castiello.game.sudoku.dto.SudokuEntry;

@FunctionalInterface
public interface ISolveAlgorithm<R> extends IAlgorithm<R>{

	public R algorithm(SudokuEntry[][] sudokuEntrys);
}
