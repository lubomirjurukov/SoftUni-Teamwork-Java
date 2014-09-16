package com.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Background extends JPanel {
	private int width = 0;
	private int height = 0;
	private Image image = Toolkit.getDefaultToolkit().createImage(
			"res/test.jpg");
	private int x1 = 0;
	private int y1 = 0;
	private int x2 = 0;
	private int y2 = 0;
	private int speed = 5;
	private boolean init = true;

	public void init(int w, int h) {
		if (init) {
			this.width = w;
			this.height = h;
			this.x2 = w;
			init = false;
		}
	}

	public void update() {
		x1 -= Main.speed;
		x2 -= Main.speed;
		if (Math.abs(x1) >= width) {
			x1 = width;
		}
		if (Math.abs(x2) >= width) {
			x2 = width;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x1, y1, width+5, height, null);
		g.drawImage(image, x2, y2, width+5, height, null);
	}
}
