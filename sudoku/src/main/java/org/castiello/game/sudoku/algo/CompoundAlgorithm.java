package org.castiello.game.sudoku.algo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.SudokuElement;
import org.castiello.game.sudoku.dto.SudokuEntry;
import org.castiello.game.sudoku.dto.SudokuItem;

public class CompoundAlgorithm implements IAlgorithm<String> {
	public static final Logger log = LogManager.getLogger(DFSAlgorithm.class);
	public static final List<String> EMPTY = new ArrayList<>();
	public static final CompoundAlgorithm INSTANCE = new CompoundAlgorithm();
	private static Field field;

	@Override
	public String algorithm(SudokuEntry[][] sudokuEntrys) {
		final String sudokuGenerateKey = GenerateKeyAlgorithm.INSTANCE.algorithm(sudokuEntrys);
		return algorithm(sudokuGenerateKey);
	}

	public String algorithm(String sudokuGenerateKey) {
		final SudokuItem preCheckItem = new SudokuItem("preCheckItem");
		final boolean preCheckInit = preCheckItem.setEntries(sudokuGenerateKey);
		if (!preCheckInit) {
			log.info("skip @1   gKey:  {}", sudokuGenerateKey);
			if (log.isTraceEnabled()) {
				preCheckItem.print();
				preCheckItem.printOptions();
			}
			return null;
		};

		if (!preCheckItem.algorithm(ConstraintAlgorithm.INSTANCE)) {
			log.info("skip @2   gKey:  {}", preCheckItem.toString());
			if (log.isTraceEnabled()) {
				preCheckItem.print();
				preCheckItem.printOptions();
			}
			return null;
		}

		final String newestSudokuGenerateKey = preCheckItem.toString();
		if (preCheckItem.isComplete()) {
//			log.info("final     gKey:  {}", newestSudokuGenerateKey);
			return newestSudokuGenerateKey;
		}

		final SudokuEntry[][] sudokuEntrys = getSudokuEntrys(preCheckItem);
		final SudokuEntry sudokuEntry = Arrays.asList(sudokuEntrys)
				.stream()
				.flatMap(arrays -> Arrays.asList(arrays).stream().filter(_sudokuEntry -> _sudokuEntry.getAns() == SudokuElement.EMPTY))
				.findFirst()
				.orElseGet(() -> SudokuEntry.EMPTY);
		if (sudokuEntry == SudokuEntry.EMPTY) {
			log.info("skip @3   gKey:  {}", sudokuGenerateKey);
			if (log.isTraceEnabled()) {
				log.info("getSudokuEntrys(preCheckItem):  {}", Arrays.deepToString(sudokuEntrys));
				preCheckItem.print();
				preCheckItem.printOptions();
			}
			return null;
		} else {
			log.info("SudokuEntry options:  {}", sudokuEntry.getOptions());
		}

		return sudokuEntry.getOptions()
//				.parallelStream()
				.stream()
				.map(options -> {
					return algorithm(newestSudokuGenerateKey.replaceFirst("0", options.toString()));
				})
				.filter(Objects::nonNull)
				.findFirst()
				.orElse(null);
	}

	static {
		try {
			field = SudokuItem.class.getDeclaredField("sudokuEntrys");
			field.setAccessible(true);
		} catch (NoSuchFieldException | SecurityException e) {
		}
	}

	private SudokuEntry[][] getSudokuEntrys(SudokuItem preCheckItem) {
		try {
			return (SudokuEntry[][]) field.get(preCheckItem);
		} catch (IllegalArgumentException | IllegalAccessException e) {
		}
		return null;
	}
}
