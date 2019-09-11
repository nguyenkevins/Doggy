package com.zerobit.doggy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zerobit.doggy.Dog;

public class MenuScene extends Scene{

    Dog dog;
    private Texture background;
    private Texture title;
    Start start;

    public MenuScene(SceneManager sm) {
        super(sm);
        dog = new Dog(((Gdx.graphics.getWidth()/2)-120), ((Gdx.graphics.getHeight()/2))-480);
        background = new Texture("spr_Background.png");
        title = new Texture("spr_Title.png");
        start = new Start(((Gdx.graphics.getWidth()/2)-400), ((Gdx.graphics.getHeight()/2))-800);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            sm.set(new ActiveScene(sm));
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
        //dog.update(dt);
        //cam.update();
        start.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        //sb.setProjectionMatrix(cam.combined);
        final float yPos = dog.getY();
        sb.begin();
        //sb.draw(background, 0, ((Gdx.graphics.getHeight()/2))-1440);
        sb.draw(background, 0, ((Gdx.graphics.getHeight() / 2)) - 1440, 5520, 2880, 0, 0, 5520, 2880, false, false);
        sb.draw(dog.getTexture(), dog.getX(), dog.getY());
        sb.draw(start.getTexture(), start.getX(), start.getY());
        sb.draw(title, (Gdx.graphics.getWidth()/2)-(title.getWidth()/2), (Gdx.graphics.getHeight())-(title.getHeight())*2);
        //System.out.println(dog.jump);
        sb.end();
    }
}
