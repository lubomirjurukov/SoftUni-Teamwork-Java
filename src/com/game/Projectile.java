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
		for (int i = 0; i < Main.enemies.size(); i++) {
			if (enemyCollision(Main.enemies.get(i))) {
				Main.enemies.remove(i);
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
			for (int enemyY = 0; enemyY <= enemy.randHeight; enemyY++) {
				for (int enemyX = 0; enemyX <= enemy.randWidth; enemyX++) {
					if (((enemy.x + enemyX) - (x + size / 2))
							* ((enemy.x + enemyX) - (x + size / 2))
							+ ((enemy.y + enemyY) - (y + size / 2))
							* ((enemy.y + enemyY) - (y + size / 2)) <= (size
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