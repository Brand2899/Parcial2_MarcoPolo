package view;

import processing.core.PApplet;
import controller.Controller;

public class Main extends PApplet {
	
	private Controller c;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}
	
	public void settings() {
		size(500, 500);
		c = new Controller(this);
	}
	
	public void settup() {
	
	}
	
	public void draw() {
		background(255);
		c.draw();
	}
}
