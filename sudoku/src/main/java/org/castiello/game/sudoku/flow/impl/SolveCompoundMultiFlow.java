package org.castiello.game.sudoku.flow.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.algo.impl.CompoundMultiSolutionAlgorithm;
import org.castiello.game.sudoku.flow.IFLow;
import org.castiello.game.sudoku.item.impl.SudokuItem;

public class SolveCompoundMultiFlow implements IFLow<String, List<String>> {
	public static final Logger log = LogManager.getLogger(SolveCompoundMultiFlow.class);

	@Override
	public List<String> solving(String input) {
		final long start = System.currentTimeMillis();
		if (input.length() != 81) return null;

		log.trace("prepare to init SudokuItem");
		final SudokuItem item = new SudokuItem("input/" + input);
		log.trace("SudokuItem object ready");
		final boolean rInit = item.setEntries(input);
		log.trace("SudokuItem loaded matrix");
		if (!rInit) {
			log.warn("Illegal!! When initial.");
			return null;
		}

		log.trace("SudokuItem try solve by using CompoundMultiSolutionAlgorithm");
		final List<String> ansKeys= item.algorithm(CompoundMultiSolutionAlgorithm.INSTANCE);
		log.trace("SudokuItem tied solve by using CompoundMultiSolutionAlgorithm");
		if (!ansKeys.isEmpty()) {
			log.info("ansKeys: {}", ansKeys.size());
			ansKeys.forEach(ansKey -> {
				final SudokuItem ans = new SudokuItem("CompoundMultiSolutionAlgorithm/" + input);
				ans.setEntries(ansKey);
				ans.print();
			});
		} else {
			log.warn("Illegal!! When CompoundMultiSolutionAlgorithm.");
			return null;
		}
		log.info("solveByCompoundAlgorithm cost: {}ms", System.currentTimeMillis() - start);

		return ansKeys;
	}

}
