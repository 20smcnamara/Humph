package com.tut.main;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends GameObject{
	
	protected BufferedImage image;
	public int timer = 0;
	public int speed;
	public double scale;
	public int lastScale = (int) scale;
	
	public Player(int x, int y, ID id, Constants data) {
		super(x, y, id, data);
		speed = data.speed;
		scale = 0.20 * speed;
		updatePicture();
		
	}
	
	public void updatePicture() {
		try {
			int size = (int) (222 * scale);
			BufferedImage before = ImageIO.read(getClass().getResource("Elfer.png"));  //ImageIO.read(new File("src/com/tut/main/Elfer.png"));
			BufferedImage after = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
			AffineTransform at = new AffineTransform();
			at.scale(scale, scale);
			AffineTransformOp scaleOp = 
			   new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
			image = scaleOp.filter(before, after);
		} catch(IOException e) {
			System.out.println(e);
		}
	}

	public void tick() {
		if (x + 222 * scale < 100) {
			trash = true;
		}
		if (timer % 5 == 0) {
			if ((int) (scale * 222) != lastScale * 222) {
				updatePicture();
				lastScale = (int) scale;
			}
			scale += 0.01 * speed;
			y -= 0.8 * speed * scale;
			x -= 1.5 * speed * scale;
		}
		timer ++;
	}

	public void render(Graphics g) {
		g.drawImage(image, (int) x, (int) y, null);
		
	}

}
