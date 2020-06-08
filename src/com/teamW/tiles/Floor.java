package com.teamW.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.teamW.Config;
import com.teamW.graphics.Assets;

public class Floor extends Tile {

    private BufferedImage[] floors;
    private int floorLength;
    
    public Floor(int id) {
        super(id);
        this.floors = Assets.getFloorArray();
        this.floorLength = floors.length;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(floors[index], x, y, Config.TILE_WIDTH * Config.TILE_SCALE, Config.TILE_HEIGHT * Config.TILE_SCALE, null);
    }

    public void setIndex(int num) {
        if(num > floorLength) {
            index = 0;
        }
        else {
            index = num;
        }
    } 
}