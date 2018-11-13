package com.mljes.mazegame.mazegame1;

public class MazeGrid {
	//this makes a grid of Xs and Os to be converted to symbols for our maze
	private static final char grid[][] = 
		{{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
		{'X','X','X','X','X','X','O','O','O','O','O','O','O','O','O','O','O','O','X','X','X','X','X','X','X','X','X','X','X','X','O','O','O','O','O','O','O','O','X','X'},
		{'X','X','X','X','X','X','O','X','X','X','X','O','X','X','X','X','X','X','X','X','O','O','O','O','O','O','X','X','X','X','O','X','O','X','X','X','X','O','X','X'},
		{'O','O','O','O','O','O','O','O','O','X','X','O','X','X','O','O','O','O','O','O','O','X','X','X','X','O','X','X','X','X','O','X','O','O','X','X','X','O','X','X'},
		{'X','X','X','X','X','X','X','X','O','X','X','O','X','X','X','X','X','X','X','X','O','X','X','X','X','O','O','O','X','X','O','X','X','O','X','X','X','O','X','X'},
		{'X','X','X','X','X','X','X','X','O','X','X','O','X','X','X','O','O','O','O','O','O','X','X','X','X','O','X','O','X','X','O','X','X','O','O','O','O','O','X','X'},
		{'X','X','O','X','X','X','X','X','O','X','X','O','X','X','X','O','X','X','X','X','X','X','X','X','X','O','X','O','X','X','O','X','X','X','X','X','X','O','X','X'},
		{'X','X','O','X','X','X','X','X','O','O','O','O','O','O','O','O','X','X','X','X','X','X','X','X','X','O','X','O','X','X','O','X','O','O','O','X','X','O','X','X'},
		{'X','X','O','X','X','X','X','X','X','X','X','X','X','O','X','X','X','X','X','X','X','X','X','X','X','O','X','O','X','X','O','X','O','X','O','X','X','O','X','X'},
		{'X','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','X','X','X','O','X','O','X','O','X','X','O','X','X'},
		{'X','X','X','X','X','X','O','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','O','O','O','X','O','X','X','O','X','X'},
		{'X','O','O','O','O','O','O','X','X','X','X','X','X','O','O','O','O','O','O','O','O','O','O','O','X','X','X','X','O','O','O','X','X','X','O','X','X','O','X','X'},
		{'X','X','X','X','X','X','O','X','X','X','X','X','X','O','X','X','X','X','O','X','X','X','X','O','O','O','O','O','O','O','X','X','X','X','X','X','X','O','X','X'},
		{'X','X','O','X','X','X','O','O','O','O','O','O','O','O','X','X','X','X','O','X','X','X','X','O','X','X','X','X','X','X','X','X','O','O','O','O','O','O','X','X'},
		{'X','X','O','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','O','X','X','X','X','O','O','O','X','X','X','X','X','X','O','X','X','X','X','X','X','X'},
		{'X','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','X','X','X','O','X','O','X','X','O','O','O','O','O','X','X','X','X','X','X','X'},
		{'X','X','X','X','X','X','X','O','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','O','X','O','X','X','O','X','X','X','O','X','X','X','X','X','X','X'},
		{'X','X','X','X','X','X','X','O','X','X','X','X','X','X','O','X','X','X','X','X','X','X','X','O','X','O','O','X','O','X','X','X','O','X','X','X','X','X','X','X'},
		{'X','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','X','X','X','X','X','X','X','O','O','O','O','O','O','O','O'},
		{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}};

	//this is the text for the info pane
	private static final String info[] = {
		  //1234567890123456789	
		   "                   \n", //0
		   "                   \n", //1
		   " Press ESC to exit \n", //2
		   "                   \n", //3
		   "                   \n", //4
		   "                   \n", //5
		   "                   \n", //6
		   "                   \n", //7
		   "  x-pos:   y-pos:  \n", //8
		   "  [    ]   [    ]  \n", //9
		   "                   \n", //10
		   "                   \n", //11
		   "                   \n", //12
		   "       SCORE       \n", //13
		   "       [   ]       \n", //14
		   "                   \n", //15
		   "                   \n", //16
		   "                   \n", //17
		   "                   \n", //18
		   "                   \n"};//19
	
	//give us the grid
	public static char[][] getGrid(){
		return grid;
	}
	
	//give us the info pane text
	public static String[] getInfo() {
		return info;
	}
	
}