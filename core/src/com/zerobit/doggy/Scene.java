package com.zerobit.doggy;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class Scene {

    protected SceneManager sm;
    protected OrthographicCamera cam;
    protected Vector3 mouse;

    protected Scene(SceneManager sm){
        this.sm = sm;
        //cam = new OrthographicCamera();
        //cam.setToOrtho(false, 240, 400);
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
}
