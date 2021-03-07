package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScoreBoard implements GameObject{
	private SpriteBatch display;
	private BitmapFont font;
	private float x;
	private float y;
	private float score;

	ScoreBoard(float x, float y) {
		display = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(0.5f, 0.4f, 0, 1);
		this.x = x;
		this.y = y;
		this.score = 0;
	}

	@Override
	public void render(float delta) {
		score += 1 * delta;
		display.begin();
		font.draw(display, Integer.toString((int)score), x, y);
		display.end();
	}

	@Override
	public void dispose() {
		font.dispose();
		display.dispose();
	}

	@Override
	public Hitbox getHitbox() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getScore() {
		return (int)score;
	}
}
