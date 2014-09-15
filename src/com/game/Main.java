package com.game;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Main{
	public static Player player = new Player();
	public static Background background = new Background();
	public static JFrame mainFrame = new JFrame("");
	public static List<Enemy> enemys = new ArrayList<Enemy>();
	private static boolean init = false;
	public static void main(String[] args) {
		mainFrame.setSize(1280, 720);
    	mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Panel panel = new Panel();
    	mainFrame.add(panel);
    	mainFrame.setVisible(true);
    	if(!init){
    		player.setY(mainFrame.getHeight()/2);
    		background.init(mainFrame.getWidth(), mainFrame.getHeight());
    		init = true;
    	}
	}
}