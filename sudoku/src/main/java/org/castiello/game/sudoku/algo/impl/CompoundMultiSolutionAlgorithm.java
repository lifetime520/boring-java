package org.castiello.game.sudoku.algo.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.algo.ISolveAlgorithm;
import org.castiello.game.sudoku.dto.SudokuEntry;
import org.castiello.game.sudoku.enums.SudokuElement;
import org.castiello.game.sudoku.item.impl.SudokuItem;

public class CompoundMultiSolutionAlgorithm implements ISolveAlgorithm<List<String>> {
	public static final Logger log = LogManager.getLogger(CompoundMultiSolutionAlgorithm.class);
	public static final List<String> EMPTY = List.of();
	public static final CompoundMultiSolutionAlgorithm INSTANCE = new CompoundMultiSolutionAlgorithm();

	@Override
	public List<String> algorithm(SudokuEntry[][] sudokuEntrys) {
		final String sudokuGenerateKey = GenerateKeyAlgorithm.INSTANCE.algorithm(sudokuEntrys);
		return algorithm(sudokuGenerateKey);
	}

	public List<String> algorithm(String sudokuGenerateKey) {
		final SudokuItem preCheckItem = new SudokuItem("preCheckItem/" + sudokuGenerateKey);
		final boolean preCheckInit = preCheckItem.setEntries(sudokuGenerateKey);
		if (!preCheckInit) {
			if (log.isTraceEnabled()) {
				log.trace("skip @1   gKey:  {}", sudokuGenerateKey);
				preCheckItem.print();
				preCheckItem.printOptions();
			}
			return EMPTY;
		}

		preCheckItem.algorithm(ConstraintAlgorithm.INSTANCE);

		final String newestSudokuGenerateKey = preCheckItem.toString();
		if (preCheckItem.isComplete()) {
			return List.of(newestSudokuGenerateKey);
		}

		final SudokuEntry[][] sudokuEntrys = preCheckItem.getSudokuEntrys();
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
			return EMPTY;
		}

		return sudokuEntry.getOptions()
				.stream()
				.flatMap(options -> {
					List<String> ansList = algorithm(newestSudokuGenerateKey.replaceFirst("0", options.toString()));
					return ansList.stream();
				})
				.collect(Collectors.toList());
	}
}
