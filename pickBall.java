import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class pickBall extends JPanel implements ActionListener{
	private pokeball pokeballs[];
	private final int NUM_BALLS = 17, SPRITE_WIDTH = 41;
	private int activeIndex = 0, delay = 50;
	private Timer animator;
	
	public pickBall() {
		pokeballs = new pokeball[NUM_BALLS];
		for(int i = 0; i < NUM_BALLS; i++) {
			pokeballs[i] = new pokeball(i);
			pokeballs[i].freeze();
		}
		pokeballs[activeIndex].startRoll();
		
		
		animator = new Timer(delay, this);
		animator.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(pokeball ball: pokeballs)
			ball.getCurrentFrame().paintIcon(this, g, ball.getColNum() * SPRITE_WIDTH, 0);
	}
	
	public void rightActive() {
		pokeballs[activeIndex%NUM_BALLS].freeze();
		if(activeIndex != 16) {
			activeIndex++;
		}
		pokeballs[activeIndex%NUM_BALLS].startRoll();
	}
	
	public void leftActive() {
		pokeballs[activeIndex%NUM_BALLS].freeze();
		if(activeIndex != 0) 
			activeIndex--;
		pokeballs[activeIndex].startRoll();
	}
    
	public void shakeActive() {
		pokeballs[activeIndex].startShake();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	
}
