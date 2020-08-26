package com.tut.main;

import java.awt.Graphics;

public abstract class GameObject {

	
	protected double x, y;
	protected ID id;
	protected int deltaX, deltaY;
	public boolean trash = false;
	public Constants data;
	public boolean Dupe = false;
	
	public GameObject(int x, int y, ID id, Constants data) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.data = data;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setID(ID id) {
		this.id = id;
	}
	
	public ID getId() {
		return id;
	}
	
	public void setDeltaX(int x) {
		deltaX = x;
	}
	
	public void setDeltaY(int y) {
		deltaY = y;
	}
	
	public int getDeltaX() {
		return deltaX;
	}
	
	public int getDeltaY() {
		return deltaY;
	}
}
