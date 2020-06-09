package com.teamW.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.teamW.Config;
import com.teamW.graphics.Assets;

public class WallCorner extends Tile {
    
    private BufferedImage[] wallCorners;
    private int wallLength;

    public WallCorner(int id) {
        super(id);
        this.wallCorners = Assets.getWallCornerArray();
        this.wallLength = wallCorners.length;
        this.solid = true;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(wallCorners[index], x, y, Config.TILE_WIDTH * Config.TILE_SCALE, Config.TILE_HEIGHT * Config.TILE_SCALE, null);
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