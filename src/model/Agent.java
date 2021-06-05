package model;

import processing.core.PApplet;

public abstract class Agent implements Runnable {
	
	protected float posX;
	protected float posY;
	protected int vel;
	protected float dirX;
	protected float dirY;
	protected PApplet app;
	protected final int SIZE = 25;
	
	public Agent(float posX, float posY, PApplet app, int vel) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
	}
}
