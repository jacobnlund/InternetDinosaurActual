package Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.w3c.dom.css.Rect;

import Image.Resource;


public class Cactus{
	private BufferedImage cactus;
	private static double GRAVITY = 0.1;
	private static int GROUND = 300;
	private int x = 500;
	private int y = 250 ;
	private float vy;
	private float vx = - 2;
	private Rectangle rect;
	Dino dino;
	
	
	
	
	
	public Cactus() {
		 cactus = Resource.getResourceImage("Images/cactus1.png");
		 rect = new Rectangle();
	}
		public void draw(Graphics g) {
			g.drawImage(cactus, x, GROUND - cactus.getHeight(), null);
			
		}
		
		
		public Rectangle getBound() {
			return rect;
		}

		
		public void update() {
			x +=vx;
			rect.x = x;
			rect.y = y;
			rect.width = cactus.getWidth();
			rect.height = cactus.getHeight();
			
			
		}
		

		public void drawRect(Graphics g) {
			g.drawRect(x,y,cactus.getWidth(), cactus.getHeight());
		}
		public BufferedImage getCactus() {
			return cactus;
		}
		public void setCactus(BufferedImage cactus) {
			this.cactus = cactus;
		}
		public static double getGRAVITY() {
			return GRAVITY;
		}
		public static void setGRAVITY(double gRAVITY) {
			GRAVITY = gRAVITY;
		}
		public static int getGROUND() {
			return GROUND;
		}
		public static void setGROUND(int gROUND) {
			GROUND = gROUND;
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
		public Rectangle getRect() {
			return rect;
		}
		public void setRect(Rectangle rect) {
			this.rect = rect;
		}
	
		
		
	
}
