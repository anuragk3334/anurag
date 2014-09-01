package com.anurag;

public class CellFactory {

	public static Cell createCell(Universe universe,int x, int y, boolean isBorderCell) {
		if (isBorderCell) {
			return new BorderCell(universe,x,y);
		} else {
			return new NormalCell(universe,x,y);
		}
	}

}
