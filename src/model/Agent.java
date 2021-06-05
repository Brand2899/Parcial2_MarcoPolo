package model;

import processing.core.PApplet;

public abstract class Agent implements Runnable {
	
	protected float posX;
	protected float posY;
	protected int vel;
	protected int dirX;
	protected int dirY;
	protected PApplet app;
	protected final int SIZE = 20;
	
	public Agent(float posX, float posY, PApplet app, int vel) {
		this.app = app;
		this.posX = posX;
		this.posY = posY;
		this.vel = vel;
		dirX = 1;
		dirY = 1;
	}
}
