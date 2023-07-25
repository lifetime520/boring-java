package org.castiello.game.sudoku.algo.impl;

import java.util.Arrays;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.algo.ISolveAlgorithm;
import org.castiello.game.sudoku.dto.SudokuEntry;
import org.castiello.game.sudoku.enums.SudokuElement;
import org.castiello.game.sudoku.item.impl.SudokuItem;
import org.castiello.game.sudoku.util.SudokuItemUtils;

public class CompoundAlgorithm implements ISolveAlgorithm<String> {
	public static final Logger log = LogManager.getLogger(CompoundAlgorithm.class);
	public static final CompoundAlgorithm INSTANCE = new CompoundAlgorithm();

	@Override
	public String algorithm(SudokuEntry[][] sudokuEntrys) {
		final String sudokuGenerateKey = GenerateKeyAlgorithm.INSTANCE.algorithm(sudokuEntrys);
		return algorithm(sudokuGenerateKey);
	}

	public String algorithm(String sudokuGenerateKey) {
		final SudokuItem preCheckItem = new SudokuItem("preCheckItem/" + sudokuGenerateKey);
		final boolean preCheckInit = preCheckItem.setEntries(sudokuGenerateKey);
		if (!preCheckInit) {
			if (log.isTraceEnabled()) {
				log.trace("skip @1   gKey:  {}", sudokuGenerateKey);
				preCheckItem.print();
				preCheckItem.printOptions();
			}
			return null;
		};

		// quick way
		preCheckItem.algorithm(ConstraintAlgorithm.INSTANCE);

		// store current key
		final String newestSudokuGenerateKey = preCheckItem.toString();
		if (preCheckItem.isComplete()) {
//			log.info("final     gKey:  {}", newestSudokuGenerateKey);
			return newestSudokuGenerateKey;
		}

		final SudokuEntry[][] sudokuEntrys = SudokuItemUtils.getSudokuEntrys(preCheckItem);
		final SudokuEntry sudokuEntry = Arrays.asList(sudokuEntrys)
				.stream()
				.flatMap(arrays -> Arrays.asList(arrays).stream().filter(_sudokuEntry -> _sudokuEntry.getAns() == SudokuElement.EMPTY))
				.findFirst()
				.orElse(SudokuEntry.EMPTY);
		if (sudokuEntry == SudokuEntry.EMPTY) {
			if (log.isTraceEnabled()) {
				log.trace("skip @3   gKey:  {}", sudokuGenerateKey);
				log.trace("getSudokuEntrys(preCheckItem):  {}", Arrays.deepToString(sudokuEntrys));
				preCheckItem.print();
				preCheckItem.printOptions();
			}
			return null;
		} else {
		}

		return sudokuEntry.getOptions()
				.stream()
				.map(options -> {
					return algorithm(newestSudokuGenerateKey.replaceFirst("0", options.toString()));
				})
				.filter(Objects::nonNull)
				.findFirst()
				.orElse(null);
	}
}
