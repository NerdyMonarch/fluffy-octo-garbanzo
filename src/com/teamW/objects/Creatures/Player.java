package com.teamW.objects.Creatures;

import java.awt.Graphics;

import com.teamW.Config;
import com.teamW.Handler;
import com.teamW.graphics.Assets;
import java.awt.Color;

public class Player extends Creature {
    private Handler handler;

    public Player(Handler handler, int x, int y) {
        super(handler, x, y, Config.DEFAULT_OBJECT_WIDTH, Config.DEFAULT_OBJECT_HEIGHT);
        this.handler = handler;
    }

    public void tick() {
        getInput();
        move();
    }

    public void getInput() {
        xMove = 0;
        yMove = 0;

        if(handler.getKeyInput().up) {
            yMove = -speed;
        }
        if(handler.getKeyInput().down) {
            yMove = speed;
        }
        if(handler.getKeyInput().left) {
            xMove = -speed;
        }
        if(handler.getKeyInput().right) {
            xMove = speed;
        }
    }

    public void render(Graphics g) {
        g.drawImage(Assets.getPlayer(0), (int) x, (int) y, width, height, null);

        g.setColor(Color.red);
        g.fillRect((int) (x + bounds.getX()),
                    (int) (y + bounds.getY()),
                    (int) bounds.getWidth(),
                    (int) bounds.getHeight());
    }
}