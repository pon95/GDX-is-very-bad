package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Bird {
    Texture img = new Texture("player/bird0.png");
    int x, y, speed;
    int jumpHeight;
    final int maxHeightOfJump = 200;
    boolean jump;
    public Bird(int x, int y, int speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void fly() {
        if (y >= jumpHeight) {
            jump = false;
        }
        if (jump) {
            y += speed;
        } else {
            y -= speed;
        }
    }
    void onClick() {
        jump = true;
        jumpHeight = maxHeightOfJump + y;
    }

    public void update(Batch batch){
        batch.draw(this.img, this.x, this.y);
    }

    public void dispose(){
        this.img.dispose();
    }
}
