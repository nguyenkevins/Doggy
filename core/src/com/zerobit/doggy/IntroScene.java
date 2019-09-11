package com.zerobit.doggy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zerobit.doggy.Control;

public class IntroScene extends Scene{
    Texture intro;
    int u = 0;


    public IntroScene(SceneManager sm) {
        super(sm);
        intro = new Texture("spr_Intro.png");
    }

    @Override
    public void handleInput() {
        //if(Gdx.input.justTouched()){
           //sm.set(new ActiveScene(sm));
        //}
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(intro, (Gdx.graphics.getWidth()/2)-(intro.getWidth()/2), (Gdx.graphics.getHeight())-(intro.getHeight()*2));
        act();
        sb.end();
    }

    public void act() {
        if(u<=2760){
            u+=16;
        }else{
            u=0;
        }
        if(u>2760){
            u-=2760;
            sm.set(new MenuScene(sm));
        }
    }
}
