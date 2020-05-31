package com.teamW.tiles;
import java.awt.image.BufferedImage;

public abstract class Tile {
    protected BufferedImage[] images;
    protected TileType TileType;

    public Tile(BufferedImage[] images, TileType TileType) {
        this.images = images;
        this.TileType = TileType;

    }
}
