package com.game;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Enemy extends JPanel {

    Random rand = new Random();

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
        X += 3;

    }
	public void paintComponent(Graphics g){
		super.paintComponent(g);
        g.fillRect(20, 20, 20, 20);
	}

}