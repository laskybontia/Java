package com.lasky.simpleryo.task1;

public class Coordinate {
	private int row;
	private int column;
	
	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public boolean equal(int row, int column) {
		boolean result = false;
		
		if (this.row == row && this.column == column) {
			result = true;
		}
		
		return result;
	}
}
