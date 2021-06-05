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
		
	}
}
