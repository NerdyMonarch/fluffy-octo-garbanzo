package com.teamW.tiles;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

import com.teamW.Config;
import com.teamW.graphics.Assets;

public class WallTop extends Tile {
    
    private BufferedImage[] wallTops;
    private int wallLength;

    public WallTop(int id) {
        super(id);
        this.wallTops = Assets.getWallTopArray();
        this.wallLength = wallTops.length;
        this.solid = true;
    }

    public void tick() {
        
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(wallTops[index], x, y, Config.TILE_WIDTH * Config.TILE_SCALE, Config.TILE_HEIGHT * Config.TILE_SCALE, null);
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