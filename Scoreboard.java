package pong;

import java.awt.Graphics2D;
import java.awt.Font;

import utilities.GDV5;

public class Scoreboard{
	
	int P1Score = 0;
	int P2Score = 0;
	
	
	public void Scoreboard(Graphics2D win) {
		Font f1 = new Font("Arial", Font.PLAIN, 30);
		win.setFont(f1);
		win.drawString(P1Score + "  |", Pong.getMaxWindowX()/2 - 35, 30);
		Font f2 = new Font("Arial", Font.PLAIN, 30);
		win.setFont(f2);
		win.drawString("|  " + P2Score, Pong.getMaxWindowX()/2 -5, 30);
	}
}
