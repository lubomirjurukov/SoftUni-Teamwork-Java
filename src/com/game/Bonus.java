package com.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

import javax.swing.*;

public class Bonus extends JPanel {

	private Random rand = new Random();
	int randSize = rand.nextInt(30);
	int randPlayerSize = 25 + rand.nextInt(50);
	private int randBonus = rand.nextInt(6);

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

	public void update(int index) {
		x -= Main.speed;
		if (x <= 0) {
			Main.bonus.remove(index);
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillOval(x, y, randSize, randSize);
	}

	public void getBonus(Input input) {
		switch (randBonus) {
		case 1:
			System.out.println("Size changed!");
			Main.player.height = randPlayerSize;
			Main.player.width = randPlayerSize;
			break;
		case 2:
			System.out.println("Faster enemies!");
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
		}
	}
}