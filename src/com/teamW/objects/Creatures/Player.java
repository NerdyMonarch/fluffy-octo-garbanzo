package com.teamW.objects.Creatures;

import java.awt.Graphics;

import com.teamW.Config;
import com.teamW.Handler;
import com.teamW.graphics.Assets;
import java.awt.Color;

public class Player extends Creature {

    public Player(int x, int y) {
        super(x, y, Config.DEFAULT_OBJECT_WIDTH, Config.DEFAULT_OBJECT_HEIGHT);
    }

    public void tick() {
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

    public void render(Graphics g) {
        g.drawImage(Assets.getPlayer(0), (int) x, (int) y, width, height, null);

        g.setColor(Color.red);
        g.fillRect((int) (x + bounds.getX()),
                    (int) (y + bounds.getY()),
                    (int) bounds.getWidth(),
                    (int) bounds.getHeight());
    }
}