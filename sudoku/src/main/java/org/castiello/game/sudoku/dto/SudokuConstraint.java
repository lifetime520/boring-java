package org.castiello.game.sudoku.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.castiello.game.sudoku.SudokuElement;

public class SudokuConstraint implements Serializable {
	private static final long serialVersionUID = 1L;

	private final String key;
	private final Set<SudokuElement> sets = new HashSet<>();
	private final Map<String, SudokuConstraint> instanceMap = new ConcurrentHashMap<>();
	public static String getConstraintKey(int r, int c, boolean region) {
		return String.format("%d,%d,%b", r, c, region);
	}

	public SudokuConstraint(String key) {
		this.key = key;
	}

	public Set<SudokuElement> getSets() {
		return new HashSet<>(sets);
	}

	public boolean addSet(SudokuElement sudokuElement) {
		return !sets.contains(sudokuElement) && sets.add(sudokuElement);
	}

	public boolean removeElement(SudokuElement sudokuElement) {
		return sets.contains(sudokuElement) && sets.remove(sudokuElement);
	}

	public boolean containElement(SudokuElement sudokuElement) {
		return sets.contains(sudokuElement);
	}

	public String toString() {
		return sets.toString();
	}
}
