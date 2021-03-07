package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class Cloud extends GameBlock {
	public Cloud(Hitbox hitbox, String img) {
		super(hitbox, img);
	}
	
	@Override
	public void calculate(float delta) {
		hitbox.setX1(hitbox.getX1() - 1);
		hitbox.setX2(hitbox.getX2() - 1);
		if(hitbox.getX2() == 0.0f) {
			float objWidth = hitbox.getX2() - hitbox.getX1();
			hitbox.setX1(Gdx.graphics.getWidth());
			hitbox.setX2(hitbox.getX1() + objWidth);
		}
	}
}
