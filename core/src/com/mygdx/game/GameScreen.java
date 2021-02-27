package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter {
	private EnemySpawner spawner;
	private ArrayList<GameObject> objects;
	
	public GameScreen() {
		objects = new ArrayList<GameObject>();
		ScoreBoard board = new ScoreBoard(50.0f, Gdx.graphics.getHeight() - 50.0f);
		float screenWidth = Gdx.graphics.getWidth(); 
		spawner = new EnemySpawner(screenWidth, 50.0f, screenWidth + 50.0f, 100.0f, "sheep.png", 10.0f);
		Player player1 = new Player(100.0f, 50.0f, 175.0f, 100.0f, "dog.png");
		Ground ground = new Ground(0.0f, 0.0f, screenWidth, 50.0f, "boden.png");
		objects.add(player1);
		objects.add(ground);
		objects.add(board);
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
		Enemy newEnemy = spawner.next(delta);
		if(newEnemy != null) {
			objects.add(newEnemy);
		}
		Gdx.gl.glClearColor(0, 139, 139, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// MyGdxGame.INSTANCE.setScreen(new MainManueScreen()); // so Screen wechseln
		for (GameObject obj : objects) {
			obj.render(delta);
		}
	}
}
