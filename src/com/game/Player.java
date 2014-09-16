package com.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Player extends JPanel {
	private Image image = Toolkit.getDefaultToolkit().createImage(
			"res/penguin.gif");
	int x = 0;
	int y = 0;
	int width = 50;
	int height = 50;
	boolean collision = false;
	boolean bonuscollision = false;
	private  List<Projectile> projectiles = new ArrayList<Projectile>();

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, width, height, null);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).paintComponent(g);
		}
	}
	public void update(Input input){
		if(input.space){
			Projectile tempProjectile = new Projectile();
			tempProjectile.x=x;
			tempProjectile.y=y;
			projectiles.add(tempProjectile);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
			if(projectiles.get(i).x>=Main.mainFrame.getWidth()){
				projectiles.remove(i);
			}
		}
	}

	public boolean detectEnemyCollision(Enemy enemy) {
		for (int enemyY = 0; enemyY <= enemy.getRandHeight(); enemyY++) {
			for (int enemyX = 0; enemyX <= enemy.getRandWidth(); enemyX++) {
				if (((enemy.getX() + enemyX) - (x + width / 2))
						* ((enemy.getX() + enemyX) - (x + width / 2))
						+ ((enemy.getY() + enemyY) - (y + height / 2))
						* ((enemy.getY() + enemyY) - (y + height / 2)) <= (width
						/ 2 * width / 2)) {
					collision = true;
				}
			}
		}
		return collision;
	}

	public boolean detectBonusCollision(Bonus bonus) {
		for (int bonusY = 0; bonusY <= bonus.randSize; bonusY++) {
			for (int bonusX = 0; bonusX <= bonus.randSize; bonusX++) {
				if (((bonus.x + bonusX) - (x + width / 2))
						* ((bonus.x + bonusX) - (x + width / 2))
						+ ((bonus.y + bonusY) - (y + height / 2))
						* ((bonus.y + bonusY) - (y + height / 2)) <= (width
						/ 2 * width / 2)) {
					collision = true;
				}
			}
		}
		return collision;
	}
}
