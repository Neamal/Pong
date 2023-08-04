package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.awt.Font;

import utilities.GDV5;

public class Pong extends GDV5{
	
	Ball b1 = new Ball(20,20);
	Paddle p1 = new Paddle(20, Pong.getMaxWindowY()/2, 20, 140);
	Paddle p2 = new Paddle(Pong.getMaxWindowX() -40, Pong.getMaxWindowY()/2, 20, 140);
	static Ball b2 = new Ball(20,20);
	Paddle p3 = new Paddle(20, Pong.getMaxWindowY()/2, 20, 140);
	Paddle p4 = new Paddle(Pong.getMaxWindowX() -40, Pong.getMaxWindowY()/2, 20, 140);
	Scoreboard s = new Scoreboard();
	Scoreboard2 s2 = new Scoreboard2();
	boolean start = false;
	int gamemode = 0;
	static int P1Score = 0;
	static int P2Score = 0;
	static int P3Score = 0;
	Paddle p5 = new Paddle(Pong.getMaxWindowX()/2, 0, 5, 1000);
	Images image = new Images();
	
	public static void main(String[] args) {
		Pong p = new Pong();
		p.start();
		
	}
	
	public static int mode() {
		if (GDV5.KeysPressed[KeyEvent.VK_1]) {
			return 1;
		} else if (GDV5.KeysPressed[KeyEvent.VK_2]) {
			return 2;
		} else if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE]) {
			return 6;
		} else if (b2.dX == 0) {
			return 3;
		} else if (P1Score == 5) {
			return 4;
		} else if (P2Score == 5) {
			return 5;
		}
		return 0;
	}
	
	public void update() {
		if (gamemode == 1) b1.move(b1,p1,p2);
		System.out.println(GDV5.KeysPressed[KeyEvent.VK_W]);
		System.out.println(KeyEvent.VK_W);
		p1.controlPaddle();
		p2.controlPaddle2();
		if (gamemode == 2) b2.move2(b2,p3,p4);
		System.out.println(GDV5.KeysPressed[KeyEvent.VK_W]);
		System.out.println(KeyEvent.VK_W);
		p3.controlPaddle();
		System.out.println("Player 1 Score: " + P1Score + "Player 2 Score: " + P2Score);
		p4.y = b2.y - 60;
		s.P1Score=P1Score;
		s.P2Score=P2Score;
		s2.P3Score = P3Score;
		if (b1.x <= 0) P2Score++;
		if (b1.x >= Pong.getMaxWindowX()) P1Score++;
		if (b2.intersects(p3))  P3Score++;
	}
	
	public void draw(Graphics2D win) {
	
		if (mode() > 0) {
			start = true;
			if (mode() == 1) {
				gamemode = 1;
			} else if (mode() ==  2) {
				gamemode = 2;
			} else if (mode() ==  3) {
				gamemode = 3;
			} else if (mode() ==  4) {
				gamemode = 4;
			} else if (mode() == 5) {
				gamemode = 5;
			} else {
				gamemode = 6;
			}
		}
		
		int randomRed = (int) (Math.random() * 200) + 1;
		int randomBlue = (int) (Math.random() * 200) + 1;
		int randomGreen = (int) (Math.random() * 50) + 1;
		Color randomColor = new Color(randomRed, randomBlue, randomGreen);
		if (!start) {
			win.setColor(Color.RED);
			win.setFont(new Font("Arial", Font.BOLD, 100));
			win.drawString("Pong", Pong.getMaxWindowX()/2 - 120, 100);
			win.setFont(new Font("Arial", Font.ITALIC, 50));
			win.drawString("Press '1' for Multiplayer", Pong.getMaxWindowX()/2 - 250, 250);
			win.drawString("Press '2' for Singleplayer", Pong.getMaxWindowX()/2 - 250, 350);
			win.setColor(Color.GREEN);
			win.setFont(new Font("TimesNewRoman", Font.ITALIC, 20));
			win.drawString("Player One uses w key to go up and s key  to go down", 50, 500);
			win.drawString("Player Two uses o key to go up and l key to go down", 50, 540);
			win.drawString("Score on your opponent by making the ball hit the wall of their side!", 50, 600);
			win.setColor(Color.WHITE);
			win.drawString("For Single Player, use w to go up and s to go down", Pong.getMaxWindowX() - 500, 500);
			win.drawString("If you can't return the ball, you lose!", Pong.getMaxWindowX() - 500, 540);
			win.setFont(new Font("TimesNewRoman", Font.ITALIC, 25));
			win.drawString("By: Junhyung Yoon", Pong.getMaxWindowX()/2 - 100, 150);
			
		}
		if (gamemode == 1) {
			win.drawImage(image.background, 0, 0, Pong.getMaxWindowX(), Pong.getMaxWindowY(), null);
			win.setColor(randomColor);
			win.fillOval(b1.x, b1.y, b1.width, b1.height);
			win.draw(b1);
			win.fill(b1);
			win.setColor(Color.RED);
			win.draw(p1);
			win.fill(p1);
			win.draw(p2);
			win.fill(p2);
			s.Scoreboard(win);
			win.setColor(Color.GRAY);
			win.setFont(new Font("Arial", Font.BOLD, 20));
			win.drawString("Score 5 Points on your opponent to win!", Pong.getMaxWindowX()/2 - 165, 70);
			win.draw(p5);
		}
		if (gamemode == 2) {
			win.drawImage(image.background, 0, 0, Pong.getMaxWindowX(), Pong.getMaxWindowY(), null);
			win.setColor(randomColor);
			win.fillOval(b2.x, b2.y, b2.width, b2.height);
			win.draw(b2);
			win.fill(b2);
			win.setColor(Color.WHITE);
			win.draw(p3);
			win.fill(p3);
			win.draw(p4);
			win.fill(p4);
			s2.Scoreboard(win);
			win.setColor(Color.GRAY);
			win.setFont(new Font("Arial", Font.BOLD, 20));
			win.drawString("Try to get as many points as possible against the Computer!", Pong.getMaxWindowX()/2 - 215, 70);
			win.draw(p5);
		}
		if (gamemode == 3) {
			win.setColor(Color.GRAY);
			win.setFont(new Font("Arial", Font.BOLD, 100));
			win.drawString("Game Over", Pong.getMaxWindowX()/2 - 250, 200);
			win.setFont(new Font("TimesNewRoman", Font.BOLD, 70));
			win.drawString("Your Score Was: " + P3Score, Pong.getMaxWindowX()/2 - 270, 300);
			win.setFont(new Font("Arial", Font.BOLD, 50));
			win.drawString("Press Escape to Restart", Pong.getMaxWindowX()/2 - 290, 400);
		}
		if (gamemode == 4) {
			win.setColor(Color.GRAY);
			win.setFont(new Font("Arial", Font.BOLD, 100));
			win.drawString("Player 1 Wins!", Pong.getMaxWindowX()/2 - 320, 200);
			win.setFont(new Font("Arial", Font.BOLD, 50));
			win.drawString("Press Escape to Restart", Pong.getMaxWindowX()/2 - 290, 400);
		}
		if (gamemode == 5) {
			win.setColor(Color.GRAY);
			win.setFont(new Font("Arial", Font.BOLD, 100));
			win.drawString("Player 2 Wins!", Pong.getMaxWindowX()/2 - 320, 200);
			win.setFont(new Font("Arial", Font.BOLD, 50));
			win.drawString("Press Escape to Restart", Pong.getMaxWindowX()/2 - 290, 400);
		}
		if (gamemode == 6) {
			GDV5.KeysTyped[KeyEvent.VK_1] = false;
			GDV5.KeysTyped[KeyEvent.VK_2] = false;
			GDV5.KeysTyped[KeyEvent.VK_ESCAPE] = false;
			start = false;
			P1Score = 0;
			P2Score = 0;
			P3Score = 0;
			b2.dX = 5;
			b2.x = 25;
			b2.y = 25;
			b1.x = 25;
			b2.y = 25;
			win.setColor(Color.RED);
			win.setFont(new Font("Arial", Font.BOLD, 100));
			win.drawString("Pong", Pong.getMaxWindowX()/2 - 120, 100);
			win.setFont(new Font("Arial", Font.ITALIC, 50));
			win.drawString("Press '1' for Multiplayer", Pong.getMaxWindowX()/2 - 250, 250);
			win.drawString("Press '2' for Singleplayer", Pong.getMaxWindowX()/2 - 250, 350);
		}
	}

}
