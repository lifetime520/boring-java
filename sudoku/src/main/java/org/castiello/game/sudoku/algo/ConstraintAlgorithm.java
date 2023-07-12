package org.castiello.game.sudoku.algo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.SudokuElement;
import org.castiello.game.sudoku.dto.SudokuEntry;

public class ConstraintAlgorithm implements IAlgorithm<Boolean> {
	public static Logger log = LogManager.getLogger(ConstraintAlgorithm.class);
	public static final ConstraintAlgorithm INSTANCE = new ConstraintAlgorithm();

	@Override
	public Boolean algorithm(SudokuEntry[][] sudokuEntrys) {
		boolean conti = true;
		int round = 0;
		while (conti) {
			List<SudokuEntry> sudokuEntryList = Arrays.asList(sudokuEntrys)
					.parallelStream()
					.flatMap(arrays -> Arrays.asList(arrays).stream())
					.filter(_sudokuEntry -> _sudokuEntry.getAns().ordinal() == 0 && _sudokuEntry.getOptions().size() == 1)
					.collect(Collectors.toList());

			if (conti = !sudokuEntryList.isEmpty()) {
				for (SudokuEntry sudokuEntry: sudokuEntryList) {
					SudokuElement sudokuElementAns = sudokuEntry.getOptions().stream().findAny().orElseGet(() -> SudokuElement.EMPTY);
					if (sudokuElementAns == SudokuElement.EMPTY) continue;
					sudokuEntry.setAns(sudokuElementAns);
				}
				log.info("[AlgorithmByConstraint] round: {}, elements: {}", ++round, sudokuEntryList.size());
			}
		}
		return round != 0;
	}
}
