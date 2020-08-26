package com.tut.main;

import java.awt.Color;

public class Constants {

	public int screenX;
	public int screenY;
	public int screenHeight;
	public int screenWidth;
	public int FPS = 0;
	public int speed;
	public Color PURPLE = new Color(128, 0, 128);
	
	public Constants(int x, int y, int h, int w, int speed) {
		screenX = x;
		screenY = y;
		screenHeight = h;
		screenWidth = w;
		this.speed = speed;
	}
	
}
