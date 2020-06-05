package UserInterface;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Driver extends JFrame{

	private Screen screen;
	
	public Driver() {
		super("NoInternetDino");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen = new Screen();
		add(screen);
		addKeyListener(screen);
	}
	
	public void startGame() {
		screen.startGame();
	}
	
	
	public static void main(String arg[]) {
		Driver driver = new Driver();
		driver.setVisible(true);
		driver.startGame();
		
		
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(0, 300, 400, 300);
		BufferedImage Dino = null;
		try {
			Dino = ImageIO.read(new File("Images/main-character1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(Dino, 100, 100, null);
			
	}
	
	
}
