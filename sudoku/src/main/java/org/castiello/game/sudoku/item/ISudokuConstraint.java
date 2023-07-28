package org.castiello.game.sudoku.item;

import java.io.Serializable;

import org.castiello.game.sudoku.enums.SudokuElement;

public interface ISudokuConstraint<C> extends Serializable {

	public C getElements();

	public boolean addElement(SudokuElement sudokuElement);

	public boolean removeElement(SudokuElement sudokuElement);

	public boolean containElement(SudokuElement sudokuElement);

	public boolean isEmpty();

	public boolean isFull();
}
