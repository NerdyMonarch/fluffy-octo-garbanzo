package com.teamW.graphics;

import java.awt.image.BufferedImage;

public class Animation {
    private int speed;
    private int index;

    private long lastTime;
    private long timer;

    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames) {
        this.speed = speed;
        this.frames = frames;
        this.index = 0;
        this.lastTime = System.currentTimeMillis();
    }

    public void tick() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed) {
            index = (index + 1) % frames.length;
            timer = 0;
        }
    }

    public BufferedImage getCurrentFrame() {
        return frames[index];
    }
}