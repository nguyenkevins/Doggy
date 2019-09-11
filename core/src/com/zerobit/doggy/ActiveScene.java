package com.zerobit.doggy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.zerobit.doggy.Dog;

public class ActiveScene extends Scene{

    Dog dog;
    private Texture background;
    //Block block1;
    int u = 0;

    public ActiveScene(SceneManager sm) {
        super(sm);
        dog = new Dog(((Gdx.graphics.getWidth()/2)-120), ((Gdx.graphics.getHeight()/2))-480);
        background = new Texture("spr_Background.png");
        //block1 = new Block(1000);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched() && (dog.jump == 1 || dog.jump == -1)){
            dog.jump();
            dog.jump = 0;
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        dog.update(dt);
        //cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        //sb.setProjectionMatrix(cam.combined);
        final float yPos = dog.getY();
        sb.begin();
        //sb.draw(background, 0, ((Gdx.graphics.getHeight()/2))-1440);
        sb.draw(background, 0, ((Gdx.graphics.getHeight()/2))-1440, 5520, 2880, u, 0, 5520, 2880, false, false);
        sb.draw(dog.getTexture(), dog.getX(), dog.getY());
        //sb.draw(block1.getBlock(), block1.getPositionBlock().x+u, block1.getPositionBlock().y);
        System.out.println(dog.jump);
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
        }
    }
}
