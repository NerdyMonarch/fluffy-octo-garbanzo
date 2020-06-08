package com.teamW.tiles;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

import com.teamW.Config;
import com.teamW.graphics.Assets;

public class WallSide extends Tile {
    
    private BufferedImage[] wallSides;
    private int wallLength;

    public WallSide(int id) {
        super(id);
        this.wallSides = Assets.getWallSideArray();
        this.wallLength = wallSides.length;
    }

    public void tick() {
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(wallSides[index], x, y, Config.TILE_WIDTH * Config.TILE_SCALE, Config.TILE_HEIGHT * Config.TILE_SCALE, null);
    }

    public void setIndex(int num) {
        if(num > wallLength) {
            index = 0;
        }
        else {
            index = num;
        }
    } 
}