package com.tut.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	public Constants data;
	
	public Handler(Constants data) {
		this.data = data;
	}
	
	public void tick() {
		for(int i = 0; i <object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			if(tempObject.trash){
				System.out.println(1);
				object.remove(i);
				i --;
			} else {
				if (tempObject.Dupe) {
					object.add(new Player((int) (data.screenWidth * 1), (int) (data.screenHeight * 0.95), ID.Player, data));
				}
				tempObject.tick();
			}
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i <object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object, Integer index) {
		this.object.add(index, object);
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}
