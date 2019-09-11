package com.zerobit.doggy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.zerobit.doggy.Animation;

public class Block {

    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;
    private Texture texture;
    private Animation dogAnimation;
    int jump = 0;

    public boolean colliding;


    public Block(float x, float y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        texture = new Texture("spr_Doggy.png");
        dogAnimation = new Animation(new TextureRegion(texture), 2, 0.25f);
        bounds = new Rectangle(x, y, texture.getWidth()/2, texture.getHeight());
        colliding = false;
    }

    public void update(float dt){
        dogAnimation.update(dt);
        if(!colliding)
            position.add(0, velocity.y, 0);
        if(position.y < ((Gdx.graphics.getHeight()/2))-480) {
            position.y = ((Gdx.graphics.getHeight() / 2) - 480);
            jump = 1;
        }
        velocity.scl(1 / dt);
        updateBounds();
        if(jump == 0) {
            dogAnimation.air(dt);
        }
    }

    public void jump(){
        velocity.y = 10550;
    }

    public void updateBounds(){
        bounds.setPosition(position.x, position.y);
    }

    public float getX(){
        return position.x;
    }

    public float getY(){
        return position.y;
    }

    public float getWidth(){
        return texture.getWidth();
    }

    public float getHeight(){
        return texture.getHeight();
    }

    public TextureRegion getTexture(){
        return dogAnimation.getFrame();
    }

    public Rectangle getBounds(){
        return bounds;
    }
}
