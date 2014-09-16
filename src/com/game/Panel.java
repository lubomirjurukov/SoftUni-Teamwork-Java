package com.game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener {
	private Random rand = new Random();
	private Input input = new Input();
	private boolean gameRunning = false;
	private int bonus = 100;
	private int bonusTime=0;

	public void setGameRunning(boolean gameRunning) {
		this.gameRunning = gameRunning;
	}

	private int timer = 0;

	// construct a Panel
	public Panel() {
		// setBackground(Color.BLACK);
		Main.enemys.add(new Enemy());
		Timer timer = new Timer(1000 / 60, this);
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		setFocusable(true);
		addKeyListener(input);
		step();
	}

	public void step() {
		if (gameRunning) {
			if (input.up && Main.player.getY() >= 0) {
				Main.player.y -= 3;
			}
			if (input.down
					&& Main.player.getY() <= Main.mainFrame.getHeight() - 90) {
				Main.player.y += 3;
			}
			if (input.left && Main.player.getX() >= 0) {
				Main.player.x -= 3;
			}
			if (input.right
					&& Main.player.getX() <= Main.mainFrame.getWidth() / 2 - 300) {
				Main.player.x += 3;
			}
			Main.player.update(input);
			if (timer == 10 && !(Main.enemys.size() > 40)) {
				Main.enemys.add(new Enemy());
				timer = 0;
			}
			for (int i = 0; i < Main.enemys.size(); i++) {
				Main.enemys.get(i).update();
				if (Main.player.detectEnemyCollision(Main.enemys.get(i))) {
					Main.player.collision = false;
					// System.exit(0);
				}
			}
			for (int i = 0; i < Main.bonus.size(); i++) {
				Main.bonus.get(i).update();
				if(Main.bonus.get(i).x<=0){
					Main.bonus.remove(i);
				}
				if (Main.player.detectBonusCollision(Main.bonus.get(i))) {
					Main.bonus.get(i).getBonus(input);// input, Main.enemys.get(k));
					Main.bonus.remove(i);
					bonusTime = 100;
					Main.player.collision = false;
				}
			}
			if(bonusTime!=0){
				bonusTime--;
			}
			if(bonusTime==0){
				Main.speed = 5;
				Main.player.height = 50;
				Main.player.width = 50;
			}
			if(bonus!=0){
				bonus--;
			}
			if(bonus==0){
				Main.bonus.add(new Bonus());
				bonus = 100+rand.nextInt(100);
			}
			Main.background.update();
			if (timer != 10) {
				timer++;
			}
		}
		if (!gameRunning) {
			Main.menu.setInput(input.up, input.down, input.enter);
		}
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!gameRunning) {
			Main.background.paintComponent(g);
			Main.menu.paintComponent(g);
		}
		if (gameRunning) {
			Main.background.paintComponent(g);
			Main.player.paintComponent(g);
			for (int i = 0; i < Main.enemys.size(); i++) {
				Main.enemys.get(i).paintComponent(g);
			}
			for (int i = 0; i < Main.bonus.size(); i++) {
				Main.bonus.get(i).paintComponent(g);
			}
		}
	}
}