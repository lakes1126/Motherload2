package data;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;


import javax.swing.JPanel;

import input.KeyListener;
import input.MouseListener;

public class DisplayPanel extends JPanel implements Runnable{
	//Serial ID(useless)
	private static final long serialVersionUID = 1L;
	//double buffering variables
	private Image dbImage;
	private Graphics dbg;
	//JPanel Variables
	private static final int WIDTH = Main.getScreensize().width;
	private static final int HEIGHT = Main.getScreensize().height;
	private static final Dimension screensize = new Dimension(WIDTH,HEIGHT);
	//Thread Variables
	private volatile boolean running = false;
	private Thread game;
	//Key and Mouse Listeners
	KeyListener keyListener = new KeyListener();
	MouseListener mouseListener = new MouseListener();


	public DisplayPanel(){
		//initializes the JPanel
		JPanel panel = new JPanel();
		panel.setPreferredSize(screensize);
		panel.setBackground(Color.WHITE);
		panel.setFocusable(true);
		panel.requestFocus();
	}
	
	@Override
	public void run() {
		gameUpdate();
		gameRender();
		paintScreen();
		
	}
	
	private void gameUpdate() {
		if(running && game != null) {
			//update game state
		}
		
	}

	private void gameRender() {
		if(dbImage == null) {
			dbImage = createImage(Main.getScreensize().width,Main.getScreensize().height);
			if(dbImage == null) {
				log("dbImage is still null");
				return;
			} else {
				dbg = dbImage.getGraphics();
			}
		}
		//Clears the screen
		dbg.setColor(Color.WHITE);
		dbg.fillRect(0, 0, WIDTH, HEIGHT);
		//draws game elements
		draw(dbg);
	}
	

	private void paintScreen() {
		Graphics g;
		try {
			g = this.getGraphics();
			if(dbImage != null && dbg != null) {
				g.drawImage(dbImage, 0, 0, null);
			}
			g.dispose();
		} catch(Exception e) {
			System.err.println(e);
		}
		
		
		
	}
	
	/*
	 * Everything Drawn in this method ----------------------------------------------------------------------------------------
	 */
	private void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawString("THIS SHIT IS MOTHERLOAD", 600, 290);
		
	}

	//Starts the game Thread
	private void startGame() {
		if(game == null || !running) {
			game = new Thread(this);
			game.start();
			running = true;
		}
	}
	
	//default method that we have overridden to start game
	public void addNotify() {
		super.addNotify();
		startGame();
	}
	
	//stops the game Thread
	public void stopGame() {
		if(running) {
			running = false;
		}
	}
	
	@SuppressWarnings("unused")
	private void log(String s) {
		System.out.println(s);
	}



	
}
