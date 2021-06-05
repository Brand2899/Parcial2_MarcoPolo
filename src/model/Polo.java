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
		posX += app.random(-2, 2);
		posY += app.random(-2, 2);
	}
}
