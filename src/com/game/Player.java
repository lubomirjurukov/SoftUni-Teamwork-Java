package com.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Player extends JPanel{
	private Image image = Toolkit.getDefaultToolkit().createImage("res/penguin.jpg");
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
		int a = enemy.getY()+enemy.getRandHeight()/2;
		int b = enemy.getY();
		int R = image.getWidth(null)/2;
		for(int i = 0; i<R;i++){
			int y = R - i;
			double x = Math.sqrt(Math.pow(R,2) - Math.pow(y,2));
			x=Math.floor(x);
			if (x>=b && x<=a){
				return alive = false;
			}
		}
		for(int i = R-1; i<0;i--){
			int y = R - i;
			double x = Math.sqrt(Math.pow(R,2) - Math.pow(y,2));
			x=Math.floor(x);
			if (x>=b && x<=a){
				return alive = false;
			}
		}
		return alive = true;
	}
	
	public void ifAlive(boolean death) {
		if(!death) {
			
		}
	}
}
