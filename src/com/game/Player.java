package com.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Player extends JPanel{
	private Image image = Toolkit.getDefaultToolkit().createImage("res/penguin.png");
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
		g.drawImage(image,x,y,null);
	}
	
	public boolean detectCollision(Enemy enemy){
			return (enemy.getX()-x)*(enemy.getX()-x) + (enemy.getY()-y)*(enemy.getY()-y) <= (50 * 50);
		
		//return alive = true;
	}
	
	public void ifAlive(boolean death) {
		if(death) {
			System.exit(0);
		}
	}
}
