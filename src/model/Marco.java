package model;

import processing.core.PApplet;

public class Marco extends Agent {

	public Marco(float posX, float posY, PApplet app, int vel) {
		super(posX, posY, app, vel);
	}

	@Override
	public void run() {
		move();
		
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void draw() {
		app.fill(255, 0, 0);
		app.noStroke();
		app.circle(posX, posY, SIZE);
	}
	
	public void move() {
		posX += 1*dirX*vel;
		posY += 1*dirY*vel;
		
		if(posX < (SIZE/2) || posX > (app.width - (SIZE/2))) {
			dirX *= -1;
		}
		if(posY < (SIZE/2) || posY > (app.height - (SIZE/2))) {
			dirY *= -1;
		}
	}
	
	
	
	public float getPosX() {
		return posX;
	}
	
	public float getPosY() {
		return posY;
	}
	
	public int getDirX() {
		return dirX;
	}
	
	public int getDirY() {
		return dirY;
	}
	
	public void setDirX(int dirX) {
		this.dirX = dirX;
	}
	
	public void setDirY(int dirY) {
		this.dirY = dirY;
	}
}
