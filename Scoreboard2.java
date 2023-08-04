package pong;

import java.awt.Graphics2D;
import java.awt.Font;

import utilities.GDV5;

public class Scoreboard2{
	
	int P3Score = 0;
	
	
	public void Scoreboard(Graphics2D win) {
		Font f1 = new Font("Arial", Font.PLAIN, 30);
		win.setFont(f1);
		win.drawString("Score: " + P3Score, Pong.getMaxWindowX()/2 - 45, 30);
	}
}
