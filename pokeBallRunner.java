import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class pokeBallRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		pickBall pkball = new pickBall();
		//TODO figure out how the fuck to play music with standard libs/ how the fuck to play sound effects while bgm runs
		musicPlayer MP = new musicPlayer();
		f.add(pkball);
		f.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					pkball.rightActive();
					break;
				case KeyEvent.VK_LEFT:
					pkball.leftActive();
					break;
				case KeyEvent.VK_SPACE:
					pkball.shakeActive();
				default:
					break;
				}
			}
		});
		f.setTitle("Pokéballerz".toUpperCase());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(41*17 + 20, 100);
		
	}

}
