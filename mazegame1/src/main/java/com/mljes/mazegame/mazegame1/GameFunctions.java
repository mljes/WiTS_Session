package com.mljes.mazegame.mazegame1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

public class GameFunctions extends Constants {
	private static ArrayList<TerminalPosition> pathList = new ArrayList<TerminalPosition>();
	private static ArrayList<TerminalPosition> prizeList = new ArrayList<TerminalPosition>();
	private static Random randGen = new Random();
	private static int score = 0;
	
	public static ArrayList<TerminalPosition> getPathList() {
		return pathList;
	}
	public static ArrayList<TerminalPosition> getPrizeList() {
		return prizeList;
	}
	public static int getScore() {
		return score;
	}
	
	//lets the user move the cursor, but only along the path.
	public static void move(TextGraphics textGraphic, Screen screen) throws IOException {
    	KeyStroke input = screen.readInput();

    	int rightBound = screen.getTerminalSize().getColumns();
    	int bottomBound = screen.getTerminalSize().getRows();
    	
        
        while(input.getKeyType() != KeyType.Escape) {
    		if (input.getKeyType().equals(KeyType.ArrowUp) && screen.getCursorPosition().getRow()!=0 && !hitWall(UP, screen)) {
    			screen.setCursorPosition(screen.getCursorPosition().withRelativeRow(-1));
    		}
    		else if (input.getKeyType().equals(KeyType.ArrowRight) && screen.getCursorPosition().getColumn()!=rightBound && !hitWall(RIGHT, screen)) {
    			screen.setCursorPosition(screen.getCursorPosition().withRelativeColumn(1));
    		}
    		else if (input.getKeyType().equals(KeyType.ArrowDown) && screen.getCursorPosition().getRow()!=bottomBound && !hitWall(DOWN, screen)) {
    			screen.setCursorPosition(screen.getCursorPosition().withRelativeRow(1));
    		}
    		else if (input.getKeyType().equals(KeyType.ArrowLeft) && screen.getCursorPosition().getColumn()!=0 && !hitWall(LEFT, screen)) {
    			screen.setCursorPosition(screen.getCursorPosition().withRelativeColumn(-1));
    		}
    		else {
    			
    		}
        	
    		updatePositionIndicators(textGraphic, screen);
    		
    		collectPrize(screen, textGraphic);
    		
    		if (endOfMaze(screen)) {
    			textGraphic.setBackgroundColor(RED);
    			textGraphic.putString(47, 18, "GAME OVER");
    			
    			screen.refresh();
    			break;
    		}
    		
            screen.refresh();
            input = screen.readInput();
        }
    }
    
    public static boolean hitWall(int dir, Screen screen) {
    	if (dir==UP) {	
    		return screen.getFrontCharacter(screen.getCursorPosition().withRelativeRow(-1)).getCharacter()==WALL ||
    				screen.getFrontCharacter(screen.getCursorPosition().withRelativeRow(-1)).getCharacter()==BORDER_HORIZONTAL;
    	}
    	else if (dir==RIGHT) {
    		return screen.getFrontCharacter(screen.getCursorPosition().withRelativeColumn(1)).getCharacter()==WALL ||
    				screen.getFrontCharacter(screen.getCursorPosition().withRelativeColumn(1)).getCharacter()==BORDER_VERTICAL;
    	}
    	else if (dir==DOWN) {
    		return screen.getFrontCharacter(screen.getCursorPosition().withRelativeRow(1)).getCharacter()==WALL  ||
    				screen.getFrontCharacter(screen.getCursorPosition().withRelativeRow(1)).getCharacter()==BORDER_HORIZONTAL;
    	}
    	else if (dir==LEFT) {
    		return screen.getFrontCharacter(screen.getCursorPosition().withRelativeColumn(-1)).getCharacter()==WALL  ||
    				screen.getFrontCharacter(screen.getCursorPosition().withRelativeColumn(-1)).getCharacter()==BORDER_VERTICAL;
    	}
    	else {
    		return true; //block it
    	}
    }
    
