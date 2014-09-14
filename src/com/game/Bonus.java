package com.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

import javax.swing.*;

public class Bonus extends JPanel{

	private Random rand = new Random();
	int randSize = rand.nextInt(60);

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
    }

    public int X= Main.mainFrame.getWidth();
    public int Y = rand.nextInt(Main.mainFrame.getHeight()-20);
    public void update(){
        X -= 10;

        if(X <= 0) {
             X= Main.mainFrame.getWidth();
             Y = rand.nextInt(Main.mainFrame.getHeight()-20);
            randSize = rand.nextInt(160);

        }

    }
    
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillOval(X, Y, randSize, randSize);
	}
}