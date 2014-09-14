package com.game;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Player extends JPanel{

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillOval(10, 50, 20, 20);
	}
}
