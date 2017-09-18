import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pokeball {
	
	private ImageIcon shakeArray[], rollArray[], freezeArray[];
	public ImageIcon imageArray[];
	private int delay = 50, totalFrames = 17,currentFrame = 0, colNum, rollLength = 8, shakeNums[] = {0,11,12,13,12,11,0,14,15,16,15,14,0,0,0,0,0,0,0,0,9,9,9,8,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,8,9,0};
	private final int OPEN_START_INDEX = 24;
	private soundEffect pop = new soundEffect("pop.wav");
	final String START_PREFIX = "imageedit_1_7582461029 [www.imagesplitter.net]-";
	
	
	public pokeball(int colNum) {
		this.colNum = colNum;
		imageArray = new ImageIcon[totalFrames];
		rollArray = new ImageIcon[rollLength];
		shakeArray = new ImageIcon[shakeNums.length];
		freezeArray = new ImageIcon[1];
		for(int i = 0; i < imageArray.length; i++)
			imageArray[i] = new ImageIcon(START_PREFIX + i + "-" + colNum + ".png");
		freezeArray[0] = imageArray[0];
		for(int i = 0; i < rollLength; i++) {
			rollArray[i] = imageArray[i];
		}
		int j = 0;
		for(int num : shakeNums) {
			shakeArray[j] = imageArray[num];
			j++;
		}
	}
	
	public void startShake() {
		currentFrame = 0;
		imageArray = shakeArray;
	}
	
	public void startRoll() {
		currentFrame = 0;
		imageArray = rollArray;
	}
	
	public void freeze() {
		imageArray = freezeArray;
	}
	
	public ImageIcon getCurrentFrame() {
		if(imageArray.length > 1 && currentFrame%imageArray.length == 0 && currentFrame > 0)
			this.startRoll();
		if(currentFrame == OPEN_START_INDEX && imageArray.length == shakeArray.length) 
			pop.play();
		return imageArray[currentFrame++%imageArray.length];
	}
	
	public int getColNum() {
		return colNum;
	}

}
