package Funzies.Sudoku;

import Funzies.Games.Board;

public class SudokuQuadrant implements Board {
	private final int HEIGHT = 9;
	private final int WIDTH = 9;
	private SudokuTile[][] tiles;
	
	public SudokuTile getTile(int x, int y) {
		return tiles[x][y];
	}
	public int getWidth(){
		return WIDTH;
	}
	public int getHeight() {
		return HEIGHT;
	}
	
	public void print() {
		int i, j;
		for (i = 0; i < WIDTH; i++) {
			for (j = 0; j < HEIGHT; j++) {
				System.out.print(tiles[i][j] + " ");
			}
			System.out.println();
		}
	}
}
