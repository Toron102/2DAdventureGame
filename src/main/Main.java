package main;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Main {

	public static void main(String[] args) {

		JLayeredPane layered;
		JFrame window = new JFrame();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("2D Game");

		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);

		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		
		layered = new JLayeredPane(); 
		window.setContentPane(layered);
		layered.setOpaque(true); 
		layered.add(gamePanel);
		
		
		gamePanel.setupGame();
		gamePanel.startGameThread();

	}

}
