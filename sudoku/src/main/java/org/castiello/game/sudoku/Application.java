package org.castiello.game.sudoku;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.flow.impl.SolveCompoundFlow;
import org.castiello.game.sudoku.flow.impl.SolveCompoundMultiFlow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Application {
	public static final Logger log = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		Scanner sc = new Scanner(System.in);
//		String input = sc.next("\\d+");
		String inputZero     = "000000000000000000000000000000000000000000000000000000000000000000000000000000000";
		String inputEazy     = "800203004492000753100594002950010038024658910710030026600821005273000841500307009";
		String inputMiddle   = "306204001092670005008100726030006010800720000060005070005800647083540002704901003";
		String inputHard     = "602091578807006109100500460594030080006000200070060345065003004701600903483910706";
		String inputVeryHard = "000000082090050410000208900780000631000000000342000079009703000037060050420000000";

		SolveCompoundFlow scf = new SolveCompoundFlow();
		SolveCompoundMultiFlow scmf = new SolveCompoundMultiFlow();
//		scmf.solving(inputZero);
		scmf.solving(inputEazy);
		scmf.solving(inputMiddle);
		scmf.solving(inputHard);
		scmf.solving(inputVeryHard);
		scf.solving(inputZero);
		scf.solving(inputEazy);
		scf.solving(inputMiddle);
		scf.solving(inputHard);
		scf.solving(inputVeryHard);
	}
}