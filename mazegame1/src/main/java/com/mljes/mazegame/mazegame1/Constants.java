package com.mljes.mazegame.mazegame1;

import com.googlecode.lanterna.TextColor;

public class Constants {	
	//objects that make up the maze
	static final char WALL = (char)(0x2593);
	static final char PRIZE = (char)(0x2665);
	
	//options for other symbols:
	static final char FACE = (char)(0x263A);
	static final char HEART = (char)(0x2665);
	static final char TRIANGLE = (char)(0x25B2);
	static final char CIRCLE = (char)(0x25CB);
	static final char SQUARE = (char)(0x225A0);
	static final char DIAMOND = (char)(0x2666);
	
	//objects that make up the border around the maze and info box
	static final char BORDER_HORIZONTAL = (char)(0x2550);
	static final char BORDER_VERTICAL = (char)(0x2551);
	static final char CORNER_TOP_LEFT = (char)(0x2554);
	static final char CORNER_TOP_RIGHT = (char)(0x2557);
	static final char CORNER_BOT_LEFT = (char)(0x255A);
	static final char CORNER_BOT_RIGHT = (char)(0x255D);
	static final char CORNER_BOT_T = (char)(0x2569);
	static final char CORNER_TOP_T = (char)(0x2566);
	
	//colors!!!
	static final TextColor RED = TextColor.ANSI.RED;
	static final TextColor MAGENTA = TextColor.ANSI.MAGENTA;
	static final TextColor BLUE = TextColor.ANSI.BLUE;
	static final TextColor CYAN = TextColor.ANSI.CYAN;
	static final TextColor GREEN = TextColor.ANSI.GREEN;
	static final TextColor YELLOW = TextColor.ANSI.YELLOW;
	static final TextColor WHITE = TextColor.ANSI.WHITE;
	static final TextColor BLACK = TextColor.ANSI.BLACK;
	
	//directions for movement
	static final int RIGHT = 1;
	static final int LEFT = 2;
	static final int UP = 3;
	static final int DOWN = 4;
}
