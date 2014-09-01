/**
 * 
 */
package com.anurag.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.anurag.Cell;
import com.anurag.CellState;
import com.anurag.Universe;

/**
 * @author AnuragK
 * 
 */
public class UniverseTest {

	private Universe universe;
	Cell[] cells;

	@Before
	public void setUp() {
		universe = new Universe(5, 5);
		cells = universe.getCells();

	}

	/**
	 * Any live cell with fewer than two live neighbours dies, as if caused by
	 * under-population
	 */
	@Test
	public void TestForLiveCellWithLessThanTwoLiveNeighbour() {
		Cell cell16 = cells[16];
		// initially all the Cells are Dead
		cell16.setCurrentValue(CellState.ALIVE);
		universe.doEvolution();
		CellState expected = CellState.DEAD;
		Assert.assertEquals(expected, cell16.getCurrentValue());

	}

	/**
	 * Any live cell with two neighbours lives on to the next generation
	 */
	@Test
	public void TestForLiveCellWithTwoLiveNeighbours() {
		// testing for 17th cell
		Cell cell17 = cells[17];
		cell17.setCurrentValue(CellState.ALIVE);

		// setting two other neighbour cell to LIVE
		Cell cell18 = cells[18]; // adjacent cell
		Cell cell13 = cells[13];// diagonal cell
		cell18.setCurrentValue(CellState.ALIVE);
		cell13.setCurrentValue(CellState.ALIVE);

		CellState expected = CellState.ALIVE;
		universe.doEvolution();
		Assert.assertEquals(expected, cell17.getCurrentValue());
	}

	/**
	 * Any live cell with three neighbours lives on to the next generation
	 */
	@Test
	public void TestForLiveCellWithThreeLiveNeighbours() {
		// testing for 17th cell
		Cell cell17 = cells[17];
		cell17.setCurrentValue(CellState.ALIVE);

		// setting two other neighbour cell to LIVE
		Cell cell18 = cells[18]; // adjacent cell
		Cell cell13 = cells[13];// diagonal cell
		Cell cell11 = cells[11];// diagonal cell
		cell18.setCurrentValue(CellState.ALIVE);
		cell13.setCurrentValue(CellState.ALIVE);
		cell11.setCurrentValue(CellState.ALIVE);

		CellState expected = CellState.ALIVE;
		universe.doEvolution();
		Assert.assertEquals(expected, cell17.getCurrentValue());
	}

	/**
	 * Any live cell with more than three live neighbours dies, as if by
	 * overcrowding
	 */
	@Test
	public void TestForLiveCellWithMoreThanThreeLiveNeighbours() {
		// testing for 17th cell
		Cell cell17 = cells[17];
		cell17.setCurrentValue(CellState.ALIVE);

		// setting two other neighbour cell to LIVE
		Cell cell18 = cells[18]; // adjacent cell
		Cell cell13 = cells[13];// diagonal cell
		Cell cell11 = cells[11];// diagonal cell
		Cell cell16 = cells[16];// adjacent cell
		cell18.setCurrentValue(CellState.ALIVE);
		cell13.setCurrentValue(CellState.ALIVE);
		cell11.setCurrentValue(CellState.ALIVE);
		cell16.setCurrentValue(CellState.ALIVE);

		CellState expected = CellState.DEAD;
		universe.doEvolution();
		Assert.assertEquals(expected, cell17.getCurrentValue());
	}

	/**
	 * Any dead cell with exactly three live neighbours becomes a live cell, as
	 * if by reproduction
	 */
	@Test
	public void TestForDeadCellWithExactlyThreeLiveCells() {
		// testing for 17th cell
		Cell cell17 = cells[17];
		cell17.setCurrentValue(CellState.DEAD);

		// setting two other neighbour cell to LIVE
		Cell cell18 = cells[18]; // adjacent cell
		Cell cell13 = cells[13];// diagonal cell
		Cell cell11 = cells[11];// diagonal cell

		cell18.setCurrentValue(CellState.ALIVE);
		cell13.setCurrentValue(CellState.ALIVE);
		cell11.setCurrentValue(CellState.ALIVE);

		CellState expected = CellState.ALIVE;
		universe.doEvolution();
		Assert.assertEquals(expected, cell17.getCurrentValue());
	}

	/**
	 * Any dead cell with exactly three live neighbours becomes a live cell, as
	 * if by reproduction
	 */
	@Test
	public void TestForDeadCellWithMoreThanThreeLiveCells() {
		// testing for 17th cell
		Cell cell17 = cells[17];
		cell17.setCurrentValue(CellState.DEAD);

		// setting two other neighbour cell to LIVE
		Cell cell18 = cells[18]; // adjacent cell
		Cell cell13 = cells[13];// diagonal cell
		Cell cell11 = cells[11];// diagonal cell
		Cell cell12 = cells[12];// diagonal cell
		cell18.setCurrentValue(CellState.ALIVE);
		cell13.setCurrentValue(CellState.ALIVE);
		cell11.setCurrentValue(CellState.ALIVE);
		cell12.setCurrentValue(CellState.ALIVE);

		CellState expected = CellState.DEAD;
		universe.doEvolution();
		Assert.assertEquals(expected, cell17.getCurrentValue());
	}

	/**
	 * Any dead cell with exactly three live neighbours becomes a live cell, as
	 * if by reproduction
	 */
	@Test
	public void TestForDeadCellWithLessThanThreeLiveCells() {
		// testing for 17th cell
		Cell cell17 = cells[17];
		cell17.setCurrentValue(CellState.DEAD);

		// setting two other neighbour cell to LIVE
		Cell cell18 = cells[18]; // adjacent cell
		Cell cell13 = cells[13];// diagonal cell

		cell18.setCurrentValue(CellState.ALIVE);
		cell13.setCurrentValue(CellState.ALIVE);

		CellState expected = CellState.DEAD;
		universe.doEvolution();
		Assert.assertEquals(expected, cell17.getCurrentValue());
	}

}
