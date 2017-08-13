package com.lasky.simpleryo.task1;

import java.util.ArrayList;

public class GameOfLife {
	public static String convertBoardToPrintableString(String[][] board) {
		StringBuffer printableBoard = new StringBuffer();
		
		if (board != null && board.length > 0) {
			int currentColumnLength = 0;
			for (int row = 0; row < board.length; row++) {
				currentColumnLength = board[row].length;
				for (int column = 0; column < currentColumnLength; column++) {
					printableBoard.append(" -");
				}
				printableBoard.append(System.lineSeparator());
				for (int column = 0; column < currentColumnLength; column++) {
					printableBoard.append("|");
					printableBoard.append(board[row][column]);					
				}
				printableBoard.append("|");
				printableBoard.append(System.lineSeparator());
			}
			
			for (int column = 0; column < currentColumnLength; column++) {
				printableBoard.append(" -");
			}
		}
		
		return printableBoard.toString();
	}
	
	/**
	 * Assume that the the board has even number of columns for now
	 * @param board
	 * @return
	 * @throws Exception
	 */
	public String[][] createNextGenerationCells(String[][] board) throws Exception {
		String[][] nextGenerationCells = null;
		
		if (board != null && board.length > 0 && board.length <= Constants.MAX_ROWS) {
			Integer expectedColumnLength = board[0].length;
			//convert everything to Cell
			Cell[][] cells = this.convertBoardToActualCells(board, expectedColumnLength);
			
			for (int row = 0; row < board.length; row++) {
				for (int column = 0; column < board[row].length; column++) {
					this.evaluateCellNextState(cells, row, column, expectedColumnLength);
				}
			}
			
			nextGenerationCells = this.generateNewGenerationBoard(cells, board.length, expectedColumnLength);
		}
		
		return nextGenerationCells;
	}
	
	private void evaluateCellNextState(Cell[][] cells, int cellRow, int cellColumn, int cellsColumnLength) {
		Cell theCell = cells[cellRow][cellColumn];
		ArrayList<Cell> listOfNeighbors = this.getCellNeighbors(cells, cellRow, cellColumn, cellsColumnLength);
		int numberOfLiveNeighbors = this.getNumberOfLiveNeighbors(listOfNeighbors);
		
		if (theCell.isAlive) {
			if (numberOfLiveNeighbors >= Constants.MIN_LIVECELL_NEIGHBORS
					&& numberOfLiveNeighbors <= Constants.MAX_LIVECELL_NEIGHBORS) {
				theCell.willSurvive = true;
			} else {
				theCell.willSurvive = false;
			}
		} else if (numberOfLiveNeighbors == Constants.LIVECELLNEIGHBORCOUNT_TO_RESURRECT_A_DEADCELL){
			theCell.willSurvive = true;
		}
	}
	
	private ArrayList<Cell> getCellNeighbors(Cell[][] cells, int cellRow, int cellColumn, int cellsColumnLength) {
		ArrayList<Cell> listOfCellNeighbors = new ArrayList<Cell>();
		//everything here is expressed in index
		int minNeighborRow = Math.max(cellRow - 1, 0);
		int minNeighborColumn = Math.max(cellColumn - 1, 0);
		int maxNeighborRow = Math.min(cells.length - 1, cellRow + 1);
		int maxNeighborColumn = Math.min(cellsColumnLength - 1, cellColumn + 1);
		Coordinate subjectCellCoordinate = new Coordinate(cellRow, cellColumn);
		
		for (int neighborRow = minNeighborRow; neighborRow <= maxNeighborRow; neighborRow++) {
			for (int neighborColumn = minNeighborColumn; neighborColumn <= maxNeighborColumn; neighborColumn++) {
				//now we collect the neighbor's within the cell's block except for the cell itself
				if (!subjectCellCoordinate.equal(neighborRow, neighborColumn)) { // if it is not the cell itself
					listOfCellNeighbors.add(cells[neighborRow][neighborColumn]);
				}
			}
		}
		
		return listOfCellNeighbors;
	}
	
	private int getNumberOfLiveNeighbors(ArrayList<Cell> listOfNeighbors) {
		int liveNeighborsCount = 0;
		
		for (Cell cell : listOfNeighbors) {
			if (cell.isAlive) {
				liveNeighborsCount++;
			}
		}
		
		return liveNeighborsCount;
	}
	
	private Cell[][] convertBoardToActualCells(String[][] board, Integer expectedColumnLength) throws Exception {
		Cell[][] cells = new Cell[board.length][expectedColumnLength];
		
		for (int row = 0; row < board.length; row++) {
			if (board[row].length > expectedColumnLength) {
				throw new Exception("ERROR: the board has unequal number of columns!");
			} else if (board[row].length < 1) {
				throw new Exception("ERROR: the board has a row with now columns!");
			}
			
			//it is in this loop where it will really be converted
			for (int column = 0; column < board[row].length; column++) {
				cells[row][column] = new Cell();
				
				cells[row][column].willSurvive = false; //initial state
				if (board[row][column].equals(Constants.STRING_LIVE_CELL)) {
					cells[row][column].isAlive = true;
				} else {
					cells[row][column].isAlive = false;
				}
			}
		}
		
		return cells;
	}
	
	private String[][] generateNewGenerationBoard(Cell[][] cells, int maxRows, int maxColumns) {
		String[][] board = null;
		
		if (cells != null && cells.length > 0 && cells[0].length > 0
				&& maxRows <= Constants.MAX_ROWS && maxColumns <= Constants.MAX_COLUMNS) {
			board = new String[maxRows][maxColumns];
			
			for (int row = 0; row < maxRows; row++) {
				for (int column = 0; column < maxColumns; column++) {
					if (cells[row][column].willSurvive) {
						board[row][column] = Constants.STRING_LIVE_CELL;
					} else {
						board[row][column] = Constants.STRING_DEAD_CELL;
					}
				}
			}
		}
		
		return board;
	}
}


