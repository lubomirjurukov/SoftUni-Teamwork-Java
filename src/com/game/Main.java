package com.game;
import javax.swing.JFrame;

public class Main{
	public static Player player = new Player();
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("");
		mainFrame.setSize(800, 600);
    	mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Panel panel = new Panel();
    	mainFrame.add(panel);
    	mainFrame.setVisible(true);
	}
}