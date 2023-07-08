package org.castiello.game.sudoku;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SudokuApplication {
    public static Logger log = LogManager.getLogger(SudokuApplication.class);

	public static void main(String[] args) {
//		SpringApplication.run(SudokuApplication.class, args);
		SudokuItem item = new SudokuItem();
		for (int r = 0; r < 9; r++)
			for (int c = 0; c < 9; c++) {
				try {
					item.setEntry(r, c, String.valueOf((char) System.in.read()));
				} catch (IOException e) {
				}
			}
		item.print("After input");

		item.auto();
		item.print("After auto");
		item.printOptions();
	}

}
enum SudokuElement {
	EMPTY(false),
	ONE(true),
	TWO(true),
	THREE(true),
	FOUR(true),
	FIVE(true),
	SIX(true),
	SEVEN(true),
	EIGHT(true),
	NIGHT(true);

	private final boolean enable;
	private SudokuElement(boolean enable) {
		this.enable = enable;
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
}

class SudokuConstraint implements Serializable {
	private static final long serialVersionUID = 1L;

	private final int rowId;
	private final int columnId;
	private final boolean region;
	private final Set<SudokuElement> sets = new HashSet<>();
	private final static Map<String, SudokuConstraint> instanceMap = new ConcurrentHashMap<>();

	public static SudokuConstraint getInstance(int r, int c, boolean region) {
		String kry = String.format("%d,%d,%b", r, c, region);
		return instanceMap.computeIfAbsent(kry, key -> new SudokuConstraint(r, c, region));
	}

	private SudokuConstraint(int r, int c, boolean region) {
		this.rowId = r;
		this.columnId = c;
		this.region = region;
	}

	public Set<SudokuElement> getSets() {
		return new HashSet<>(sets);
	}

	public boolean addSet(SudokuElement sudokuElement) {
		if (!sets.contains(sudokuElement)) return sets.add(sudokuElement);
		return false;
	}

	public boolean removeElement(SudokuElement sudokuElement) {
		if (sets.contains(sudokuElement)) return sets.remove(sudokuElement);
		return false;
	}

	public boolean containElement(SudokuElement sudokuElement) {
		return sets.contains(sudokuElement);
	}

	public String toString() {
		return sets.toString();
	}
}

class SudokuEntry implements Serializable {
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

	public SudokuEntry(int r, int c) {
		this.rowId = r;
		this.columnId = c;
		rowSudokuConstraint = SudokuConstraint.getInstance(r, -1, false);
		columnSudokuConstraint = SudokuConstraint.getInstance(-1, c, false);
		regionSudokuConstraint = SudokuConstraint.getInstance(r / 3, c / 3, true);
	}

	public Set<SudokuElement> getOptions() {
		Set<SudokuElement> leaveElement = new HashSet<>(allSets);
		leaveElement.removeAll(rowSudokuConstraint.getSets());
		leaveElement.removeAll(columnSudokuConstraint.getSets());
		leaveElement.removeAll(regionSudokuConstraint.getSets());
		return leaveElement;
	}

	public boolean setAns(SudokuElement sudokuElement) {
		if (rowSudokuConstraint.containElement(sudokuElement)
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
//		log.info("SudokuEntry<{}, {}>:{}\nrow: {}\ncolumn: {}\nregion: {}\n", rowId, columnId, ans.ordinal(), rowSudokuConstraint, columnSudokuConstraint, regionSudokuConstraint);
		return String.format("SudokuEntry<%d, %d>:%d\n row:%s\n column:%s\n region:%s \n", rowId, columnId, ans.ordinal(), rowSudokuConstraint, columnSudokuConstraint, regionSudokuConstraint);
	}
}

class SudokuItem implements Serializable {
	private static final long serialVersionUID = 1L;

	private SudokuEntry[][] sudokuEntrys = new SudokuEntry[9][9];

	public SudokuItem() {
		for (int r = 0; r < 9; r++)
			for (int c = 0; c < 9; c++)
				sudokuEntrys[r][c] = new SudokuEntry(r, c);
	}

	public boolean setEntry(int r, int c, String v) {
		if ("0".equals(v)) return true;

		SudokuElement tmp = SudokuElement.get(Integer.valueOf(v).intValue());
		boolean result = sudokuEntrys[r][c].setAns(tmp);
		if (!result) {
			System.out.printf("r:%d, c:%d, v:%s, bool:%b\n", r, c, v, result);
			System.out.println(sudokuEntrys[r][c]);
		}
		return result;
	}

	public void print(String... argStr) {
		System.out.printf("%s\n", argStr != null && argStr.length > 0 ? argStr[0] : "");
		for (int r = 0; r < 9; r++) {
			if (r > 0 && r % 3 == 0) System.out.printf("------+------+------\n");
			for (int c = 0; c < 9; c++) {
				if (c > 0 && c % 3 == 0) System.out.printf("|");
				System.out.printf(" %d", sudokuEntrys[r][c].getAns().ordinal());
			}
			System.out.printf("\n");
		}
		System.out.printf("\n");
	}

	public void printOptions() {
		Arrays.asList(sudokuEntrys)
				.stream()
				.flatMap(arrays -> Arrays.asList(arrays).stream())
				.filter(_sudokuEntry -> _sudokuEntry.getAns().ordinal() == 0)
				.forEach(_sudokuEntry -> System.out.printf("%s: %s\n", _sudokuEntry.getId(), _sudokuEntry.getOptions()));
	}

	public void auto() {
		boolean conti = false;
		int round = 0;
		do {
			SudokuEntry sudokuEntry = Arrays.asList(sudokuEntrys)
					.stream()
					.flatMap(arrays -> Arrays.asList(arrays).stream())
					.filter(_sudokuEntry -> _sudokuEntry.getAns().ordinal() == 0)
					.filter(_sudokuEntry -> _sudokuEntry.getOptions().size() == 1)
					.findFirst()
					.orElseGet(() -> SudokuEntry.EMPTY);
			conti = SudokuEntry.EMPTY != sudokuEntry;
			if (conti) {
				SudokuElement sudokuElementAns = sudokuEntry.getOptions().stream().findAny().get();
				sudokuEntry.setAns(sudokuElementAns);
				System.out.println("round:" + ++round);
			}
		} while (conti);
	}
}