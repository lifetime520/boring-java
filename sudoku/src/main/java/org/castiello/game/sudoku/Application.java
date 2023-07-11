package org.castiello.game.sudoku;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.dto.SudokuItem;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static Logger log = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
//		SpringApplication.run(SudokuApplication.class, args);
//		Scanner sc = new Scanner(System.in);
//		String input = sc.next("\\d+");
		solveProblem();
	}

	public static void solveProblem() {
		String input = "602091578807006109100500460594030080006000200070060345065003004701600903483910706";
		if (input.length() != 81) return;

		SudokuItem item = new SudokuItem("org");
		for (int r = 0; r < 9; r++)
			for (int c = 0; c < 9; c++) {
				item.setEntry(r, c, String.valueOf((char) input.charAt(r * 9 + c)));
			}
		item.print("After input");

		item.algorithm1();

		item.print("After autoMode");
		item.printOptions();

		log.info("{}", item.toString());
	}
}