package com.anurag;

/**
 * @author AnuragK Universe is collection of 2D cells
 */

public class Universe {

	private Cell[] cells;
	private int width;
	private int height;
	private long generation;
	private long interval;

	public Universe(int width, int height) {

		this.width = width;
		this.height = height;
		this.cells = new Cell[width * height];
		initCell(width, height);

	}

	/**
	 * @param width
	 * @param height
	 *            populate cells with (x,y) cordinate and attach with the
	 *            neighbour cell
	 */
	private void initCell(int width, int height) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				boolean isBorderCell = isBorderCell(width, height, x, y);
				cells[y * width + x] = CellFactory.createCell(this, x, y,
						isBorderCell);
			}
		}

		for (Cell cell : cells) {
			cell.init();
		}
	}

	/**
	 * evolulation processing of all the cell and change the current status
	 * according to the algorithm
	 */
	public void doEvolution() {
		long start = System.currentTimeMillis();

		for (Cell cell : cells) {
			cell.startEvolution();
		}
		for (Cell cell : cells) {
			cell.endEvolution();
		}

		generation++;
		interval = System.currentTimeMillis() - start;
	}

	/**
	 * getting cells at co-rdinate(x,y)
	 * 
	 */

	public Cell getCell(int x, int y) {
		return cells[y * width + x];
	}

	/**
	 * @param width
	 * @param height
	 * @param x
	 * @param y
	 * @return check if the cell is border cell or not
	 */
	private boolean isBorderCell(final int width, final int height,
			final int x, final int y) {
		if (x == 0) {
			return true;
		}
		if (y == 0) {
			return true;
		}
		if (x == width - 1) {
			return true;
		}
		if (y == height - 1) {
			return true;
		}
		return false;
	}

	public Cell[] getCells() {
		return cells;
	}

	public void setCells(Cell[] cells) {
		this.cells = cells;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public long getGeneration() {
		return generation;
	}

	public void setGeneration(long generation) {
		this.generation = generation;
	}

	public long getInterval() {
		return interval;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}

}
