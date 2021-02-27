package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;

public class GameInput implements InputProcessor {

	/*
	if(Gdx.input.isKeyPressed(Keys.A)) {
		position.x -= maxVelocity * delta;
	}
	if(Gdx.input.isKeyPressed(Keys.D)) {
		position.x += maxVelocity * delta;
	}
	if(Gdx.input.isKeyPressed(Keys.W)) {
		position.y += maxVelocity * delta;
	}
	if(Gdx.input.isKeyPressed(Keys.S)) {
		position.y -= maxVelocity * delta;
	}
	
	if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
		Gdx.app.exit();
	}*/
	
	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
		case Keys.SPACE:
			System.out.println("jump");
			break;
		case Keys.ESCAPE:
			Gdx.app.exit();
			break;
		}
		System.out.println("down");
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		System.out.println("up");
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
