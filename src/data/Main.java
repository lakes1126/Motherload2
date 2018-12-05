package data;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Main {
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	private static final Dimension screensize = new Dimension(WIDTH,HEIGHT);
	JFrame frame;
	
	public Main() {
		//Creates DisplayPanel object
		DisplayPanel dp = new DisplayPanel();
		
		//initializes the JFrame
		frame = new JFrame();
		frame.setSize(screensize);
		frame.setTitle("Motherload 2.0 Bay Bee!!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		//adds displayPanel
		frame.add(dp);
		frame.setVisible(true);
	}

	public static Dimension getScreensize() {return screensize;}

	public static void main(String[] args) {
		new Main();

	}

}
