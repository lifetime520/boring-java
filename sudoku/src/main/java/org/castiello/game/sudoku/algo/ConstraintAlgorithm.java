package org.castiello.game.sudoku.algo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.SudokuElement;
import org.castiello.game.sudoku.dto.SudokuEntry;

public class ConstraintAlgorithm implements IAlgorithm<Boolean> {
	public static final Logger log = LogManager.getLogger(ConstraintAlgorithm.class);
	public static final ConstraintAlgorithm INSTANCE = new ConstraintAlgorithm();

	@Override
	public Boolean algorithm(SudokuEntry[][] sudokuEntrys) {
		boolean conti = true;
		int round = 0;
		while (conti) {
			final List<SudokuEntry> sudokuEntryList = Arrays.asList(sudokuEntrys)
					.parallelStream()
					.flatMap(arrays -> Arrays.asList(arrays).stream())
					.filter(_sudokuEntry -> _sudokuEntry.getAns() == SudokuElement.EMPTY && _sudokuEntry.getOptions().size() == 1)
					.collect(Collectors.toList());

			if (conti = !sudokuEntryList.isEmpty()) {
				for (SudokuEntry sudokuEntry: sudokuEntryList) {
					if (sudokuEntry.getOptions().isEmpty()) continue;

					final SudokuElement sudokuElementAns = sudokuEntry.getOptions().iterator().next();
					sudokuEntry.setAns(sudokuElementAns);
				}
				log.info("[AlgorithmByConstraint] round: {}, elements: {}", ++round, sudokuEntryList.size());
			}
		}
		return round != 0;
	}
}
