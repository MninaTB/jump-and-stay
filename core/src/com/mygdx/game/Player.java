package com.mygdx.game;

public class Player extends GameBlock {
	public Player(float x1, float y1, float x2, float y2, String img) {
		super(x1, y1, x2, y2, img);
	}

	public void jump() {
		this.y1 += 10;
		this.y2 += 10;
	}

	@Override
	public void calculate(float delta) {
	}
}
