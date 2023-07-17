package org.castiello.game.sudoku.util;

import java.lang.reflect.Field;

import org.castiello.game.sudoku.dto.SudokuEntry;
import org.castiello.game.sudoku.dto.SudokuItem;

public class SudokuItemUtils {
	private static Field field;

	static {
		try {
			field = SudokuItem.class.getDeclaredField("sudokuEntrys");
			field.setAccessible(true);
		} catch (NoSuchFieldException | SecurityException e) {
		}
	}

	public static SudokuEntry[][] getSudokuEntrys(SudokuItem preCheckItem) {
		try {
			return (SudokuEntry[][]) field.get(preCheckItem);
		} catch (IllegalArgumentException | IllegalAccessException e) {
		}
		return null;
	}
}
