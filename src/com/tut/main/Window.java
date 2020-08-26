package com.tut.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = 8887340795802338463L;

	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));		// Starting screen size
		frame.setMaximumSize(new Dimension(width, height));			// Biggest screen size
		frame.setMinimumSize(new Dimension(width, height));			// Smallest screen size
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// Closes window when X is clicked
		frame.setResizable(false);									// Allows / disallows resizing
		frame.setLocationRelativeTo(null);							// Positions starting point on screen
		frame.add(game);											// Adds main loop to frame
		frame.setVisible(true);										// Makes screen not transparent
		game.start();												// Starts main loop
		
	}

}
