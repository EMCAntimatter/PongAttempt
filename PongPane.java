package pong;

import java.awt.*;
import java.awt.geom.*;
import java.applet.Applet;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class PongPane extends JPanel {
    int x = 0;
    int xBall = 250;
    int yBall = 250;
    
    int PaddleMoveSpeed = 10;
    
    int x1Paddle1 = 10;
    int x2Paddle1 = 10;
    int y1Paddle1 = 150;
    int y2Paddle1 = 250;
    
    int x1Paddle2 = 450;
    int x2Paddle2 = 450;
    int y1Paddle2 = 150;
    int y2Paddle2 = 250;
    

    
    boolean running = true;
    
    public PongPane(){
        
        // Compute the new ball coordinates 
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                            
                if (running) {
                    //GAME_LOOP
                                        repaint();
                }
            }
        });
        timer.start();
    }
    
    public void start() {
        if (!running) {
            running = true;
            repaint();
        }
    }
    @Override
    public void paintComponent(Graphics comp){
        
        Ball gameBall = new Ball(xBall, yBall, comp);
        Paddle paddle1 = new Paddle(x1Paddle1, y1Paddle1, x2Paddle1, y2Paddle1, comp);
        Paddle paddle2 = new Paddle(x1Paddle2, y1Paddle2, x2Paddle2, y2Paddle2, comp);
        
        
        @Override
        public void paintComponent(Graphics comp){
         super.paintComponent(comp);
     
            wipe(comp);
            draw(comp);
        
        
       }
    }

    
    public void draw(Graphics comp){
        comp.setColor(Color.red);
        gameBall.ballUpdate(xBall, yBall, comp);
        
        comp.setColor(Color.blue);
        paddle1.paddleUpdate(x1Paddle1, y1Paddle1, x2Paddle1, y2Paddle1, comp);
        paddle2.paddleUpdate(x1Paddle2, y1Paddle2, x2Paddle2, y2Paddle2, comp);
    }
    public void wipe(Graphics comp)
    {
        
        comp.setColor(Color.white);
        gameBall.ballUpdate(xBall, yBall, comp);
        paddle1.paddleUpdate(x1Paddle1, y1Paddle1, x2Paddle1, y2Paddle1, comp);
        paddle2.paddleUpdate(x1Paddle2, y1Paddle2, x2Paddle2, y2Paddle2, comp);
    }

}
