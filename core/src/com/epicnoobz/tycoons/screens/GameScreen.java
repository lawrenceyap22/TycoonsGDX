package com.epicnoobz.tycoons.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.epicnoobz.tycoons.Tycoons;

public abstract class GameScreen implements Screen {

	public static final int VIEWPORT_WIDTH = 1080;
	public static final int VIEWPORT_HEIGHT = 1920;

	protected final Tycoons game;
	protected OrthographicCamera camera;
	protected Stage stage;

	public GameScreen(final Tycoons game) {
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);

		stage = new Stage(new StretchViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, camera), game.getBatch());
		Gdx.input.setInputProcessor(stage);

		stage.setDebugAll(Tycoons.DEV_MODE);

	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

		camera.update();

		stage.act(delta);
		stage.draw();
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		Gdx.app.log(Tycoons.TAG, "Disposing Game screens");
		if (stage != null)
			stage.dispose();
	}
}