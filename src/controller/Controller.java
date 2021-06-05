package controller;

import processing.core.PApplet;
import model.World;

public class Controller {
	
	private PApplet app;
	private World w;
	
	public Controller(PApplet app) {
		this.app = app;
		w = new World(app);
	}
	
	public void draw() {
		w.draw();
	}
}
