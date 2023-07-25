package org.castiello.game.sudoku.algo.impl;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.algo.ISolveAlgorithm;
import org.castiello.game.sudoku.dto.SudokuEntry;
import org.castiello.game.sudoku.enums.SudokuElement;
import org.castiello.game.sudoku.item.impl.SudokuItem;
import org.castiello.game.sudoku.util.SudokuItemUtils;

public class CompoundMultiSolutionAlgorithm implements ISolveAlgorithm<List<String>> {
	public static final Logger log = LogManager.getLogger(CompoundMultiSolutionAlgorithm.class);
	public static final List<String> EMPTY = List.of();
	public static final CompoundMultiSolutionAlgorithm INSTANCE = new CompoundMultiSolutionAlgorithm();
	public static final AtomicBoolean collectAns = new AtomicBoolean(false);
	public static final AtomicLong cnt = new AtomicLong();

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
		};

		// quick way
		preCheckItem.algorithm(ConstraintAlgorithm.INSTANCE);

		// store current key
		final String newestSudokuGenerateKey = preCheckItem.toString();
		if (preCheckItem.isComplete()) {
			if (!collectAns.get()) {
//				log.info("final     gKey:  {}", newestSudokuGenerateKey);
				cnt.incrementAndGet();
			}
			return List.of(newestSudokuGenerateKey);
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
			return EMPTY;
		} else {
		}

//		log.info("cnt:{}", cnt.get());
		return sudokuEntry.getOptions()
//				.stream()
				.parallelStream()
				.flatMap(options -> {
					List<String> ansList = algorithm(newestSudokuGenerateKey.replaceFirst("0", options.toString()));
					return collectAns.get() ? ansList.stream() : EMPTY.stream();
				})
				.collect(Collectors.toList());
	}
}
