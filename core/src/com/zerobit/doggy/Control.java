package com.zerobit.doggy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zerobit.doggy.SceneManager;
import com.zerobit.doggy.IntroScene;

public class Control extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final float SCALE = 0.5f;
	public static final String TITLE = "FlappyBird";

	private SpriteBatch spriteBatch;
	private SceneManager sm;

	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		sm = new SceneManager();
		sm.push(new IntroScene(sm));

		Gdx.gl.glClearColor(0, 0, 0, 1);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sm.update(Gdx.graphics.getDeltaTime());
		sm.render(spriteBatch);
	}

}
