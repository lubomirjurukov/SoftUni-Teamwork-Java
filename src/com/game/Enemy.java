package com.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JPanel;

public class Enemy extends JPanel {

	private Image image = Toolkit.getDefaultToolkit().createImage(
			"res/enemy.png");
	Random rand = new Random();
	int randWidth = rand.nextInt(60) + 30;
	int randHeight = rand.nextInt(60) + 30;
	public int x;
	public int y;
	private boolean init = false;

	private void init() {
		x = Main.mainFrame.getWidth();
		y = rand.nextInt(Main.mainFrame.getHeight() - 20);
		init = true;
	}

	public void update() {
		if (!init) {
			init();
		}
		this.x -= Main.speed;
		if (x + randWidth <= 0) {
			x = Main.mainFrame.getWidth();
			y = rand.nextInt(Main.mainFrame.getHeight() - 20);
			randWidth = rand.nextInt(60) + 30;
			randHeight = rand.nextInt(60) + 30;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, randWidth, randHeight, null);
	}
}