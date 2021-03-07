package com.mygdx.game;

import com.badlogic.gdx.math.Intersector;

public class Hitbox {
	float x1;
	float y1;
	float x2;
	float y2;

	Hitbox(float x1, float y1, float x2, float y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public float getX1() {
		return this.x1;
	}

	public float getY1() {
		return this.y1;
	}

	public float getX2() {
		return this.x2;
	}

	public float getY2() {
		return this.y2;
	}

	public void setX1(float x1) {
		this.x1 = x1;
	}

	public void setY1(float y1) {
		this.y1 = y1;
	}

	public void setX2(float x2) {
		this.x2 = x2;
	}

	public void setY2(float y2) {
		this.y2 = y2;
	}

	public Hitbox getCopy() {
		return new Hitbox(this.getX1(), this.getY1(), this.getX2(), this.getY2());
	}

	public boolean overlaps(Hitbox item) {
		if (item == null) {
			return false;
		}
		return this.getX1() < item.getX2() && this.getX2() > item.getX1() && this.getY1() < item.getY2()
				&& this.getY2() > item.getY1();
	}
}
