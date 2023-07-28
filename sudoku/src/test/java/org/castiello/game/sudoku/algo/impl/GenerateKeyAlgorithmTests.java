package org.castiello.game.sudoku.algo.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.item.impl.SudokuItem;
import org.castiello.game.sudoku.util.SudokuItemUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GenerateKeyAlgorithmTests {
	private final Logger log = LogManager.getLogger(GenerateKeyAlgorithmTests.class);

	@Test
	public void algorithmTest() {
		String inputEazy     = "800203004492000753100594002950010038024658910710030026600821005273000841500307009";
		log.info("[MN:algorithmTest] input: {}", inputEazy);
		SudokuItem si = new SudokuItem("GenerateKeyAlgorithmTests");
		si.setEntries(inputEazy);

		assertEquals(inputEazy, GenerateKeyAlgorithm.INSTANCE.algorithm(SudokuItemUtils.getSudokuEntrys(si)));
	}
}
