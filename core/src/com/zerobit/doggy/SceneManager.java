package com.zerobit.doggy;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SceneManager {
    private Stack<Scene> scene;

    public SceneManager(){
        scene = new Stack<Scene>();
    }

    public void push(Scene state){
        scene.push(state);
    }

    public void pop(){
        scene.pop();
    }

    public void set(Scene state){
        scene.pop();
        scene.push(state);
    }

    public void update(float dt){
        Scene updateScene = (Scene)scene.peek();
        updateScene.update(dt);
    }

    public void render(SpriteBatch sb){
        Scene renderScene = (Scene)scene.peek();
        renderScene.render(sb);
        //System.out.println(renderScene.toString());
    }
}