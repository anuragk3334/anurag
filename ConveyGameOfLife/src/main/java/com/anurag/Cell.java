/**
 * 
 */
package com.anurag;

/**
 * @author AnuragK
 * 
 */
public interface Cell {

	/**
	 * attaching the cell with all the neighbours cell (diagonal,adjacent)
	 */
	void init();

	/**
	 * begin evolution period which can change the cell value/state which
	 * changes the current state and copy to next state
	 */
	void startEvolution();

	/**
	 * After endof evolution,the next state will be copied to current state
	 */
	void endEvolution();

	/**
	 * Current status of cell (ALIVE or DEAD)
	 */
	CellState getCurrentValue();

	void setCurrentValue(CellState currentValue);

	/**
	 * After evolution the temporary value of cell
	 */
	CellState getNextValue();

	void setNextValue(CellState nextValue);

}
