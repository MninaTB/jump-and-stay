package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Gdx;

public class Player extends GameBlock {
	private float velocity;
	private float jumpHeight;
	private float groundHeight;
	private boolean alive;
	Sound jumpSound;
	
	
	public Player(Hitbox hitbox, String img) {
		super(hitbox, img);
		alive = true;
		velocity = 0;
		groundHeight = hitbox.getY1();
		jumpHeight = groundHeight + 70.0f;
	    this.jumpSound = Gdx.audio.newSound(Gdx.files.internal("jump.mp3"));
	}

	public void jump() {
		if(velocity == 0) {
			jumpSound.play();
			velocity = 100;
		}
	}

	@Override
	public void calculate(float delta) {
		if(this.hitbox.getY1() > jumpHeight) {
			velocity = -velocity;
		} else if(this.hitbox.getY1() < groundHeight) {
			velocity = 0;
			float diff = this.hitbox.getY2() - this.hitbox.getY1();
			this.hitbox.setY1(groundHeight);
			this.hitbox.setY2(groundHeight + diff);
		} 
		this.hitbox.setY1(this.hitbox.getY1() + velocity * delta);
		this.hitbox.setY2(this.hitbox.getY2() + velocity * delta);
	}
	
	public boolean collisionWithEnemy(GameObject item) {
		if (!(item instanceof com.mygdx.game.Enemy)) {
			return false;
		}
		if (this.getHitbox().overlaps(item.getHitbox())) {
			System.out.println("pew");
			if (this.velocity < 0) {
				return true;
			}
			alive = false;
		} 
		return false;
	}
	
	public boolean isAlive() {
		return alive;
	}
}
