package com.mygdx.game;

public class EnemySpawner{
	private float seconds;
	private float interval;
	private float x1;
	private float y1;
	private float x2;
	private float y2;
	String img;
	
	public EnemySpawner(float x1, float y1, float x2, float y2, String img, float interval) {
		seconds = 0;
		this.interval = interval;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.img = img;
	}
	
	public Enemy next(float delta) {
		seconds += delta;
		if(seconds > interval) {
			seconds = 0;
			System.out.println("Neuer Gegner");
			return new Enemy(x1, y1, x2, y2, img);
		}
		return null;
	}
}
