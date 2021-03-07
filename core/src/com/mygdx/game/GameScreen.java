package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.audio.Sound;

public class GameScreen extends ScreenAdapter {
	private EnemySpawner enemySpawner;
	private ScoreBoard board;
	private EnemySpawner enemySpawner1;
	private CloudSpawner cloudSpawner;
	private ArrayList<GameObject> objects;
	private Player player;
	private Sound music;
	private Sound die;

	public GameScreen() {
		objects = new ArrayList<GameObject>();
		board = new ScoreBoard(50.0f, Gdx.graphics.getHeight() - 50.0f);
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		enemySpawner = new EnemySpawner(new Hitbox(screenWidth, 50.0f, screenWidth + 50.0f, 100.0f), "sheep.png",
				10.0f);
		enemySpawner1 = new EnemySpawner(new Hitbox(screenWidth + 15.0f, 50.0f, screenWidth + 50.0f, 80.0f),
				"blackSheep.png", 3.0f);
		cloudSpawner = new CloudSpawner(screenWidth + 10.0f, screenHeight - 20.0f, screenWidth + 100.0f,
				screenWidth + 150, screenHeight - 70.0f, screenHeight - 120.0f, "cloud.png", 7.0f, 10.0f, 10.0f);
		player = new Player(new Hitbox(100.0f, 50.0f, 225.0f, 100.0f), "dog.png");
		Ground ground = new Ground(new Hitbox(0.0f, 0.0f, screenWidth, 50.0f), "boden.png");
		objects.add(player);
		objects.add(ground);
		this.music = Gdx.audio.newSound(Gdx.files.internal("background_music.mp3"));
		this.music.loop();
		this.die = Gdx.audio.newSound(Gdx.files.internal("sheep_dies.mp3"));

		Gdx.input.setInputProcessor(new GameInput(player));
	}

	@Override
	public void dispose() {
		for (GameObject obj : objects) {
			obj.dispose();
		}
		board.dispose();
	}

	@Override
	public void hide() {
		this.dispose();
	}

	@Override
	public void render(float delta) {
		Enemy newEnemy = enemySpawner.next(delta);
		if (newEnemy != null) {
			objects.add(newEnemy);
		}
		Enemy enemy = enemySpawner1.next(delta);
		if (enemy != null) {
			objects.add(enemy);
		}
		Gdx.gl.glClearColor(0, 139, 139, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ArrayList<GameObject> removed = new ArrayList<GameObject>();
		for (GameObject obj : objects) {
			if (player.collisionWithEnemy(obj)) {
				removed.add(obj);
			}
		}
		for (GameObject obj : removed) {
			obj.dispose();
			objects.remove(obj);
			this.die.play();
		}

		for (GameObject obj : objects) {
			obj.render(delta);
		}
		Cloud newCloud = cloudSpawner.next(delta);
		if (newCloud != null) {
			objects.add(newCloud);
		}

		board.render(delta);

		if (!player.isAlive()) {
			MyGdxGame.INSTANCE.setScreen(new EndScreen(board.getScore()));
			music.stop();
		}
	}
}
