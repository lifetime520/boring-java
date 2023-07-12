package org.castiello.game.sudoku;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.algo.BFSAlgorithm;
import org.castiello.game.sudoku.algo.ConstraintAlgorithm;
import org.castiello.game.sudoku.dto.SudokuItem;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static Logger log = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
//		SpringApplication.run(SudokuApplication.class, args);
//		Scanner sc = new Scanner(System.in);
//		String input = sc.next("\\d+");
		String input = "602091578807006109100500460594030080006000200070060345065003004701600903483910706";
		solveByDFSAlgorithm(input);
	}

	public static void solveByDFSAlgorithm(String input) {
		if (input.length() != 81) return;

		SudokuItem item = new SudokuItem("org");
		boolean r = item.setEntries(input);
//		log.info("init status: {}", r);
//		item.print("After input");
		if (!r) {
			log.warn("Illegal!! When initial.");
			return;
		}

		log.info("go ConstraintAlgorithm");
		r = item.algorithm(ConstraintAlgorithm.INSTANCE);
		item.print("After ConstraintAlgorithm");
		if (!r) {
			log.warn("Illegal!! When ConstraintAlgorithm.");
			return;
		}

		log.info("go DFSAlgorithm");
		String gKey = item.algorithm(BFSAlgorithm.INSTANCE);
//		log.info(" gKeys: {}", gKeys);
		if (gKey != null) {
			item = new SudokuItem("BFSAlgorithm");
			item.setEntries(gKey);
			item.print("After BFSAlgorithm");
		} else {
			log.warn("Illegal!! When BFSAlgorithm.");
			return;
		}
//		item.printOptions();

//		log.info("{}", item.toString());
	}
}