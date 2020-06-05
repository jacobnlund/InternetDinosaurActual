package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Image.Resource;

public class Dino {

	private static double GRAVITY = 0.1;
	private static int GROUND = 300;
	private int x = 0;
	private int y = 0 ;
	private float vy;
	private float vx;
	private BufferedImage dino;
	private Rectangle rect;
	
	public Dino() {
		dino = Resource.getResourceImage("Images/main-character1.png");
		rect = new Rectangle();
	}
	
	public void drawRect(Graphics g) {
		g.drawRect(x,y,dino.getWidth(), dino.getHeight());
	}
	
	public void update() {
		if(y >= GROUND - dino.getHeight()) {
			vy = 0;
			y = GROUND- dino.getHeight();
		}
		vy+= GRAVITY;
		x+=vx;
		y+=vy;
		
		rect.x = x;
		rect.y = y;
		rect.width  = dino.getWidth();
		rect.height = dino.getHeight();
		
	}
	
public Rectangle getBound() {
	return rect;
}


	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(0,  300,  400,  300);
		g.drawImage(dino, x, y, null);
	}
	
	public void jump() {
		if(y == GROUND - dino.getHeight()) {
		vy  = - 4;
		y += vy;
		}
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public float getVy() {
		return vy;
	}
	public void setVy(float vy) {
		this.vy = vy;
	}
	public float getVx() {
		return vx;
	}
	public void setVx(float vx) {
		this.vx = vx;
	}
	public static double getGravity() {
		return GRAVITY;
	}
	public static int getGround() {
		return GROUND;
	}
	
	
	
	
	
	
	
}
