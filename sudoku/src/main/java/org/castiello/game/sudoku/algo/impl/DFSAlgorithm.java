package org.castiello.game.sudoku.algo.impl;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.algo.ISolveAlgorithm;
import org.castiello.game.sudoku.dto.SudokuEntry;
import org.castiello.game.sudoku.enums.SudokuElement;
import org.castiello.game.sudoku.item.impl.SudokuItem;

public class DFSAlgorithm implements ISolveAlgorithm<String> {
	public static final Logger log = LogManager.getLogger(DFSAlgorithm.class);
	public static final DFSAlgorithm INSTANCE = new DFSAlgorithm();

	@Override
	public String algorithm(SudokuEntry[][] sudokuEntrys) {
		final String sudokuGenerateKey = GenerateKeyAlgorithm.INSTANCE.algorithm(sudokuEntrys);
		return algorithm(sudokuGenerateKey);
	}

	public String algorithm(String sudokuGenerateKey) {
		final SudokuItem item = new SudokuItem("DFS/" + sudokuGenerateKey);
		if (!item.setEntries(sudokuGenerateKey)) {
			return null;
		}

		item.algorithm(ConstraintAlgorithm.INSTANCE);

		if (item.isComplete()) {
			return item.toString();
		}

		final SudokuEntry[][] entrys = item.getSudokuEntrys();
		final SudokuEntry target = Arrays.asList(entrys)
				.stream()
				.flatMap(arrays -> Arrays.asList(arrays).stream()
						.filter(e -> e.getAns() == SudokuElement.EMPTY))
				.min((a, b) -> Integer.compare(a.getOptions().size(), b.getOptions().size()))
				.orElse(null);

		if (target == null || target.getOptions().isEmpty()) {
			return null;
		}

		final String currentKey = item.toString();
		for (SudokuElement option : target.getOptions()) {
			String result = algorithm(currentKey.replaceFirst("0", option.toString()));
			if (result != null) {
				return result;
			}
		}
		return null;
	}
}
