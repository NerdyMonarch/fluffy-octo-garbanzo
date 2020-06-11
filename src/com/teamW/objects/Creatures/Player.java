package com.teamW.objects.Creatures;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.teamW.Config;
import com.teamW.Handler;
import com.teamW.graphics.Animation;
import com.teamW.graphics.Assets;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private Animation idleAnimation;
    private Animation walkAnimation;
    
    public Player(int x, int y) {
        super(x, y, Config.DEFAULT_OBJECT_WIDTH, Config.DEFAULT_OBJECT_HEIGHT);
        this.bounds = new Rectangle(0, 0, height * Config.TILE_SCALE, width * Config.TILE_SCALE);
        idleAnimation = new Animation(250, Assets.getPlayerAnimation(0));
        walkAnimation = new Animation(150, Assets.getPlayerAnimation(1));
    }

    public void tick() {
        animTick();
        getInput();
        move();
    }

    public void getInput() {
        xMove = 0;
        yMove = 0;

        if(Handler.getKeyInput().up) {
            yMove = -speed;
        }
        if(Handler.getKeyInput().down) {
            yMove = speed;
        }
        if(Handler.getKeyInput().left) {
            xMove = -speed;
        }
        if(Handler.getKeyInput().right) {
            xMove = speed;
        }
    }

    public BufferedImage getFrame() {
        if(Math.abs(xMove) > 0 || Math.abs(yMove) > 0) {
            return walkAnimation.getCurrentFrame();
        }
        return idleAnimation.getCurrentFrame();
    }

    public void animTick() {
        idleAnimation.tick();
        walkAnimation.tick();
    }

    public void render(Graphics g) {
        g.drawImage(getFrame(), (int) x, (int) y, width * Config.TILE_SCALE, height * Config.TILE_SCALE, null);
    }
}