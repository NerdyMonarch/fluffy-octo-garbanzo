package com.teamW.objects.Creatures;

import java.awt.Graphics;

import com.teamW.Game;
import com.teamW.graphics.Assets;

public class Player extends Creature {
    private Game game;
    public Player(Game game, int x, int y) {
        super(x, y);
        this.game = game;
    }

    public void tick() {
        move();
    }

    public void move() {
        if(game.getKeyInput().up) {
            y -= speed;
        }
        if(game.getKeyInput().down) {
            y += speed;
        }
        if(game.getKeyInput().left) {
            x -= speed;
        }
        if(game.getKeyInput().right) {
            x += speed;
        }
    }

    public void render(Graphics g) {
        g.drawImage(Assets.getPlayer(0), (int) x, (int) y, null);
    }
}