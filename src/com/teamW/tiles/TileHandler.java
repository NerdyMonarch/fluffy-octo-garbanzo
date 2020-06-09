package com.teamW.tiles;

public class TileHandler {

    // Tiles Called
    public static Tile floorTile = new Floor(0);
    public static Tile wallTopTile = new WallTop(1);
    public static Tile wallSideTile = new WallSide(2);
    public static Tile wallCornerTile = new WallCorner(3);
    public static Tile wallBottomTile = new WallBottom(4);
    public static Tile defaultTile = new Default(5);

    // Tiles Put into an Array
    public static Tile[] tiles = {
        floorTile,
        wallTopTile,
        wallSideTile,
        wallCornerTile,
        wallBottomTile,
        defaultTile
    };

    // Getter for All Tiles
    public static Tile getTile(int num) {
        int i = num / 10;
        int j = num % 10;
        if(i < tiles.length - 1) { 
            tiles[i].setIndex(j);
            return tiles[i];
        }
        return defaultTile;
    }
}