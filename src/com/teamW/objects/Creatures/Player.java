package com.teamW.objects.Creatures;

import java.awt.Graphics;
import java.awt.Color;

import com.teamW.Config;
import com.teamW.Game;
import com.teamW.graphics.Assets;

public class Player extends Creature {
    private Game game;

    public Player(Game game, int x, int y) {
        super(x, y, Config.DEFAULT_OBJECT_WIDTH, Config.DEFAULT_OBJECT_HEIGHT);
        this.game = game;
    }

    public void tick() {
        getInput();
        move();
    }

    public void getInput() {
        xMove = 0;
        yMove = 0;

        if(game.getKeyInput().up) {
            yMove = -speed;
        }
        if(game.getKeyInput().down) {
            yMove = speed;
        }
        if(game.getKeyInput().left) {
            xMove = -speed;
        }
        if(game.getKeyInput().right) {
            xMove = speed;
        }
    }

    public void render(Graphics g) {
        g.drawImage(Assets.getPlayer(0), (int) x, (int) y, width, height, null);
    }
}