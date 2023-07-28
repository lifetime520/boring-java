package org.castiello.game.sudoku.dto;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.item.impl.SudokuItem;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SudokuItemTests {
	public static final Logger log = LogManager.getLogger(SudokuItemTests.class);

	@Test
	public void setEntriesTest() {
		String inputEazy     = "800203004492000753100594002950010038024658910710030026600821005273000841500307009";
		log.info("[MN:algorithmTest] input: {}", inputEazy);
		SudokuItem si = new SudokuItem("SudokuItemTests");
		assertTrue(si.setEntries(inputEazy));
	}

	@Test
	public void setEntriesFailTest() {
		String inputEazy     = "880203004492000753100594002950010038024658910710030026600821005273000841500307009";
		log.info("[MN:algorithmTest] input: {}", inputEazy);
		SudokuItem si = new SudokuItem("SudokuItemTests");
		assertFalse(si.setEntries(inputEazy));
	}

}
