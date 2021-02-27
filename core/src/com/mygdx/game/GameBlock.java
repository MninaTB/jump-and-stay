package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameBlock implements GameObject{
	private SpriteBatch batch;
	private Texture img;
	private float x1;
	private float x2;
	private float y1;
	private float y2;
	
	public GameBlock(float x1, float y1, float x2, float y2, String img) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.batch = new SpriteBatch();
		this.img = new Texture(img);
	}
	
	public void render(float delta) {
		x1 = x1-1;
		x2 = x2-1;
		if(x2 == 0.0f) {
			float objWidth = x2 - x1;
			x1 = Gdx.graphics.getWidth();
			x2 = x1 + objWidth;
			
		}
		batch.begin();
		batch.draw(img, x1, y1, x2 - x1, y2 - y1);
		batch.end();
	}
	
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
