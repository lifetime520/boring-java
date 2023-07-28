package org.castiello.game.sudoku.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.enums.SudokuElement;
import org.castiello.game.sudoku.item.ISudokuEntry;

public class SudokuEntry implements ISudokuEntry {
	public static Logger log = LogManager.getLogger(SudokuEntry.class);
	private static final long serialVersionUID = 1L;

	public static final Set<SudokuElement> allSets = Set.of(SudokuElement.ONE, SudokuElement.TWO, SudokuElement.THREE, SudokuElement.FOUR, SudokuElement.FIVE, SudokuElement.SIX, SudokuElement.SEVEN, SudokuElement.EIGHT, SudokuElement.NIGHT);

	private final int rowId;
	private final int columnId;
	private final String id;
	private final SudokuConstraint rowSudokuConstraint;
	private final SudokuConstraint columnSudokuConstraint;
	private final SudokuConstraint regionSudokuConstraint;
	private SudokuElement ans = SudokuElement.EMPTY;
	public static final SudokuEntry EMPTY = new SudokuEntry();

	private SudokuEntry() {
		this.rowId = 0;
		this.columnId = 0;
		id = "";
		rowSudokuConstraint = null;
		columnSudokuConstraint = null;
		regionSudokuConstraint = null;
	}

	public SudokuEntry(int r, int c, Function<String, SudokuConstraint> mapFunction) {
		this.rowId = r;
		this.columnId = c;
		id = String.format("SudokuEntry<%d, %d>", rowId, columnId);
		rowSudokuConstraint = mapFunction.apply(String.format("%d,%d,%b", r, -1, false));
		columnSudokuConstraint = mapFunction.apply(String.format("%d,%d,%b", -1, c, false));
		regionSudokuConstraint = mapFunction.apply(String.format("%d,%d,%b", r / 3, c / 3, true));
	}

	public Set<SudokuElement> getOptions() {
		final Set<SudokuElement> leaveElement = new HashSet<>(allSets);

		leaveElement.removeAll(rowSudokuConstraint.getElements());
		leaveElement.removeAll(columnSudokuConstraint.getElements());
		leaveElement.removeAll(regionSudokuConstraint.getElements());
		return leaveElement;
	}

	public boolean setAns(SudokuElement sudokuElement) {
		if (sudokuElement == SudokuElement.EMPTY
				|| ans != SudokuElement.EMPTY
				|| rowSudokuConstraint.containElement(sudokuElement)
				|| columnSudokuConstraint.containElement(sudokuElement)
				|| regionSudokuConstraint.containElement(sudokuElement))
			return false;

		rowSudokuConstraint.addElement(sudokuElement);
		columnSudokuConstraint.addElement(sudokuElement);
		regionSudokuConstraint.addElement(sudokuElement);
		ans = sudokuElement;
		return true;
	}

	public String getId() {
		return id;
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
		return String.format("%s:%d\n row:%s\n column:%s\n region:%s \n", id, ans, rowSudokuConstraint, columnSudokuConstraint, regionSudokuConstraint);
	}
}
