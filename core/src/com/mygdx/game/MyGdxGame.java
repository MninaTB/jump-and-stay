package com.mygdx.game;

import com.badlogic.gdx.Game;

public class MyGdxGame extends Game {
	
	public static MyGdxGame INSTANCE;
	
	public MyGdxGame() {
		if (INSTANCE != null) {
			return;
		}
		INSTANCE = this;
	}
	
	@Override
	public void create () {
		setScreen(new MenuScreen());
	}
}
