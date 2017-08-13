package com.lasky.simpleryo.task2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Tic Tac Toe Determine Winner Function by Lasky Bontia (SimplerYo Task 2)\n\n" );
        String e = Constants.CELL_EMPTY;
        String o = Constants.CELL_MARKED_BY_O;
        String x = Constants.CELL_MARKED_BY_X;
        TicTacToe ticTacToe = new TicTacToe();
        
        String[][] board1 = { //n
        		{e, e, e},
        		{e, e, e},
        		{e, e, e}
        };
        String[][] board2 = { //x
        		{x, e, o},
        		{x, e, e},
        		{x, e, o}
        };
        String[][] board3 = { //o
        		{e, x, e},
        		{o, o, o},
        		{x, e, x}
        };
        String[][] board4 = { //n
        		{x, e, o},
        		{x, x, e},
        		{o, x, o}
        };
        String[][] board5 = { //o
        		{o, o, o},
        		{x, o, x},
        		{o, x, o}
        };
        String[][] board6 = { //o 
        		{x, e, o},
        		{o, x, x},
        		{o, o, o}
        };
        String[][] board7 = { //x
        		{x, e, x},
        		{x, o, x},
        		{o, o, x}
        };
        String[][] board8 = { //x
        		{x, x, o},
        		{o, x, e},
        		{o, x, o}
        };
        String[][] board9 = { //x
        		{x, o, o},
        		{o, x, e},
        		{o, x, x}
        };
        String[][] board10 = { //o
        		{x, x, o},
        		{o, o, e},
        		{o, x, o}
        };
        
        try {
        	System.out.println("Board 1:");
        	System.out.println(TicTacToe.convertBoardToPrintableString(board1));
        	System.out.println("The winner is: " + ticTacToe.determineWinner(board1));
        	
        	System.out.println("\nBoard 2:");
        	System.out.println(TicTacToe.convertBoardToPrintableString(board2));
        	System.out.println("The winner is: " + ticTacToe.determineWinner(board2));
        	
        	System.out.println("\nBoard 3:");
        	System.out.println(TicTacToe.convertBoardToPrintableString(board3));
        	System.out.println("The winner is: " + ticTacToe.determineWinner(board3));
        	
        	System.out.println("\nBoard 4:");
        	System.out.println(TicTacToe.convertBoardToPrintableString(board4));
        	System.out.println("The winner is: " + ticTacToe.determineWinner(board4));
        	
        	System.out.println("\nBoard 5:");
        	System.out.println(TicTacToe.convertBoardToPrintableString(board5));
        	System.out.println("The winner is: " + ticTacToe.determineWinner(board5));
        	
        	System.out.println("\nBoard 6:");
        	System.out.println(TicTacToe.convertBoardToPrintableString(board6));
        	System.out.println("The winner is: " + ticTacToe.determineWinner(board6));
        	
        	System.out.println("\nBoard 7:");
        	System.out.println(TicTacToe.convertBoardToPrintableString(board7));
        	System.out.println("The winner is: " + ticTacToe.determineWinner(board7));
        	
        	System.out.println("\nBoard 8:");
        	System.out.println(TicTacToe.convertBoardToPrintableString(board8));
        	System.out.println("The winner is: " + ticTacToe.determineWinner(board8));
        	
        	System.out.println("\nBoard 9:");
        	System.out.println(TicTacToe.convertBoardToPrintableString(board9));
        	System.out.println("The winner is: " + ticTacToe.determineWinner(board9));
        	
        	System.out.println("\nBoard 10:");
        	System.out.println(TicTacToe.convertBoardToPrintableString(board10));
        	System.out.println("The winner is: " + ticTacToe.determineWinner(board10));
        	
        } catch (Exception exception) {
        	System.out.println("ERROR: " + exception.getMessage());
        }
    	
    }
}
