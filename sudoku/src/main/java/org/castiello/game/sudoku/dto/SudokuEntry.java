package org.castiello.game.sudoku.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.enums.SudokuElement;

public class SudokuEntry implements Serializable {
	public static Logger log = LogManager.getLogger(SudokuEntry.class);
	private static final long serialVersionUID = 1L;

	public static final Set<SudokuElement> allSets = Set.of(SudokuElement.ONE, SudokuElement.TWO, SudokuElement.THREE, SudokuElement.FOUR, SudokuElement.FIVE, SudokuElement.SIX, SudokuElement.SEVEN, SudokuElement.EIGHT, SudokuElement.NIGHT);

	private final int rowId;
	private final int columnId;
	private final SudokuConstraint rowSudokuConstraint;
	private final SudokuConstraint columnSudokuConstraint;
	private final SudokuConstraint regionSudokuConstraint;
	private SudokuElement ans = SudokuElement.EMPTY;
	public static final SudokuEntry EMPTY = new SudokuEntry();

	private SudokuEntry() {
		this.rowId = 0;
		this.columnId = 0;
		rowSudokuConstraint = null;
		columnSudokuConstraint = null;
		regionSudokuConstraint = null;
	}

	public SudokuEntry(int r, int c, Function<String, SudokuConstraint> mapFunction) {
		this.rowId = r;
		this.columnId = c;
		rowSudokuConstraint = mapFunction.apply(String.format("%d,%d,%b", r, -1, false));
		columnSudokuConstraint = mapFunction.apply(String.format("%d,%d,%b", -1, c, false));
		regionSudokuConstraint = mapFunction.apply(String.format("%d,%d,%b", r / 3, c / 3, true));
	}

	public Set<SudokuElement> getOptions() {
		final Set<SudokuElement> leaveElement = new HashSet<>(allSets);
		leaveElement.removeAll(rowSudokuConstraint.getSets());
//		if (leaveElement.isEmpty()) return leaveElement;
		leaveElement.removeAll(columnSudokuConstraint.getSets());
//		if (leaveElement.isEmpty()) return leaveElement;
		leaveElement.removeAll(regionSudokuConstraint.getSets());
		return leaveElement;
	}

	public boolean setAns(SudokuElement sudokuElement) {
		if (sudokuElement == SudokuElement.EMPTY
				|| ans != SudokuElement.EMPTY
				|| rowSudokuConstraint.containElement(sudokuElement)
				|| columnSudokuConstraint.containElement(sudokuElement)
				|| regionSudokuConstraint.containElement(sudokuElement))
			return false;

		rowSudokuConstraint.addSet(sudokuElement);
		columnSudokuConstraint.addSet(sudokuElement);
		regionSudokuConstraint.addSet(sudokuElement);
		ans = sudokuElement;
		return true;
	}

	public String getId() {
		return String.format("SudokuEntry<%d, %d>", rowId, columnId);
	}

	public int getRowId() {
		return rowId;
	}

	public int getColumnId() {
		return columnId;
	}

	public SudokuElement getAns() {
		return ans;
	}

	@Override
	public String toString() {
		return String.format("SudokuEntry<%d, %d>:%d\n row:%s\n column:%s\n region:%s \n", rowId, columnId, ans, rowSudokuConstraint, columnSudokuConstraint, regionSudokuConstraint);
	}
}
