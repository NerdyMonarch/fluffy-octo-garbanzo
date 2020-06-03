package com.teamW.objects.Creatures;

import java.awt.Graphics;

import com.teamW.Game;

public class Player extends Creature {
    private Game game;
    public Player(Game game, int x, int y) {
        super(x, y);
        this.game = game;
    }

    public void tick() {
        if(game.getKeyInput().up) {
            y += 3;
        }
        if(game.getKeyInput().down) {
            y -= 3;
        }
        if(game.getKeyInput().left) {
            x -= 3;
        }
        if(game.getKeyInput().right) {
            x += 3;
        }
    }

    public void render(Graphics g) {

    }
}