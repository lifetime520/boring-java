package org.castiello.game.sudoku;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.algo.CompoundAlgorithm;
import org.castiello.game.sudoku.dto.SudokuItem;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static final Logger log = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
//		SpringApplication.run(SudokuApplication.class, args);
//		Scanner sc = new Scanner(System.in);
//		String input = sc.next("\\d+");
		String input = "602091578807006109100500460594030080006000200070060345065003004701600903483910706";
		solveByCompoundAlgorithm(input);
	}

	public static void solveByCompoundAlgorithm(String input) {
		if (input.length() != 81) return;

		log.info("prepare to init SudokuItem");
		SudokuItem item = new SudokuItem("org");
		log.info("SudokuItem object ready");
		boolean r = item.setEntries(input);
		log.info("SudokuItem loaded matrix");
		if (!r) {
			log.warn("Illegal!! When initial.");
			return;
		}

		log.info("SudokuItem try solve by using CompoundAlgorithm");
		String ansKey = item.algorithm(CompoundAlgorithm.INSTANCE);
		log.info("SudokuItem tied solve by using CompoundAlgorithm");
		if (ansKey != null) {
			SudokuItem ans = new SudokuItem("CompoundAlgorithm");
			ans.setEntries(ansKey);
			ans.print("After CompoundAlgorithm");
		} else {
			log.warn("Illegal!! When BFSAlgorithm.");
			return;
		}
	}
}