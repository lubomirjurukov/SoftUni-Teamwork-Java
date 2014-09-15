package com.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

import javax.swing.*;

public class Bonus extends JPanel{

	private Random rand = new Random();
	private int randSize = rand.nextInt(30);
	private int randBonus = rand.nextInt(6);

    public int getXcoor() {
        return X_COOR;
    }

    public void setX(int x) {
        X_COOR = x;
    }

    public int getY() {
        return Y_COOR;
    }

    public void setY(int y) {
    }

    private int X_COOR= Main.mainFrame.getWidth();
    private int Y_COOR = rand.nextInt(Main.mainFrame.getHeight()-20);
    public void update(){
        X_COOR -= 20;

        if(X_COOR <= 0) {
             X_COOR= Main.mainFrame.getWidth();
             Y_COOR = rand.nextInt(Main.mainFrame.getHeight()-20);
            randSize = rand.nextInt(160);
            randBonus = rand.nextInt(5);
        }

    }
    
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillOval(X_COOR, Y_COOR, randSize, randSize);
	}
	
	public void checkPlayerPosition(Player player) {
		int xPlayer = player.x;
		int yPlayer = player.y;
		
		if (xPlayer == this.X_COOR && yPlayer == this.Y_COOR) {
			getBonus(randBonus);
		}
	}
	private Player player;
	private Enemy enemy;
	private int enemySpeed = enemy.X;
	private int changeEnemySpeed = rand.nextInt(20 - enemySpeed);
	private Input controller;
	
	private void getBonus(int bonus) {
		
		switch (bonus) {
		case 1:
			System.out.println("Size changed!");
			player.height = player.height + randSize;
			player.width = player.width + randSize;
			break;
		case 2:
			System.out.println("Faster enemies!");
			enemy.X -= changeEnemySpeed;
			break;
		case 3:
			player.height -= randSize;
			player.width -= randSize;
			break;
		case 4:
			enemy.X += changeEnemySpeed;
			break;
		case 5: 
			boolean keepController = controller.up;
			controller.up = controller.down;
			controller.down = keepController;
			keepController = controller.left;
			controller.left = controller.right;
			controller.right = keepController;
			break;
			
		default: 
			enemy.X = 0;
			break;
		}
	}
}