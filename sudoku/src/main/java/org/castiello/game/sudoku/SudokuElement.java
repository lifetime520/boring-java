package org.castiello.game.sudoku;

public enum SudokuElement {
	EMPTY(" "),
	ONE("1"),
	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	NIGHT("9");

	private final String strVal;

	private SudokuElement(String strVal) {
		this.strVal = strVal;
	}

	public static SudokuElement get(int i) {
		switch (i) {
			case 1: return ONE;
			case 2: return TWO;
			case 3: return THREE;
			case 4: return FOUR;
			case 5: return FIVE;
			case 6: return SIX;
			case 7: return SEVEN;
			case 8: return EIGHT;
			case 9: return NIGHT;
			default: return EMPTY;
		}
	}

	public static SudokuElement get(char c) {
		switch (c) {
			case '1': return ONE;
			case '2': return TWO;
			case '3': return THREE;
			case '4': return FOUR;
			case '5': return FIVE;
			case '6': return SIX;
			case '7': return SEVEN;
			case '8': return EIGHT;
			case '9': return NIGHT;
			default: return EMPTY;
		}
	}

	public static SudokuElement get(String c) {
		switch (c) {
			case "1": return ONE;
			case "2": return TWO;
			case "3": return THREE;
			case "4": return FOUR;
			case "5": return FIVE;
			case "6": return SIX;
			case "7": return SEVEN;
			case "8": return EIGHT;
			case "9": return NIGHT;
			default: return EMPTY;
		}
	}

	@Override
	public String toString() {
		return strVal;
	}

	public String toZeroString() {
		switch (ordinal()) {
			case 1: case 2: case 3: case 4:
			case 5: case 6: case 7: case 8:
			case 9: return strVal;
			default: return "0";
		}
	}
}
