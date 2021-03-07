package com.mygdx.game;

public class EnemySpawner{
	private float seconds;
	private float interval;
	private Hitbox hitbox;
	String img;
	
	public EnemySpawner(Hitbox hitbox, String img, float interval) {
		seconds = 0;
		this.interval = interval;
		this.hitbox = hitbox;
		this.img = img;
	}
	
	public Enemy next(float delta) {
		seconds += delta;
		if(seconds > interval) {
			seconds = 0;
			System.out.println("Neuer Gegner");
			return new Enemy(this.hitbox.getCopy(), img);
		}
		return null;
	}
}
