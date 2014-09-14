package com.game;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener{
	private Input input = new Input();
	private Image image = Toolkit.getDefaultToolkit().createImage("res/penguin.png");
	private int timer = 0;
    //construct a Panel
    public Panel(){
        //setBackground(Color.BLACK);
    	Main.player.setY(Main.mainFrame.getHeight()/2);
    	Main.enemys.add(new Enemy());
        Timer timer = new Timer(1000/60, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e){
    	setFocusable(true);
        addKeyListener(input);
        step();
    }

    public void step(){
    	if(input.up&&Main.player.y>=0){
    		Main.player.y-=3;
    	}
    	if(input.down&&Main.player.y<=Main.mainFrame.getHeight()-50){
    		Main.player.y+=3;
    	}
    	if(timer==10&&!(Main.enemys.size()>20)){
    		Main.enemys.add(new Enemy());
    		timer=0;
    	}
        for(int i = 0;i<Main.enemys.size();i++){
        	Main.player.detectCollision(Main.enemys.get(i));
        	Main.enemys.get(i).update();;
        } 
    	timer++;
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.drawImage(image, 0, 0, null);
        Main.player.paintComponent(g);
        for(int i = 0;i<Main.enemys.size();i++){
        	Main.enemys.get(i).paintComponent(g);
        }   
    }
}