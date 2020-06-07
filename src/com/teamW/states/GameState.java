package com.teamW.states;

import java.awt.Graphics;

import com.teamW.graphics.Assets;

public class GameState extends State {

    public GameState() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.getFloor(1), 0, 0, null);
    }
    
}