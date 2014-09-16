package com.game;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Main {
	public static Player player = new Player();
	public static int speed = 5;
	public static Background background = new Background();
	public static JFrame mainFrame = new JFrame("");
	public static List<Enemy> enemys = new ArrayList<Enemy>();
	public static List<Bonus> bonus = new ArrayList<Bonus>();
	public static Panel panel = new Panel();
	public static Menu menu = new Menu();
	public static Sound sound = new Sound("res/sound.wav");
	public static File save = new File("res/save.txt");
	private static boolean init = false;

	public static long score = 0;

	public static void main(String[] args) {
		mainFrame.setSize(1280, 720);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.add(panel);
		mainFrame.setVisible(true);
		sound.loop();
		if (!init) {
			menu.init(mainFrame.getWidth() / 2 - 50, mainFrame.getHeight() / 2,
					mainFrame.getHeight() / 2 + 60);
			player.setY(mainFrame.getHeight() / 2);
			background.init(mainFrame.getWidth(), mainFrame.getHeight());
			init = true;
		}
	}
}