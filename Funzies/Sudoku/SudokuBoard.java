package Funzies.Sudoku;

import java.util.ArrayList;

import Funzies.Games.*;

public class SudokuBoard implements Board {
	private static final int SIDE_LENGTH = 9;
	private static final int QUADRANT_WIDTH = 3;
	private static final int DEFAULT_VALUE = 0;
	private SudokuTile[][] tiles;
	private int lastUsedRow = -1, lastUsedCol = -1; 
	
	//Dynamically generated sudoku board, no logic what so ever for this yet
	public SudokuBoard() {
		
	}
	
	//Passed initial sudoku values
	public SudokuBoard(int[][] values) throws Exception {
		if (values.length != SIDE_LENGTH || values[0].length != SIDE_LENGTH)
			throw new Exception("Dimensions of values do not match dimensions of board.");
		
		SudokuTile.setNumRange(SIDE_LENGTH);
		int r, c;
		tiles = new SudokuTile[SIDE_LENGTH][SIDE_LENGTH];
		for (r = 0; r < SIDE_LENGTH; r++) {
			for (c = 0; c < SIDE_LENGTH; c++) {
				tiles[r][c] = new SudokuTile(values[r][c], SIDE_LENGTH);
			}
		}
	}	
	
	public boolean isGameOver() {
		int r, c;
		for (r = 0; r < SIDE_LENGTH; r++) {
			for (c = 0; c < SIDE_LENGTH; c++) {
				if (tiles[r][c].getValue() == DEFAULT_VALUE)
					return false;
			}
		}
		return true;
	}
	
	///RESUME HERE!!!!-------------------------------------------------------------
	public boolean calculatePossibleValues(int row, int col) {
		if (tiles[row][col].getValue() != DEFAULT_VALUE)
			return false;
		
		int r, c, i;
		ArrayList<Integer> usedVals = new ArrayList<Integer>();
		ArrayList<Integer> potentialVals = new ArrayList<Integer>();
		
		//Calculate existing (used) quadrant values
		int rowQuadStart = row / QUADRANT_WIDTH, colQuadStart = col / QUADRANT_WIDTH;
		for (r = 0; r < QUADRANT_WIDTH; r++) {
			for (c = 0; c < QUADRANT_WIDTH; c++) {
				int temp = tiles[rowQuadStart + r][colQuadStart + c].getValue();
				//System.out.print(temp);
				if (temp != DEFAULT_VALUE)
					usedVals.add(temp);
			}
			//System.out.println();
		}
		
		//Calculate existing (used) row values
		for (c = 0; c < SIDE_LENGTH; c++) {
			int temp = tiles[row][c].getValue();
			//System.out.print(temp);
			if (temp != DEFAULT_VALUE && !usedVals.contains(temp))
				usedVals.add(temp);
		}
		//System.out.println();
		
		//Calculate existing (used) column values
		for (r = 0; r < SIDE_LENGTH; r++) {
			int temp = tiles[r][col].getValue();
			//System.out.print(temp);
			if (temp != DEFAULT_VALUE && !usedVals.contains(temp))
				usedVals.add(temp);
		}
		//System.out.println();
		
		
		for (i = 1; i <= SIDE_LENGTH; i++) {
			if (!usedVals.contains(i))
				potentialVals.add(i);
		}
		
		if (potentialVals.size() == 1) {
			tiles[row][col].setValue(potentialVals.get(0));
		}
		
		tiles[row][col].setPossibleValues(potentialVals);
		
//		System.out.println("Potential values:");
//		for (i = 0; i < potentialVals.size(); i++)
//			System.out.print(potentialVals.get(i) + " ");
//		
//		System.out.println("\nused values:");
//		for (i = 0; i < usedVals.size(); i++)
//			System.out.print(usedVals.get(i) + " ");
//		System.out.println();
		
		lastUsedRow = row;
		lastUsedCol = col;
		//print();
		
		return false;
	}
	//-----------------------------------------------------------------------------
	
	public SudokuTile getTile(int x, int y) {
		return tiles[x][y];
	}
	public int getRows(){
		return SIDE_LENGTH;
	}
	public int getCols() {
		return SIDE_LENGTH;
	}
	
	public void print() {
		int r, c;
		for (r = 0; r < SIDE_LENGTH; r++) {
			System.out.print("| ");
			for (c = 0; c < SIDE_LENGTH; c++) {
				if (r == lastUsedRow && c == lastUsedCol)
					System.out.print("X |");
				else
					System.out.print(tiles[r][c] + " |");
				if (c % 3 == 2)
					System.out.print("|");
				System.out.print(" ");
			}
			System.out.println("\n----------------------------------------");
			if (r % 3 == 2)
				System.out.println("----------------------------------------");
		}
	}
}
