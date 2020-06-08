package com.teamW.tiles;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

import com.teamW.Config;
import com.teamW.graphics.Assets;

public class WallBottom extends Tile {
    
    private BufferedImage[] wallBottoms;
    private int wallLength;

    public WallBottom(int id) {
        super(id);
        this.wallBottoms = Assets.getWallBottomArray();
        this.wallLength = wallBottoms.length;
    }

    public void tick() {
        
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(wallBottoms[index], x, y, Config.TILE_WIDTH * Config.TILE_SCALE, Config.TILE_HEIGHT * Config.TILE_SCALE, null);
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