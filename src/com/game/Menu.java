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
	private Image title = Toolkit.getDefaultToolkit().createImage(
			"res/title.png");
	private Image start = Toolkit.getDefaultToolkit().createImage(
			"res/start.png");
	private Image about = Toolkit.getDefaultToolkit().createImage(
			"res/about.png");
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
	private int timer = 0;
	private boolean aboutScreen = false;

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
		if (up && index == 1 && timer == 10) {
			index = 0;
			timer = 0;
		}
		if (down && index == 0 && timer == 10) {
			index = 1;
			timer = 0;
		}
		if (up && index == 2 && timer == 10) {
			index = 1;
			timer = 0;
		}
		if (down && index == 1 && timer == 10) {
			index = 2;
			timer = 0;
		}
		if (enter) {
			if (index == 0 && timer == 10) {
				Main.panel.setGameRunning(true);
			}
			if (index == 1 && timer == 10) {
				index = -1;
				aboutScreen = true;
				timer = 0;
			}
			if (index == 2 && timer == 10) {
				System.exit(0);
			}
			if (aboutScreen && timer == 10) {
				aboutScreen = false;
				index = 0;
				timer = 0;
			}
		}
		if (timer != 10) {
			timer++;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!aboutScreen) {
			g.drawImage(title, Main.mainFrame.getWidth() / 2 - 400, 100, 800,
					400, null);
			g.drawImage(start, x, y1, width, height, null);
			g.drawImage(about, x, y2, width, height, null);
			g.drawImage(end, x, y2 + 60, width, height, null);
			g.setColor(Color.red);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g.drawString("High Score: " + String.valueOf(score), x, y1 - 40);
			if (index == 0) {
				g.drawImage(border, x, y1, width, height, null);
			}
			if (index == 1) {
				g.drawImage(border, x, y2, width, height, null);
			}
			if (index == 2) {
				g.drawImage(border, x, y2 + 60, width, height, null);
			}
		}
		if (aboutScreen) {
			g.setColor(Color.red);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g.drawString(
					"Created by: Lyubomir, Hristofor, NIkola, Kiril, Alexander, Teodor",
					Main.mainFrame.getWidth() / 2 - 400,
					Main.mainFrame.getHeight() / 2);
		}
	}
}
