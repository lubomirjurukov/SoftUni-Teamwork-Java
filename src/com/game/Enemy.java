package com.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JPanel;

public class Enemy extends JPanel {
	
	private Image image = Toolkit.getDefaultToolkit().createImage("res/enemy.png");
    Random rand = new Random();
    int randWidth = rand.nextInt(60)+ 30;
    int randHeight = rand.nextInt(60) + 30;
    
    public int getRandHeight() {
    	return this.randHeight;
    }
    
    public int getRandWidth() {
    	return this.randWidth;
    }
    
    public int getX() {
        return this.X;
    }

    public void setX(int x) {
        this.X = x;
    }

    public int getY() {
        return this.Y;
    }

    public int X;
    public int Y;

    public void generate(Enemy enemy) {
		
		if(enemy.Y!=(Y) && enemy.X == Main.mainFrame.getWidth()){
			while(enemy.Y==(Y)){
			Y = rand.nextInt(Main.mainFrame.getHeight()-20);
			}
    	}
	}
    
    public void update(){
        this.X -= 5;
        if(X <= 0) {
           
        	X= Main.mainFrame.getWidth();
            Y = rand.nextInt(Main.mainFrame.getHeight()-20);
              
             randWidth = rand.nextInt(60) + 30;
             randHeight = rand.nextInt(60) + 30;

        }

    }
	public void paintComponent(Graphics g){
		super.paintComponent(g);
        
        g.fillOval(X, Y, randWidth, randHeight);
        g.drawImage(image, X, Y, randWidth, randHeight, null);
	}

}