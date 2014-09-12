import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener{

    private int x = 250;
    private int y = 250;
    private int diameter = 20;
    //construct a Panel
    public Panel(){
        //setBackground(Color.BLACK);
        //call step() 60 fps
        Timer timer = new Timer(1000/60, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e){
        step();
    }

    public void step(){
    	//movement
        repaint();
    }

    //paint 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.setColor(Color.WHITE);
        g.fillOval(x, y, diameter, diameter);
    }
}