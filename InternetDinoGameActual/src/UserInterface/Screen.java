package UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import Game.Cactus;
import Game.Dino;

public class Screen extends JPanel implements Runnable, KeyListener{

	public static final int originalPlay = 0;
	public static final int overPlay = 1;
	public static final double GRAVITY = 0.4;
	public static final int GROUND = 300;
	private int i = 0;
	private Thread thread;
	private int x = 0;
	private int y = 0 ;
	private float vy;
	private float vx;
	private Dino d;
	private Cactus c;
	int z = 7;
	int counter = 0;
	int total = 0;
	private int isPlay = originalPlay;
	boolean win = true;
	
	
	public Screen() {
		thread = new Thread(this);
		d = new Dino();
		c = new Cactus();
		
	}
	
	public void startGame() {
		thread.start();
	}
	
	@Override
	public void run() {
		while(true) {
			//System.out.println(i++);
			try {
				
				update();
				if(y >= GROUND -100) {
					vy = 0;
					y = GROUND-100;
				}
				vy+= GRAVITY;
				x+=vx;
				y+=vy;
				repaint();
				if(c.getX()<-20) {
					c.setX(415);
					counter++;
					total++;
				}
				if(counter == 2) {
					z-=1;
					counter =0;
					
				}
				if(z>3) {
				Thread.sleep(z);
				}else {
					isPlay = 1;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void update() {
		
		if(d.getBound().intersects(c.getBound())) {
			if(isPlay == originalPlay) {
			win = false;
				isPlay = 1;
		}
		}
		switch(isPlay) {
		case originalPlay:
			d.update();
			c.update();
			break;
		case overPlay:
			break;
		}
		
		
	}
	@Override  
	public void paint(Graphics g) {
		super.paint(g);
		/*
		 * g.setColor(Color.WHITE); g.fillRect(0, 0, getWidth(), getHeight());
		 * g.setColor(Color.BLACK); g.drawLine(0, 700, 1000, 700); g.drawRect(x, y, 100,
		 * 100);
		 */
		
		switch(isPlay) {
		case originalPlay:
			d.draw(g);
			c.draw(g);
			/*
			 * d.drawRect(g); c.drawRect(g);
			 */
			Font currentFont = g.getFont();
			Font newFont = currentFont.deriveFont(currentFont.getSize() * 5F);
			g.setFont(newFont);
			g.drawString(""+total, 200, 200);
			break;
		case overPlay:
			g.setColor(Color.BLACK);
			g.fillRect(0,0, 400, 400);
			g.setColor(Color.WHITE);
			if(win){
				g.drawString("You Win!", 130, 200);
			}else {
			g.drawString("You lose! And you Suck!", 130, 200);
			}
			break;
		}
			
		}

		
		
	
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		d.jump();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	
}
