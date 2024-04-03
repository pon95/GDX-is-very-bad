package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends Game {
	SpriteBatch batch;
	Bird bird = new Bird(0, 0, 5);
	public OrthographicCamera camera;
	public static final int SCR_WIDTH = 2400;
	public static final int SCR_HEIGHT = 1080;
	ScreenGame screenGame;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
		screenGame = new ScreenGame();
		setScreen(screenGame);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		bird.update(batch);
		batch.end();
		if (Gdx.input.justTouched()) {
			bird.onClick();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		bird.dispose();
		camera.update();
		batch.setProjectionMatrix(camera.combined);
	}
}
