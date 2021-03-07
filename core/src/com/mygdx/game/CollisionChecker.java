package com.mygdx.game;

public class CollisionChecker {
	Player suspect;
	
	CollisionChecker(Player suspect) {
		this.suspect = suspect;
	}
	
	public boolean collision(GameObject item) {
		if (!(item instanceof com.mygdx.game.Enemy)) {
			return false;
		}
		if (suspect.getHitbox().overlaps(item.getHitbox())) {
			System.out.println("pew");
			return true;
		} 
		return false;
	}
}
