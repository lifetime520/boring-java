package org.castiello.game.sudoku.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.castiello.game.sudoku.enums.SudokuElement;
import org.castiello.game.sudoku.item.ISudokuConstraint;

public class SudokuConstraint implements ISudokuConstraint<Collection<SudokuElement>> {
	private static final long serialVersionUID = 1L;

	private final String key;
	private final Set<SudokuElement> sets = new HashSet<>();

	public SudokuConstraint(String key) {
		this.key = key;
	}

	public Set<SudokuElement> getElements() {
		return new HashSet<>(sets);
	}

	public boolean addElement(SudokuElement sudokuElement) {
		return sets.add(sudokuElement);
	}

	public boolean removeElement(SudokuElement sudokuElement) {
		return sets.contains(sudokuElement) && sets.remove(sudokuElement);
	}

	public boolean containElement(SudokuElement sudokuElement) {
		return sets.contains(sudokuElement);
	}

	public boolean isEmpty() {
		return sets.isEmpty();
	}

	public boolean isFull() {
		return sets.size() == 9;
	}

	public String toString() {
		return String.format("%s:%s", key, sets.toString());
	}
}
