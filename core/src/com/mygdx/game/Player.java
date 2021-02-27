package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player implements GameObject {
	private SpriteBatch batch;
	private Texture img;
	private float x;
	private float y;
	
	public Player(float x, float y) {
		this.x = x;
		this.y = y;
		batch = new SpriteBatch();
		img = new Texture("Dogs.png");
	}
	
	public void render(float delta) {
		batch.begin();
		batch.draw(img, x, y, 50.0f, 50.0f);
		batch.end();
	}
	
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
