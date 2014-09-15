package com.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

import javax.swing.*;

public class Bonus extends JPanel {

	private Random rand = new Random();
	int randSize = rand.nextInt(30);
	private int randBonus = rand.nextInt(6);

	public int getXcoor() {
		return X_COOR;
	}

	public void setX(int x) {
		X_COOR = x;
	}

	public int getY() {
		return Y_COOR;
	}

	private int X_COOR = Main.mainFrame.getWidth();
	private int Y_COOR = rand.nextInt(Main.mainFrame.getHeight() - 20);

	public void update() {
		X_COOR -= Main.speed;
		// Main.bonus.remove(this);
		if (X_COOR <= 0) {
			Y_COOR = rand.nextInt(Main.mainFrame.getHeight() - 20);
			// Main.toRemove.add(this);
			X_COOR = Main.mainFrame.getWidth();
			Y_COOR = rand.nextInt(Main.mainFrame.getHeight() - 20);
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillOval(X_COOR, Y_COOR, randSize, randSize);
	}

	public void getBonus() {// Input input, Enemy enemy) {
		System.out.println("test");
		int changeEnemySpeed = 10 + rand.nextInt(10);
		// switch (randBonus) {
		// case 1:
		// System.out.println("Size changed!");
		// Main.player.height = Main.player.height + randSize;
		// Main.player.width = Main.player.width + randSize;
		// break;
		// case 2:
		// System.out.println("Faster enemies!");
		// Main.speed -= changeEnemySpeed;
		// break;
		// case 3:
		// Main.player.height -= randSize;
		// Main.player.width -= randSize;
		// break;
		// case 4:
		// Main.speed += changeEnemySpeed;
		// break;
		// case 5:
		// boolean keepController = input.up;
		// input.up = input.down;
		// input.down = keepController;
		// keepController = input.left;
		// input.left = input.right;
		// input.right = keepController;
		// break;
		//
		// default:
		// enemy.X = 0;
		// break;
		// }
		Main.toRemove.add(this);
	}
}