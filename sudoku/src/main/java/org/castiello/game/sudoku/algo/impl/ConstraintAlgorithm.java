package org.castiello.game.sudoku.algo.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.algo.ISolveAlgorithm;
import org.castiello.game.sudoku.dto.SudokuEntry;
import org.castiello.game.sudoku.enums.SudokuElement;

public class ConstraintAlgorithm implements ISolveAlgorithm<Boolean> {
	public static final Logger log = LogManager.getLogger(ConstraintAlgorithm.class);
	public static final ConstraintAlgorithm INSTANCE = new ConstraintAlgorithm();
	public final Comparator<SudokuEntry> comparator = (o1, o2) -> Integer.compare(o1.getOptions().size(), o2.getOptions().size());

	@Override
	public Boolean algorithm(SudokuEntry[][] sudokuEntrys) {
		int round = 0;
		final List<SudokuEntry> reusedSudokuEntryList = Arrays.asList(sudokuEntrys)
				.stream()
				.flatMap(arrays -> Arrays.asList(arrays).stream().filter(_sudokuEntry -> _sudokuEntry.getAns() == SudokuElement.EMPTY))
				.sorted(comparator)
				.collect(Collectors.toList());

		while (!reusedSudokuEntryList.isEmpty() && reusedSudokuEntryList.get(0).getOptions().size() == 1) {
			final int orgSize = reusedSudokuEntryList.size();
			final Iterator<SudokuEntry> it = reusedSudokuEntryList.iterator();
			while (it.hasNext()) {
				final SudokuEntry sudokuEntry = it.next();
				if (sudokuEntry.getOptions().size() != 1) continue;
				it.remove();

				sudokuEntry.setAns(sudokuEntry.getOptions().iterator().next());
			}
			log.trace("[AlgorithmByConstraint] round: {}, elements: {}", ++round, orgSize - reusedSudokuEntryList.size());

			Collections.sort(reusedSudokuEntryList, comparator);
		}

		return round != 0;
	}
}
