package com.anurag;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AnuragK Border cell state would be always "DEAD"
 * 
 */
public class BorderCell implements Cell {

	private int x ;
	private int y ;
	private Universe universe;
	private List<Cell> neighbors=new ArrayList<Cell>();

	public BorderCell(Universe universe,int x, int y) {
		this.universe=universe;
		this.x = x;
		this.y = y;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startEvolution() {
		// TODO Auto-generated method stub

	}

	@Override
	public void endEvolution() {
		// TODO Auto-generated method stub

	}

	@Override
	public CellState getCurrentValue() {
		return CellState.DEAD;
	}

	@Override
	public void setCurrentValue(CellState currentValue) {
		throw new CellException("can't set Status explicitilty for BorderCell");

	}

	@Override
	public CellState getNextValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNextValue(CellState nextValue) {
		// TODO Auto-generated method stub

	}

}
