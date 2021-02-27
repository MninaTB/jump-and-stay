package com.mygdx.game;

import com.badlogic.gdx.Gdx;

public class Enemy extends GameBlock {
	public Enemy(float x1, float y1, float x2, float y2, String img) {
		super(x1, y1, x2, y2, img);
	}
	
	@Override
	public void calculate(float delta) {
		x1 = x1-1;
		x2 = x2-1;
		if(x2 == 0.0f) {
			float objWidth = x2 - x1;
			x1 = Gdx.graphics.getWidth();
			x2 = x1 + objWidth;
		}
	}
}
