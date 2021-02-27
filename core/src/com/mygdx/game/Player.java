package com.mygdx.game;

public class Player extends GameBlock {
	private float velocity;
	private float jumpHeight;
	private float groundHeight;
	
	public Player(float x1, float y1, float x2, float y2, String img) {
		super(x1, y1, x2, y2, img);
		velocity = 0;
		groundHeight = y1;
		jumpHeight = groundHeight + 70.0f;
	}

	public void jump() {
		System.out.println("jump");
		System.out.println(velocity);
		if(velocity == 0) {
			velocity = 100;
		}
	}

	@Override
	public void calculate(float delta) {
		if(this.y1 > jumpHeight) {
			velocity = -velocity;
		} else if(this.y1 < groundHeight) {
			velocity = 0;
			float diff = y2 - y1;
			this.y1 = groundHeight;
			this.y2 = groundHeight + diff;
		} 
		this.y1 += velocity * delta;
		this.y2 += velocity * delta;
	}
}
