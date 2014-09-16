package com.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JPanel;

public class Bonus extends JPanel {

	private Random rand = new Random();
	private Image image = Toolkit.getDefaultToolkit().createImage(
			"res/bonus.png");
	int size = 30;
	int randSize = 25 + rand.nextInt(30);
	int randPlayerSize = 60;
	private int randBonus = 1 + rand.nextInt(6);

	public int getXcoor() {
		return x;
	}

	public void setX(int X) {
		x = X;
	}

	public int getY() {
		return y;
	}

	public int x = Main.mainFrame.getWidth();
	public int y = rand.nextInt(Main.mainFrame.getHeight() - 20);

	public void update() {
		x -= Main.speed;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, size, size, null);
	}

	public void getBonus(Input input) {
		switch (randBonus) {
		case 1:
			Main.player.height = randPlayerSize;
			Main.player.width = randPlayerSize;
			break;
		case 2:
			Main.speed = 6 + rand.nextInt(5);
			break;
		case 3:
			Main.player.height -= randSize;
			Main.player.width -= randSize;
			break;
		case 4:
			Main.speed = 1 + rand.nextInt(4);
			break;
		case 5:
			boolean keepController = input.up;
			input.up = input.down;
			input.down = keepController;
			keepController = input.left;
			input.left = input.right;
			input.right = keepController;
			break;
		case 6:
			Main.score += 100;
			break;
		}
	}
}