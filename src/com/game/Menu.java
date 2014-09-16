package com.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;

public class Menu extends JPanel {
	private Image start = Toolkit.getDefaultToolkit().createImage(
			"res/start.png");
	private Image end = Toolkit.getDefaultToolkit().createImage("res/exit.png");
	private Image border = Toolkit.getDefaultToolkit().createImage(
			"res/border.png");
	private int index = 0;
	private int x = 0;
	private int y1 = 0;
	private int y2 = 0;
	private int width = 100;
	private int height = 50;
	private long score = 0;

	public void init(int x, int y1, int y2) {
		this.x = x;
		this.y1 = y1;
		this.y2 = y2;
		try {
			Scanner sc = new Scanner(Main.save);
			score = sc.nextLong();
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void setInput(boolean up, boolean down, boolean enter) {
		if (up && index == 1) {
			index = 0;
		}
		if (down && index == 0) {
			index = 1;
		}
		if (enter) {
			if (index == 0) {
				Main.panel.setGameRunning(true);
			}
			if (index == 1) {
				System.exit(0);
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(start, x, y1, width, height, null);
		g.drawImage(end, x, y2, width, height, null);
		g.setColor(Color.red);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("High Score: " + String.valueOf(score), x, y1 - 40);
		if (index == 0) {
			g.drawImage(border, x, y1, width, height, null);
		}
		if (index == 1) {
			g.drawImage(border, x, y2, width, height, null);
		}
	}
}
