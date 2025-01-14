package entity;

import main.GamePanel;
import main.keyHandler;

public class player extends entity{
	GamePanel gp;
	keyHandler keyH;
	
	public player(GamePanel gp , keyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
	}
	
	
}
