package Funzies.Sudoku;

import java.util.ArrayList;

public class SudokuTile {
	private static final int DEFAULT_VALUE = 0;
	private static int NUM_POSSIBLE;
	private int value;
	//private int[] possibleValues;
	private ArrayList<Integer> possibleValues;
	
	public SudokuTile() {
		value = -1;
	}
	
	public SudokuTile(int val, int numPossible) {
		value = val;
		//possibleValues = new int[NUM_POSSIBLE];
		int i;
//		for (i = 0; i < NUM_POSSIBLE; i++) {
//			possibleValues[i] = DEFAULT_VALUE;
//		}
	}
	
	public ArrayList<Integer> getPossibleValues() {
		return possibleValues;
	}
	
	public void setPossibleValues(ArrayList<Integer> vals) {
		possibleValues = vals;
	}
	
	public void updatePossibleValues(int newVal) {
		//if (possibleValues.contains(newVal))
			possibleValues.remove((Object)newVal);
//		int i;
//		for (i = 0; i < NUM_POSSIBLE; i++) {
//			if (newVal == possibleValues[i]) {
//				possibleValues[i] = DEFAULT_VALUE;
//			}
//		}
	}
	
	public static void setNumRange(int numPossible) {
		NUM_POSSIBLE = numPossible;
	}
	
	//public boolean has
	
	public void setValue(int val) {
		value = val;
	}
	
	public int getValue() {
		return value;
	}
	
	public String toString() {
		if (value == DEFAULT_VALUE)
			return " ";
		else
			return Integer.toString(value);
	}
}
