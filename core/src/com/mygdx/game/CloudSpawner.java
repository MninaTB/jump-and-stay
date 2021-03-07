package com.mygdx.game;

import java.util.Random;

public class CloudSpawner {
	private float cloudCount;
	private float seconds;
	private float minInterval;
	private float maxInterval;
	private float maxClouds;
	private float x1;
	private float y1;
	private float minX2;
	private float minY2;
	private float maxX2;
	private float maxY2;
	String img;
	
	public CloudSpawner(float x1, float y1, float minX2, float maxX2, float minY2, float maxY2, String img, float minInterval, float maxInterval, float maxClouds) {
		seconds = 0;
		this.minInterval = minInterval;
		this.maxInterval = maxInterval;
		this.maxClouds = maxClouds;
		this.x1 = x1;
		this.y1 = y1;
		this.minX2 = minX2;
		this.minY2 = minY2;
		this.maxX2 = maxX2;
		this.maxY2 = maxY2;
		this.img = img;
	}

	private float getRandomNumberInRange(float min, float max) {
		Random r = new Random();
		float random = min + r.nextFloat() * (max - min);
		return random;
    }
	
	public Cloud next(float delta) {
		float randomX2 = getRandomNumberInRange(minX2, maxX2);
		float randomY2 = getRandomNumberInRange(minY2, maxY2);
		float randomInterval = getRandomNumberInRange(minInterval, maxInterval);
		if(cloudCount >= maxClouds) {
			return null;
		}
		seconds += delta;
		if(seconds > randomInterval) {
			seconds = 0;
			System.out.println("Neue Wolke");
			cloudCount += 1;
			return new Cloud(new Hitbox(x1, y1, randomX2, randomY2), img);
		}
		return null;
	}
}
