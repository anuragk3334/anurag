package com.anurag;

public class UniverseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Universe universe=new Universe(5, 5);
		Cell[] cells = universe.getCells();
		Cell cell1=cells[1];
		Cell cell11=cells[11];
		Cell cell12=cells[12];
		Cell cell13=cells[13];
		Cell cell7=cells[7];
		Cell cell8=cells[8];
		Cell cell17=cells[17];
	 /*   cell12.setCurrentValue(CellState.ALIVE);
	    cell13.setCurrentValue(CellState.ALIVE);*/
		
		//cell1.setCurrentValue(CellState.ALIVE);
		Cell cell16=cells[16];
		cell16.setCurrentValue(CellState.ALIVE);
		cell11.setCurrentValue(CellState.ALIVE);
		cell12.setCurrentValue(CellState.ALIVE);
		cell17.setCurrentValue(CellState.ALIVE);
		
		universe.doEvolution();
		System.out.println("cell next val " + cell16.getNextValue());
		//System.out.println("cell next val " + cell13.getNextValue());
		
		System.out.println("cell val " + cell16.getCurrentValue());
		//System.out.println("cell val " + cell13.getCurrentValue());
		//universe.doEvolution();
		//System.out.println(cell13.getNextValue());
		

	}

}
