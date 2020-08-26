package com.tut.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;

public class Game extends Canvas implements Runnable {

	
	private static final long serialVersionUID = 8845325147047547333L;
	
	public static final int WIDTH = 1280, HEIGHT = WIDTH / 12 * 9;
	
	public Constants data;
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private int timer = 0;
	private int SPEED = 5;
	private boolean first = true;
	
	public Game() {
		new Window(WIDTH, HEIGHT, "The Game", this);
		
		data = new Constants(this.getLocationOnScreen().x, this.getLocationOnScreen().y, HEIGHT, WIDTH, SPEED);
		
		handler = new Handler(data);
	}
	
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		 running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) {
				render();
			}
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000){ // Determine frames
				timer += 1000;
				System.out.println("FPS: " + frames);
				data.FPS = frames;
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		if (timer % (750 / SPEED) == 0) {
			handler.addObject(new Player((int) (WIDTH * 1), (int) (HEIGHT * 0.95), ID.Player, data), 0);
		}
		handler.tick();
		timer ++;
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(data.PURPLE);
		g.fillRect(0, 0, WIDTH, (int) (HEIGHT)); 
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		new Game();
	}
}
