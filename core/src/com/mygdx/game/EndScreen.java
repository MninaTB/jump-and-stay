package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EndScreen extends ScreenAdapter implements InputProcessor {
	private ArrayList<GameObject> objects;
	private BitmapFont font;
	private SpriteBatch display;
	private int score;
	
	public EndScreen(int score) {
		this.score = score;
		display = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(0.5f, 0.4f, 0, 1);
		objects = new ArrayList<GameObject>();
		Ground ground = new Ground(new Hitbox(0.0f, 0.0f, Gdx.graphics.getWidth(), 50.0f), "boden.png");
		DecoBlock gravestone = new DecoBlock(new Hitbox(100.0f, 50.0f, 225.0f, 150.0f), "gravestone.png");
		objects.add(ground);
		objects.add(gravestone);
		Gdx.input.setInputProcessor(this);
	}
	
	@Override
	public void dispose() {
		for (GameObject obj : objects) {
			obj.dispose();
		}
	}
	
	@Override
	public void hide() {}
	
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		for (GameObject obj : objects) {
			obj.render(delta);
		}
		display.begin();
		font.draw(display, "Score: " + Integer.toString(this.score), 
				Gdx.graphics.getWidth() / 2 - 100.0f, Gdx.graphics.getHeight() / 2);
		display.end();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.ESCAPE) {
			Gdx.app.exit();
		}
		MyGdxGame.INSTANCE.setScreen(new GameScreen());
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		// TODO Auto-generated method stub
		return false;
	}
}
