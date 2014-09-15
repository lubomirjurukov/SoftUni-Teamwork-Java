package com.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Background extends JPanel{
	private int width = 0;
	private int height = 0;
	private Image image = Toolkit.getDefaultToolkit().createImage("res/test.jpg");
	private int x1 = 0;
	private int y1 = 0;
	private int x2 = 0;
	private int y2 = 0;
	public void update(int w,int h){
		this.width = w;
		this.height = h;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
        g.drawImage(image, x1, y1, width, height, null);
        g.drawImage(image, x2, y2, width, height, null);
	}
}
