package com.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JPanel;

public class Bonus extends JPanel {

	private Image image = Toolkit.getDefaultToolkit().createImage(
			"res/bonus.png");
	private Random rand = new Random();
	int size = 30;
	public int x = Main.mainFrame.getWidth();
	public int y = rand.nextInt(Main.mainFrame.getHeight() - 20);
	private int randPlayerSize = 5 + rand.nextInt(40);
	private int randBonus = 1 + rand.nextInt(6);

	public void update() {
		x -= Main.speed;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, size, size, null);
	}

	public void getBonus() {
		switch (randBonus) {
		case 1:
			Main.player.height += randPlayerSize;
			Main.player.width += randPlayerSize;
			break;
		case 2:
			Main.speed = 5 + rand.nextInt(5);
			break;
		case 3:
			Main.player.height -= randPlayerSize;
			Main.player.width -= randPlayerSize;
			break;
		case 4:
			Main.speed = 1 + rand.nextInt(3);
			break;
		case 5:
			Main.player.invertControl = true;
			break;
		case 6:
			Main.score += 100;
			break;
		}
	}
}