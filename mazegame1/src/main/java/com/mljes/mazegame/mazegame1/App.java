package com.mljes.mazegame.mazegame1;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.swing.WindowConstants;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;
import com.googlecode.lanterna.terminal.swing.TerminalEmulatorAutoCloseTrigger;
import com.googlecode.lanterna.terminal.swing.TerminalEmulatorColorConfiguration;
import com.googlecode.lanterna.terminal.swing.TerminalEmulatorDeviceConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

public class App extends GameFunctions
{	
	private static Screen screen;
	private static TextGraphics textGraphic;
	private static SwingTerminalFrame terminal = new SwingTerminalFrame(
            "Maria's Maze",
            TerminalEmulatorDeviceConfiguration.getDefault(),
            SwingTerminalFontConfiguration.getDefault(),
            TerminalEmulatorColorConfiguration.getDefault(),
            TerminalEmulatorAutoCloseTrigger.CloseOnExitPrivateMode);
	
    public static void main( String[] args ) throws IOException, InterruptedException
    {
    	//make a window, put everything on it
    	createScreen();
    	
    	//You can change the color of the border from MAGENTA
    	//The color options are in the Constants.java file
        drawBorders(textGraphic, screen, MAGENTA);
        
        //                   1      2     3
        createMaze(screen, GREEN, WHITE, WALL);
        /* 1 = cursorColor,
         * 2 = wallColor,
         * 3 = wallSymbol
         */
        
        //Put the number of prizes in here!
        placePrizes(10, screen);
        
        //tell us where we are, let us move around
        updatePositionIndicators(textGraphic, screen);
        move(textGraphic, screen);
        
        //wait for user to close the screen
        waitForExit(screen);
        
        //shut down the game
        screen.stopScreen();
    }

    //This is what we use to randomly place prizes on the maze.
    //It uses a random number generator to select the spots from a list we saved earlier, 
    // and a for loop to place as many prizes as we select with the "number" argument.
    private static void placePrizes(int number, Screen screen) {
    	if (number>=getPathList().size()) {
    		return; //bad input
    	}
    	
    	for (int i=0; i</*  ?  */; i++) {
    		//                  symbol   color 
    		placePrize(screen, DIAMOND, YELLOW);
    	}
    }
    
    //these methods put the screen together and establish some settings
    private static void createScreen() throws IOException {
    	terminal.setDefaultCloseOperation(
                WindowConstants.EXIT_ON_CLOSE);
        terminal.setVisible(true);
    	
    	screen = new TerminalScreen(terminal);
    	
    	screen.startScreen();
      	enableScreenExitButton();
      	
    	screen.setCursorPosition(new TerminalPosition(1, 4));
        
        textGraphic = screen.newTextGraphics();
    }

    private static void enableScreenExitButton() {
    	// Add a window listener to the SwingTerminal JFrame
    	terminal.addWindowListener(new java.awt.event.WindowAdapter() {
    	    public void windowClosing(java.awt.event.WindowEvent evt) {
    	        try {
    	        	screen.stopScreen();
    	        }
    	        catch(Exception e) {
    	        	System.exit(0);
    	        }
    	      }
    	});
    }

}
