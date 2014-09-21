package com.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Projectile extends JPanel {
	public int x = 0;
	public int y = 0;
	public int size = 30;
	boolean collision = false;
	boolean disabled = false;
	private Image image = Toolkit.getDefaultToolkit().createImage(
			"res/iceshard.png");

	public void update(int index) {
		x += 7;
		for (int i = 0; i < Main.enemys.size(); i++) {
			if (enemyCollision(Main.enemys.get(i))) {
				Main.enemys.remove(i);
				collision = false;
				Main.score += 20;
				disableCollision();
			}
		}
	}

	private void disableCollision() {
		disabled = true;
	}

	private boolean enemyCollision(Enemy enemy) {
		if (!disabled) {
			for (int enemyY = 0; enemyY <= enemy.getRandHeight(); enemyY++) {
				for (int enemyX = 0; enemyX <= enemy.getRandWidth(); enemyX++) {
					if (((enemy.getX() + enemyX) - (x + size / 2))
							* ((enemy.getX() + enemyX) - (x + size / 2))
							+ ((enemy.getY() + enemyY) - (y + size / 2))
							* ((enemy.getY() + enemyY) - (y + size / 2)) <= (size
							/ 2 * size / 2)) {
						collision = true;
					}
				}
			}
		}
		return collision;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!disabled) {
			g.drawImage(image, x, y, size, size, null);
		}
	}
}