package com.anurag;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AnuragK Other than Border cell
 */
public class NormalCell implements Cell {

	private int x;
	private int y;
	private Universe universe;
	private List<Cell> neighbors = new ArrayList<Cell>();
	private CellState currentValue;
	private CellState nextValue;

	public NormalCell(Universe universe, int x, int y) {
		this.universe = universe;
		this.x = x;
		this.y = y;
		setCurrentValue(CellState.DEAD);

	}

	/**
	 * attaching the cell with all the neighbours cell (diagonal,adjacent)
	 */
	@Override
	public void init() {
		for (int neighborX = x - 1; neighborX <= x + 1; neighborX++) {
			for (int neighborY = y - 1; neighborY <= y + 1; neighborY++) {
				if (neighborX != x || neighborY != y) {
					neighbors.add(universe.getCell(neighborX, neighborY));
				}
			}
		}
	}

	@Override
	public void startEvolution() {
		nextValue = checkSurvival(currentValue, countAliveNeighbors(neighbors));

	}

	@Override
	public void endEvolution() {
		currentValue = nextValue;

	}

	@Override
	public void setNextValue(CellState nextValue) {
		this.nextValue = nextValue;

	}

	private static int countAliveNeighbors(Iterable<Cell> neighbors) {
		int neighborsAlive = 0;

		for (Cell neighbor : neighbors) {

			if (neighbor.getCurrentValue().equals(CellState.ALIVE)) {
				neighborsAlive++;
			}
		}

		return neighborsAlive;
	}

	/**
	 * @param currentState
	 * @param neighborsAlive
	 * @return Any live cell with fewer than two live neighbours dies, as if
	 *         caused by under-population. Any live cell with two or three live
	 *         neighbours lives on to the next generation. Any live cell with
	 *         more than three live neighbours dies, as if by overcrowding. Any
	 *         dead cell with exactly three live neighbours becomes a live cell,
	 *         as if by reproduction
	 */
	private static CellState checkSurvival(CellState currentState,
			int neighborsAlive) {
		switch (neighborsAlive) {
		case 0:
		case 1:
			return CellState.DEAD;

		case 2:
			return currentState;

		case 3:
			return CellState.ALIVE;

		default:
			return CellState.DEAD;
		}
	}

	@Override
	public CellState getCurrentValue() {

		return currentValue;
	}

	@Override
	public void setCurrentValue(CellState currentValue) {
		this.currentValue = currentValue;

	}

	@Override
	public CellState getNextValue() {

		return nextValue;
	}

}
