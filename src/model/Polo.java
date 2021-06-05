package model;

import processing.core.PApplet;

public class Polo extends Agent {

	public Polo(float posX, float posY, PApplet app, int vel) {
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
		app.fill(255, 255, 0);
		app.stroke(200);
		app.circle(posX, posY, SIZE);
	}
	
	public void move() {
		
		int random1 = (int) app.random(1,28000);
		int random2 = (int) app.random(1,30000);
		int random3 = (int) app.random(1,2500);
		
		posX += 1*dirX*vel;
		posY += 1*dirY*vel;
		
		if(posX < (SIZE/2) || posX > (app.width - (SIZE/2))) {
			dirX *= -1;
		}
		if(posY < (SIZE/2) || posY > (app.height - (SIZE/2))) {
			dirY *= -1;
		}
		
		if(random1 % random3 == 0) {
			dirX *= -1;
		}
		if(random2 % random3 == 0) {
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
}
