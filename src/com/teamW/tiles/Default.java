package com.teamW.tiles;

import java.awt.Graphics;

import com.teamW.Config;

public class Default extends Tile {

    public Default(int id) {
        super(id);
    }
    
    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.fillRect(x, y, Config.TILE_WIDTH * Config.TILE_SCALE, Config.TILE_HEIGHT * Config.TILE_SCALE);
    }

    public void setIndex(int num) {
        this.index = num;
    }
    
}