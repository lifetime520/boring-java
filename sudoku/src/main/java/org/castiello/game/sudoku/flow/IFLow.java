package org.castiello.game.sudoku.flow;

public interface IFLow<I, R> {

	R solving(I input);
}
