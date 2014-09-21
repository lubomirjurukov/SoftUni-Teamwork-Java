package com.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class Background extends JPanel {

	private int width = 0;
	private int height = 0;
	private Image image = Toolkit.getDefaultToolkit().createImage(
			"res/background.png");
	public Image gameOver = Toolkit.getDefaultToolkit().createImage(
			"res/gameover.png");
	private int x1 = 0;
	private int y1 = 0;
	private int x2 = 0;
	private int y2 = 0;
	private int speed = Main.speed;
	private boolean init = true;
	private TimeUnit unit;

	public void init(int w, int h) {
		if (init) {
			this.width = w;
			this.height = h;
			this.x2 = w;
			init = false;
		}
	}

	public void update() {
		if (Main.speed == 0) {
			x1 = 0;
			x2 = 0;
		} else {
			x1 -= Main.speed;
			x2 -= Main.speed;
			if (Math.abs(x1) >= width) {
				x1 = width + (width - Math.abs(x1));
			}
			if (Math.abs(x2) >= width) {
				x2 = width + (width - Math.abs(x2));
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x1, y1, width, height, null);
		g.drawImage(image, x2, y2, width, height, null);
	}
}
