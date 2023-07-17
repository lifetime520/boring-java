package org.castiello.game.sudoku.algo.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.castiello.game.sudoku.algo.ISolveAlgorithm;
import org.castiello.game.sudoku.dto.SudokuEntry;
import org.castiello.game.sudoku.dto.SudokuItem;
import org.castiello.game.sudoku.enums.SudokuElement;

public class BFSAlgorithm implements ISolveAlgorithm<String> {
	public static Logger log = LogManager.getLogger(BFSAlgorithm.class);
	public static final List<String> EMPTY = new ArrayList<>();
	public static final BFSAlgorithm INSTANCE = new BFSAlgorithm();

	@Override
	public String algorithm(SudokuEntry[][] sudokuEntrys) {
		String sudokuGenerateKey = GenerateKeyAlgorithm.INSTANCE.algorithm(sudokuEntrys);
		SudokuEntry sudokuEntry = Arrays.asList(sudokuEntrys)
				.stream()
				.flatMap(arrays -> Arrays.asList(arrays).stream().filter(_sudokuEntry -> _sudokuEntry.getAns() == SudokuElement.EMPTY))
				.findFirst()
				.orElseGet(() -> SudokuEntry.EMPTY);
		if (sudokuEntry == SudokuEntry.EMPTY) return sudokuGenerateKey;

//		log.info("gKey:  {}", sudokuGenerateKey);
		return sudokuEntry.getOptions()
//				.parallelStream()
				.stream()
				.map(options -> {
					String _sudokuGenerateKey = sudokuGenerateKey.replaceFirst("0", options.toString());
					SudokuItem _item = new SudokuItem(sudokuGenerateKey + ";" + options.ordinal());
					boolean result = _item.setEntries(_sudokuGenerateKey);
//					log.info("r:{}, option:{}, _gKey: {}", result, options, _sudokuGenerateKey);
					if (!result) {
						log.info("skip  gKey:  {}", _sudokuGenerateKey);
						return null;
					}
					if (_item.isComplete()) {
						log.info("final gKey:  {}", _sudokuGenerateKey);
						return _sudokuGenerateKey;
					} else {
						_item.algorithm(ConstraintAlgorithm.INSTANCE);
						if ((_sudokuGenerateKey = _item.toString()).indexOf("0") == -1) {
							log.info("final cKey:  {}", _sudokuGenerateKey);
						} 
						return _item.algorithm(INSTANCE);
					}
				})
				.filter(Objects::nonNull)
				.findAny().orElse(null);
	}
}
