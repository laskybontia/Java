package com.lasky.simpleryo.task2;

public class TicTacToe {
	private char winnerName = Constants.NO_WINNER;
	
	public static String convertBoardToPrintableString(String[][] board) {
		StringBuffer printableBoard = new StringBuffer();
		
		if (board != null && board.length > 0) {
			int currentColumnLength = 0;
			for (int row = 0; row < board.length; row++) {
				currentColumnLength = board[row].length;
				for (int column = 0; column < currentColumnLength; column++) {
					printableBoard.append(" --");
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
				printableBoard.append(" --");
			}
		}
		
		return printableBoard.toString();
	}
	
	public char determineWinner(String[][] board) throws Exception {
		this.winnerName = Constants.NO_WINNER;
		
		if (board != null && board.length > 0 && board.length <= Constants.TIC_TOE_ROW_SIZE) {
			int rowA = 0;
			int columnA = 0;
			int rowB = Constants.TIC_TOE_ROW_SIZE - 1; 
			int columnB = Constants.TIC_TOE_COLUMN_SIZE - 1;
			String centerCell = board[1][1];
			
			if (centerCell.equals(Constants.CELL_MARKED_BY_O) || centerCell.equals(Constants.CELL_MARKED_BY_X)) {
				String topCell = null;
				String bottomCell = null;
				
				//this loop is for cells that affects the center cell
				//which are the diagonal lines and the center lines (vertical and horizontal)
				for(int counter = 0; counter < 4; counter++) {
					topCell = board[rowA][columnA];
					bottomCell = board[rowB][columnB];
					
					if(centerCell.equals(topCell) && centerCell.equals(bottomCell)) {
						this.winnerName = this.convertCellMarkToWinnerName(centerCell);
						break;
					} else {
						if (counter < 2) {
							columnA++;
							columnB--;
						} else {
							columnA = 0;
							columnB = Constants.TIC_TOE_COLUMN_SIZE - 1;
							rowA++;
							rowB--;
						}
					}
				}
			}
			
			//top horizontal
			if (this.winnerName == Constants.NO_WINNER) {
				centerCell = board[0][1];
				if (centerCell.equals(board[0][0]) && centerCell.equals(board[0][2])) {
					this.winnerName = this.convertCellMarkToWinnerName(centerCell);
				}
			}
			//bottom horizontal
			if (this.winnerName == Constants.NO_WINNER) {
				centerCell = board[2][1];
				if (centerCell.equals(board[2][0]) && centerCell.equals(board[2][2])) {
					this.winnerName = this.convertCellMarkToWinnerName(centerCell);
				}
			}
			
			//left vertical
			if (this.winnerName == Constants.NO_WINNER) {
				centerCell = board[1][0];
				if (centerCell.equals(board[0][0]) && centerCell.equals(board[2][0])) {
					this.winnerName = this.convertCellMarkToWinnerName(centerCell);
				}
			}
			//right vertical
			if (this.winnerName == Constants.NO_WINNER) {
				centerCell = board[1][2];
				if (centerCell.equals(board[0][2]) && centerCell.equals(board[2][2])) {
					this.winnerName = this.convertCellMarkToWinnerName(centerCell);
				}
			}
			
		}
		
		return this.winnerName;
	}
	
	private char convertCellMarkToWinnerName(String cellMark) {
		char winnerName = Constants.NO_WINNER;
		
		if (cellMark.equals(Constants.CELL_MARKED_BY_O)) {
			winnerName = Constants.O_PLAYER;
		} else if (cellMark.equals(Constants.CELL_MARKED_BY_X)) {
			winnerName = Constants.X_PLAYER;
		}
		
		return winnerName;
	}
	
}




