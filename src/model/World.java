package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class World {
	
	private PApplet app;
	private ArrayList<Polo> polos;
	private Marco marco;
	private final int NUM_POLOS;
	
	public World(PApplet app) {
		this.app = app;
		polos = new ArrayList<Polo>();
		NUM_POLOS = (int) app.random(20, 50);
		
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
	
	public void draw() {
		for(int i = 0; i < polos.size(); i++) {
			polos.get(i).draw();
		}
		
		marco.draw();
		chase();
		displayMessage();
		
		for(int i = 0; i < polos.size(); i++) {
			new Thread(polos.get(i)).start();
		}
		new Thread(marco).start();
	}
	
	public void createPolos() {
		for(int i = 0; i < NUM_POLOS; i++) {
			float posX = app.random(20, 480);
			float posY = app.random(20, 480);
			
			polos.add(new Polo(posX, posY, app, 1));
		}
	}
	
	public void createMarco() {
		
		float posX = app.random(20, 480);
		float posY = app.random(20, 480);
		
		marco = new Marco(posX, posY, app, 2);
	}
	
	@SuppressWarnings("static-access")
	public void chase() {
		float shortestDis = 500;
		float calcDis = 0;
		int arrayPos = 0;
		
		for(int i = 0; i < polos.size();i++) {
			calcDis = app.dist(marco.getPosX(), marco.getPosY(), polos.get(i).getPosX(), polos.get(i).getPosY());
			
			if(calcDis < shortestDis) {
				
				shortestDis = calcDis;
				arrayPos = i;
			}
		}
		
		try {
			if(polos.get(arrayPos).getPosX() == marco.getPosX() && polos.get(arrayPos).getPosY() < marco.getPosY()) {
				marco.setDirX(0);
				marco.setDirY(-1);
			}
			else if(polos.get(arrayPos).getPosX() > marco.getPosX() && polos.get(arrayPos).getPosY() < marco.getPosY()) {
				marco.setDirX(1);
				marco.setDirY(-1);
			}
			else if(polos.get(arrayPos).getPosX() > marco.getPosX() && polos.get(arrayPos).getPosY() == marco.getPosY()) {
				marco.setDirX(1);
				marco.setDirY(0);
			}
			else if(polos.get(arrayPos).getPosX() > marco.getPosX() && polos.get(arrayPos).getPosY() > marco.getPosY()) {
				marco.setDirX(1);
				marco.setDirY(1);	
			}
			
			
			
			else if(polos.get(arrayPos).getPosX() == marco.getPosX() && polos.get(arrayPos).getPosY() > marco.getPosY()) {
				marco.setDirX(0);
				marco.setDirY(1);	
			}
			else if(polos.get(arrayPos).getPosX() < marco.getPosX() && polos.get(arrayPos).getPosY() > marco.getPosY()) {
				marco.setDirX(-1);
				marco.setDirY(1);	
			}
			else if(polos.get(arrayPos).getPosX() < marco.getPosX() && polos.get(arrayPos).getPosY() == marco.getPosY()) {
				marco.setDirX(-1);
				marco.setDirY(0);	
			}
			else if(polos.get(arrayPos).getPosX() < marco.getPosX() && polos.get(arrayPos).getPosY() < marco.getPosY()) {
				marco.setDirX(-1);
				marco.setDirY(-1);	
			}
			
			if(app.dist(marco.getPosX(), marco.getPosY(), polos.get(arrayPos).getPosX(), polos.get(arrayPos).getPosY()) < 22) {
				polos.remove(arrayPos);
			}
		}
		catch(IndexOutOfBoundsException e) {
			e.getLocalizedMessage();
		}
		
		if(polos.size() == 0) {
			marco.setDirX(0);
			marco.setDirY(0);
		}
		
		//System.out.println(shortestDis);
		//System.out.println(arrayPos);
	}
	
	
	@SuppressWarnings("static-access")
	public void displayMessage() {
		
		if(app.second() % 2 == 0) {
			if(polos.size() != 0) {
				int posx = (int) marco.getPosX();
				int posy = (int) marco.getPosY();
				
				app.fill(0);
				app.textAlign(app.CENTER);
				app.text("Marco", marco.getPosX(), marco.getPosY() - 15);
				app.text(posx, marco.getPosX(), marco.getPosY() + 20);
				app.text(posy, marco.getPosX(), marco.getPosY() + 30);
			}
		}
		
		if(app.second() % 2 != 0) {
			try {
				for(int i = 0; i < polos.size(); i++) {
					
					int posx = (int) polos.get(i).getPosX();
					int posy = (int) polos.get(i).getPosY();
					
					app.fill(0);
					app.textAlign(app.CENTER);
					app.text("Polo", polos.get(i).getPosX(), polos.get(i).getPosY() - 15);
					app.text(posx, polos.get(i).getPosX(), polos.get(i).getPosY() + 20);
					app.text(posy, polos.get(i).getPosX(), polos.get(i).getPosY() + 30);
				}
			}
			catch(IndexOutOfBoundsException e) {
				e.getLocalizedMessage();
			}
		}
		
	}
}
