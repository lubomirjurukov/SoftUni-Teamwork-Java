package com.game;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Enemy extends JPanel {

    Random rand = new Random();
    int randWidth = rand.nextInt(60);
    int randHeight = rand.nextInt(60);
    
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

    public int X= Main.mainFrame.getWidth();
    public int Y = rand.nextInt(Main.mainFrame.getHeight()-20);
    public void update(){
        this.X -= 5;

        if(X <= 0) {
             X= Main.mainFrame.getWidth();
             Y = rand.nextInt(Main.mainFrame.getHeight()-20);
            randWidth = rand.nextInt(160);
            randHeight = rand.nextInt(160);

        }

    }
	public void paintComponent(Graphics g){
		super.paintComponent(g);
        g.fillRect(X, Y, randWidth, randHeight);
	}

}