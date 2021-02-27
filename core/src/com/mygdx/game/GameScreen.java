package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter {
	ArrayList<GameObject> objects;
	
	public GameScreen() {
		objects = new ArrayList<GameObject>();
		Player player1 = new Player(100.0f, 50.0f, 150.0f, 100.0f, "Dogs.png");
		Enemy obstacle1 = new Enemy(150.0f, 50.0f, 200.0f, 100.0f, "Dogs.png");
		Enemy obstacle2 = new Enemy(200.0f, 50.0f, 250.0f, 100.0f, "Dogs.png");
		Ground ground = new Ground(0.0f, 0.0f, Gdx.graphics.getWidth(), 50.0f, "boden.png");
		objects.add(player1);
		objects.add(obstacle1);
		objects.add(obstacle2);
		objects.add(ground);
		Gdx.input.setInputProcessor(new GameInput(player1));
	}
	
	@Override
	public void dispose() {
		for (GameObject obj : objects) {
			obj.dispose();
		}
	}
	
	@Override
	public void hide() {
		this.dispose();
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// MyGdxGame.INSTANCE.setScreen(new MainManueScreen()); // so Screen wechseln
		for (GameObject obj : objects) {
			obj.render(delta);
		}
	}
}
