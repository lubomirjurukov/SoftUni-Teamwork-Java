package com.game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.ArrayList;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener {
	private Random rand = new Random();
	private Input input = new Input();
	private static Sound soundOfDeath = new Sound("res/Death.wav");
	private boolean gameRunning = false;
	private int bonus = 100;
	private int bonusTime = 0;
	public boolean deathScreen = false;
	long gameOverTimer = 0;
	
	public void setGameRunning(boolean gameRunning) {
		this.gameRunning = gameRunning;
	}

	private int timer = 0;

	public Panel() {
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
			Main.player.update(input);
			if (timer == 10 && !(Main.enemys.size() > 40)) {
				Main.enemys.add(new Enemy());
				timer = 0;
			}
			for (int i = 0; i < Main.enemys.size(); i++) {
				Main.enemys.get(i).update();
				if (Main.player.detectEnemyCollision(Main.enemys.get(i))) {
					deathScreen = true;
					try {
						PrintWriter pw = new PrintWriter(Main.save);
						pw.println(String.valueOf(Main.score));
						pw.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
			for (int i = 0; i < Main.bonus.size(); i++) {
				Main.bonus.get(i).update();
				if(Main.bonus.get(i).x<=0){
					Main.bonus.remove(i);
				}
				if (Main.player.detectBonusCollision(Main.bonus.get(i))) {
					Main.bonus.get(i).getBonus(input);
					Main.bonus.remove(i);
					bonusTime = 100;
					Main.player.collisionBonus = false;
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
		if (deathScreen){
			gameOverTimer++;
			Main.sound.stop();
			soundOfDeath.play();
		}
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!gameRunning && !deathScreen) {
			Main.background.paintComponent(g);
			Main.menu.paintComponent(g);
		}
		if(gameRunning && deathScreen){
			g.drawImage(Main.background.gameOver, Main.mainFrame.getWidth()/2-200, 
					Main.mainFrame.getHeight()/2-200, 400, 400, null);
			if(gameOverTimer == 100){
				soundOfDeath.stop();
				Main.sound.loop();
				Main.score = 0;
				Main.menu.init(Main.mainFrame.getWidth() / 2 - 50, Main.mainFrame.getHeight() / 2,
						Main.mainFrame.getHeight() / 2 + 60);
				gameRunning = false;
				Main.player = new Player();
				Main.player.setY(Main.mainFrame.getHeight() / 2); 
				Main.enemys = new ArrayList<Enemy>();
				Main.bonus = new ArrayList<Bonus>();
				Main.background.paintComponent(g);
				Main.menu.paintComponent(g);
				deathScreen = false;
			}
		}
		if(gameRunning && !deathScreen) {
			Main.background.paintComponent(g);
			Main.player.paintComponent(g);
			g.setColor(Color.red);
			g.setFont(new Font("TimesRoman", Font.PLAIN,20));
			g.drawString(String.valueOf(Main.score),10,30);
			for (int i = 0; i < Main.enemys.size(); i++) {
				Main.enemys.get(i).paintComponent(g);
			}
			for (int i = 0; i < Main.bonus.size(); i++) {
				Main.bonus.get(i).paintComponent(g);
			}
		}
	}
}