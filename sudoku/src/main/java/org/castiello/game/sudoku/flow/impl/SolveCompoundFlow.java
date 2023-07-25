package org.castiello.game.sudoku.flow.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.algo.impl.CompoundAlgorithm;
import org.castiello.game.sudoku.flow.IFLow;
import org.castiello.game.sudoku.item.impl.SudokuItem;

public class SolveCompoundFlow implements IFLow<String, String> {
	public static final Logger log = LogManager.getLogger(SolveCompoundFlow.class);

	@Override
	public String solving(String input) {
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

		log.trace("SudokuItem try solve by using CompoundAlgorithm");
		final String ansKey = item.algorithm(CompoundAlgorithm.INSTANCE);
		log.trace("SudokuItem tied solve by using CompoundAlgorithm");
		if (ansKey != null) {
			final SudokuItem ans = new SudokuItem("CompoundAlgorithm/" + input);
			ans.setEntries(ansKey);
			ans.print();
		} else {
			log.warn("Illegal!! When CompoundAlgorithm.");
			return null;
		}
		log.info("solveByCompoundAlgorithm cost: {}ms", System.currentTimeMillis() - start);

		return ansKey;
	}

}
