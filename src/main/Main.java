package main;
import javax.swing.JFrame;
public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setTitle("2D adventure");
		
		GamePanel gamepanel = new GamePanel();
		window.add(gamepanel);
		
		window.pack();
		
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamepanel.startGame();
	}

}
