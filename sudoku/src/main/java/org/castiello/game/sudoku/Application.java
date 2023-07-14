package org.castiello.game.sudoku;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.algo.CompoundAlgorithm;
import org.castiello.game.sudoku.algo.CompoundMultiSolutionAlgorithm;
import org.castiello.game.sudoku.dto.SudokuItem;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static final Logger log = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
//		SpringApplication.run(SudokuApplication.class, args);
//		Scanner sc = new Scanner(System.in);
//		String input = sc.next("\\d+");
		String inputZ  = "000000000000000000000000000000000000000000000000000000000000000000000000000000000";
		String inputE  = "800203004492000753100594002950010038024658910710030026600821005273000841500307009";
		String inputM  = "306204001092670005008100726030006010800720000060005070005800647083540002704901003";
		String inputH  = "602091578807006109100500460594030080006000200070060345065003004701600903483910706";
		String inputVH = "000000082090050410000208900780000631000000000342000079009703000037060050420000000";
		solveByCompoundMultiSolutionAlgorithm(inputZ);
//		CompoundMultiSolutionAlgorithm.collectAns.set(true);
//		solveByCompoundMultiSolutionAlgorithm(inputE);
//		solveByCompoundMultiSolutionAlgorithm(inputM);
//		solveByCompoundMultiSolutionAlgorithm(inputH);
//		solveByCompoundMultiSolutionAlgorithm(inputVH);
//		CompoundMultiSolutionAlgorithm.collectAns.set(false);
//		solveByCompoundAlgorithm(inputZ);
//		solveByCompoundAlgorithm(inputE);
//		solveByCompoundAlgorithm(inputM);
//		solveByCompoundAlgorithm(inputH);
//		solveByCompoundAlgorithm(inputVH);
	}

	public static void solveByCompoundAlgorithm(String input) {
		final long start = System.currentTimeMillis();
		if (input.length() != 81) return;

		log.trace("prepare to init SudokuItem");
		final SudokuItem item = new SudokuItem("input/" + input);
		log.trace("SudokuItem object ready");
		final boolean rInit = item.setEntries(input);
		log.trace("SudokuItem loaded matrix");
		if (!rInit) {
			log.warn("Illegal!! When initial.");
			return;
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
			return;
		}
		log.info("solveByCompoundAlgorithm cost: {}ms", System.currentTimeMillis() - start);
	}

	public static void solveByCompoundMultiSolutionAlgorithm(String input) {
		final long start = System.currentTimeMillis();
		if (input.length() != 81) return;

		log.trace("prepare to init SudokuItem");
		final SudokuItem item = new SudokuItem("input/" + input);
		log.trace("SudokuItem object ready");
		final boolean rInit = item.setEntries(input);
		log.trace("SudokuItem loaded matrix");
		if (!rInit) {
			log.warn("Illegal!! When initial.");
			return;
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
			return;
		}
		log.info("solveByCompoundAlgorithm cost: {}ms", System.currentTimeMillis() - start);
	}
}