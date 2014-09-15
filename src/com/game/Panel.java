package com.game;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener{
	private Input input = new Input();
	private boolean gameRunning = false;
	public void setGameRunning(boolean gameRunning) {
		this.gameRunning = gameRunning;
	}

	private int timer = 0;
    //construct a Panel
    public Panel(){
        //setBackground(Color.BLACK);
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
    	if(gameRunning){
    		if(input.up&&Main.player.getY()>=0){
    			Main.player.y-=3;
    		}
    		if(input.down&&Main.player.getY()<=Main.mainFrame.getHeight()-90){
    			Main.player.y+=3;
    		}
    		if(input.left&&Main.player.getX()>=0){
    		Main.player.x-=3;
    		}
	    	if(input.right&&Main.player.getX()<=Main.mainFrame.getWidth()/2-300){
	    		Main.player.x+=3;
	    	}
	    	if(timer==10&&!(Main.enemys.size()>40)){
	    		Main.enemys.add(new Enemy());
	    		timer=0;
	    	}
	        for(int i = 0;i<Main.enemys.size();i++){
	        	if(Main.player.detectCollision(Main.enemys.get(i))){
	        		System.exit(0);
	        	}
	        Main.enemys.get(i).update();
        }
        Main.background.update();
    	timer++;
    	}
	    if(!gameRunning){
	    	Main.menu.setInput(input.up, input.down,input.enter);
	    }
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(!gameRunning){
        	Main.background.paintComponent(g);
        	Main.menu.paintComponent(g);
        }
        if(gameRunning){
        	Main.background.paintComponent(g);
        	Main.player.paintComponent(g);
        	for(int i = 0;i<Main.enemys.size();i++){
        		Main.enemys.get(i).paintComponent(g);
        	}
        }
    }
}