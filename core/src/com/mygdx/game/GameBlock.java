package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameBlock implements GameObject{
	private SpriteBatch batch;
	private Texture img;
	protected Hitbox hitbox;
	
	public abstract void calculate(float delta); 
	
	public GameBlock(Hitbox hitbox, String img) {
		this.hitbox = hitbox;
		this.batch = new SpriteBatch();
		this.img = new Texture(img);
	}
	
	public void render(float delta) {
		calculate(delta);
		batch.begin();
		batch.draw(img, hitbox.getX1(), hitbox.getY1(), 
				hitbox.getX2() - hitbox.getX1(), hitbox.getY2() - hitbox.getY1());
		batch.end();
	}
	
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
	
	public Hitbox getHitbox() {
		return this.hitbox;
	}
}
