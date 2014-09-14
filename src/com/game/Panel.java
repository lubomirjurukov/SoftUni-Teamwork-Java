package com.game;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener{
	private Input input = new Input();
    //construct a Panel
    public Panel(){
        //setBackground(Color.BLACK);
        //call step() 60 fps
        Timer timer = new Timer(1000/60, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e){
    	setFocusable(true);
        addKeyListener(input);
        step();
    }

    public void step(){
    	//movement
    	new Enemy().update();
        repaint();
    }
    //paint 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Main.player.paintComponent(g);
        new Enemy().paintComponent(g);
    }
}