package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int originalTileSize = 16;
	final int scale = 3;
	
	final int tilesize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tilesize * maxScreenCol;
	final int screenHeight = tilesize * maxScreenRow;
	
	keyHandler keyH = new keyHandler();
	Thread gameThread;
	
	int playerX = screenWidth/2;
	int playerY = screenHeight/2;
	int playerSpeed = 4;
	// FPS
	int FPS = 240;
	
	
	
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGame() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	@Override
	public void run() {
		while(gameThread!= null) {
			
			// System.out.println("The game loop is running ");
//			long currentTime= System.nanoTime();
//			long currrentTime2 = System.currentTimeMillis();
			
			double drawInterval = 1000000000/FPS;
			double nextDrawTime = System.nanoTime() + drawInterval;
			
			
			update();
			repaint();
			
			try {
				double remaningTime = nextDrawTime - System.nanoTime();
				remaningTime = remaningTime/1000000;
				
				Thread.sleep((long) remaningTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void update() {
		if(keyH.upPressed == true) {
			playerY -= playerSpeed;
		}
		
		else if(keyH.downPressed == true) {
			playerX += playerSpeed;
			
			
		}
		else if(keyH.leftPressed == true) {
			playerX -= playerSpeed;
			
		}
		else if(keyH.rightPressed == true) {
			playerY += playerSpeed;
			
		}
		
		if(playerX == screenWidth ) {
			playerX = 0;
		}
		
		else if(playerX == 0 ) {
			playerX = screenWidth;
		}
		
		if(playerY == screenHeight) {
			playerY = 0;
		}
		else if(playerY == 0) {
			playerY = screenHeight;
		}
		
			
		
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, tilesize , tilesize);
		g2.dispose();
		
		
		 
	}
}
