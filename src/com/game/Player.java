package com.game;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Player extends JPanel{
	
	int x = 0;
	int y = 0;
	boolean alive = true;
	
	public int getX(){
		return this.x;
	}
	public void setX(int x){
		this.x = x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setLive(boolean death) {
		this.alive = death;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillOval(x, y, 20, 20);
	}
	
	public boolean detectCollision(Enemy enemy){
		int a = enemy.getX();
		int b = enemy.getY();
		if (this.x == a && this.y == b) {
			return true;
		} 
		else {
			return false;}
	}
	
}