    public static void updatePositionIndicators(TextGraphics textGraphic, Screen screen) throws IOException {
		int xPos = screen.getCursorPosition().getColumn();
		int yPos = screen.getCursorPosition().getRow();
		
		textGraphic.setBackgroundColor(CYAN);
		textGraphic.setForegroundColor(BLACK);
		
		textGraphic.putString(45, 10, "    ");
		textGraphic.putString(54, 10, "    ");
		
		screen.refresh();
		
		textGraphic.putString(45, 10, " " + xPos);
		textGraphic.putString(54, 10, " " + yPos);
		
		textGraphic.setBackgroundColor(BLACK);
		textGraphic.setForegroundColor(WHITE);
    }
    
    public static boolean endOfMaze(Screen screen) {
    	return screen.getCursorPosition().equals(new TerminalPosition(40,19)); 
    }
    
	//creates the borders and info pane
    public static void drawBorders(TextGraphics textGraphic, Screen screen, TextColor color) throws IOException {
    	textGraphic.setForegroundColor(color);
        
        textGraphic.putString(0, 0, String.valueOf(CORNER_TOP_LEFT));
        textGraphic.putString(41, 0, String.valueOf(CORNER_TOP_T));
        textGraphic.putString(0, 21, String.valueOf(CORNER_BOT_LEFT));
        textGraphic.putString(41, 21, String.valueOf(CORNER_BOT_T));
        textGraphic.putString(61, 0, String.valueOf(CORNER_TOP_RIGHT));
        textGraphic.putString(61, 21, String.valueOf(CORNER_BOT_RIGHT));
        
        
        textGraphic.drawLine(1, 0, 40, 0, BORDER_HORIZONTAL);
        textGraphic.drawLine(1, 21, 40, 21, BORDER_HORIZONTAL);
        textGraphic.drawLine(0, 1, 0, 20, BORDER_VERTICAL);
        textGraphic.drawLine(41, 1, 41, 20, BORDER_VERTICAL);
        
        textGraphic.drawLine(42, 0, 60, 0, BORDER_HORIZONTAL);
        textGraphic.drawLine(42, 21, 60, 21, BORDER_HORIZONTAL);
        textGraphic.drawLine(61, 1, 61, 20, BORDER_VERTICAL);
        
        textGraphic.setBackgroundColor(CYAN);
        textGraphic.setForegroundColor(MAGENTA);
        
        for (int i=0; i<20; i++) {
        	textGraphic.putString(42, i+1, MazeGrid.getInfo()[i]);
        }
        
        textGraphic.setBackgroundColor(BLACK);
        textGraphic.setForegroundColor(WHITE);
        
        screen.refresh();
    }
    
    public static void placePrize(Screen screen, char prize, TextColor color) {
    	int position = randGen.nextInt(pathList.size());
		
		screen.setCharacter(pathList.get(position), new TextCharacter(prize, color, BLACK));
		prizeList.add(pathList.get(position));
    }

    public static void collectPrize(Screen screen, TextGraphics textGraphic) {
    	if (prizeList.contains(screen.getCursorPosition())) {
    		score++;
        	prizeList.remove(prizeList.indexOf(screen.getCursorPosition()));
        	screen.setCharacter(screen.getCursorPosition(), new TextCharacter(' ', GREEN, BLACK));
        	
        	textGraphic.setBackgroundColor(CYAN);
    		textGraphic.setForegroundColor(BLACK);
        	textGraphic.putString(50, 15, " " + score);
        	textGraphic.setBackgroundColor(BLACK);
    		textGraphic.setForegroundColor(WHITE);
    	}
    }
    
    //prints the maze using the 2D array in MazeGrid
    public static void createMaze(Screen screen, TextColor cursorColor, TextColor wallColor, char wallSymbol) {
        char mazeGrid[][] = MazeGrid.getGrid();
        
        for (int i=0; i<20; i++) {
        	for (int j=0; j<40; j++) {
        		TextColor fg = (mazeGrid[i][j]=='X') ? wallColor : cursorColor;
        		char symbol = (mazeGrid[i][j]=='X') ? wallSymbol : ' ';
        		
        		if (mazeGrid[i][j]=='O') {
        			pathList.add(new TerminalPosition(j+1,i+1));
        		}
        		
        		screen.setCharacter(j+1, i+1, new TextCharacter(symbol, fg, BLACK));
        	}
        }
    }
    
    //waits for the user to hit the ESC button to terminate the app
    public static void waitForExit(Screen screen) throws IOException {
        KeyStroke input = screen.readInput();
        while (input.getKeyType() != KeyType.Escape) { input = screen.readInput(); }
    }
   
    
}
