import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class soundEffect {
	private String soundFileName;
	private Clip clip;
	public soundEffect(String name) {
		soundFileName = name;
		File soundFile = new File(soundFileName);
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
	}
	public void play() {
		
		if(clip.isRunning())
			clip.stop();
		clip.setFramePosition(0);
		clip.start();
	}
}


