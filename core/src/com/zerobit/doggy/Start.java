package com.zerobit.doggy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.zerobit.doggy.Animation;

public class Start {


    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;
    private Texture texture;
    private Animation startAnimation;

    public boolean colliding;


    public Start(float x, float y){
        position = new Vector3(x, y, 0);
        texture = new Texture("spr_Start.png");
        startAnimation = new Animation(new TextureRegion(texture), 6, 0.5f);
        bounds = new Rectangle(x, y, texture.getWidth()/6, texture.getHeight());
    }

    public void update(float dt){
        startAnimation.update(dt);
        updateBounds();

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
        return startAnimation.getFrame();
    }

    public Rectangle getBounds(){
        return bounds;
    }
}
