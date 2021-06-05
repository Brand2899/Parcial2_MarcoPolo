package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class World {
	
	private PApplet app;
	private ArrayList<Polo> polos;
	private Marco marco;
	
	public World(PApplet app) {
		this.app = app;
		polos = new ArrayList<Polo>();
		createPolos();
		createMarco();
	}
	
	public PApplet getApp() {
		return app;
	}

	public ArrayList<Polo> getPolos() {
		return polos;
	}

	public Marco getMarco() {
		return marco;
	}
	
	public void start() {
		for(int i = 0; i < polos.size(); i++) {
			new Thread(polos.get(i)).start();
		}
		new Thread(marco).start();
	}
	
	public void draw() {
		for(int i = 0; i < polos.size(); i++) {
			polos.get(i).draw();
		}
		marco.draw();
	}
	
	public void createPolos() {
		for(int i = 0; i < 20; i++) {
			float posX = app.random(20, 480);
			float posY = app.random(20, 480);
			
			polos.add(new Polo(posX, posY, app, 10));
		}
	}
	
	public void createMarco() {
		
		float posX = app.random(20, 480);
		float posY = app.random(20, 480);
		
		marco = new Marco(posX, posY, app, 20);
	}
}
