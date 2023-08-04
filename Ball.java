package pong;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;

public class Ball extends Rectangle{
	
	double dX, dY;

	public Ball(int w, int h) {
		super(25, 25, w, h);
		dX = 5;
		dY = 5;
	}
	public void move(Ball ball, Paddle paddle, Paddle paddle2) {
		this.x += dX;
		this.y += dY;
		if (this.y >= Pong.getMaxWindowY()) this.dY = -this.dY;
		if (this.x <= 0) this.dX = -this.dX;
		if (this.y <= 0) this.dY = -this.dY;
		if (this.x >= Pong.getMaxWindowX()) this.dX = -this.dX;
		
		if(ball.intersects(paddle) ) {
			ball.dX = -ball.dX;
			ball.dX++;
		}
		if(ball.intersects(paddle2)) {
			ball.dX = -ball.dX;
			}
		}
	
	public void move2(Ball ball, Paddle paddle, Paddle paddle2) {
		this.x += dX;
		this.y += dY;
		if (this.y >= Pong.getMaxWindowY()) this.dY = -this.dY;
		if (this.x <= 0) this.dX = 0;
		if (this.y <= 0) this.dY = -this.dY;
		if (this.x >= Pong.getMaxWindowX() - 1) this.dX = -this.dX;
		
		if(ball.intersects(paddle)) {
			ball.dX = -ball.dX;
			ball.dX++;
		}
		if(ball.intersects(paddle2)) {
			ball.dX = -ball.dX;
			}
		}

}
