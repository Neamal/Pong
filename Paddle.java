package pong;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class Paddle extends Rectangle {
	
	double dY;
	
	public Paddle(int x, int y, int w, int h) {
		super(x, y, w, h);
		dY = 12;
	}
	
	public void controlPaddle() {
		if (GDV5.KeysPressed[KeyEvent.VK_S]) {
			this.y += dY;
		} else if (GDV5.KeysPressed[KeyEvent.VK_W]) {
			this.y -= dY;
		} else {
			this.y = this.y;
		}
	}
	public void controlPaddle2() {
		if (GDV5.KeysPressed[KeyEvent.VK_L]) {
			this.y += dY;
		} else if (GDV5.KeysPressed[KeyEvent.VK_O]) {
			this.y -= dY;
		} else {
			this.y = this.y;
		}
	}
}

