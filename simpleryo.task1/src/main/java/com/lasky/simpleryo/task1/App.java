package com.lasky.simpleryo.task1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Game of Life By Lasky Bontia (SimplerYo Additional Task 1)\n\n");
        String l = Constants.STRING_LIVE_CELL;
        String d = Constants.STRING_DEAD_CELL;
        String[][] board = {
        		{d,d,d,d,d,d},
        		{d,d,d,d,d,d},
        		{d,d,l,l,l,d},
        		{d,l,l,l,d,d},
        		{d,d,d,d,d,d},
        		{d,d,d,d,d,d}
        };
        
        try {
        	System.out.println("Current board (Current Generation Cells):");
        	System.out.println(GameOfLife.convertBoardToPrintableString(board));
        	
        	String[][] newBoard = (new GameOfLife()).createNextGenerationCells(board);
        	System.out.println();
        	System.out.println("New board (Next Generation Cells):");
        	System.out.println(GameOfLife.convertBoardToPrintableString(newBoard));
        	
        	newBoard = (new GameOfLife()).createNextGenerationCells(newBoard);
        	System.out.println();
        	System.out.println("New board (Next Generation Cells):");
        	System.out.println(GameOfLife.convertBoardToPrintableString(newBoard));
        	
        	newBoard = (new GameOfLife()).createNextGenerationCells(newBoard);
        	System.out.println();
        	System.out.println("New board (Next Generation Cells):");
        	System.out.println(GameOfLife.convertBoardToPrintableString(newBoard));
        	
        } catch (Exception exception) {
        	System.out.println(exception.getMessage());
        }
        
    }
}
