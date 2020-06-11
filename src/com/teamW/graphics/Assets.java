package com.teamW.graphics;

import java.awt.image.BufferedImage;

public class Assets {
    private static BufferedImage[] floors = {
        ImageLoader.loadImage("/textures/tiles/floors/floor_0.png"),
        ImageLoader.loadImage("/textures/tiles/floors/floor_1.png"),
        ImageLoader.loadImage("/textures/tiles/floors/floor_2.png"),
        ImageLoader.loadImage("/textures/tiles/floors/floor_3.png"),
        ImageLoader.loadImage("/textures/tiles/floors/floor_4.png"),
        ImageLoader.loadImage("/textures/tiles/floors/floor_5.png"),
        ImageLoader.loadImage("/textures/tiles/floors/floor_6.png"),
        ImageLoader.loadImage("/textures/tiles/floors/floor_7.png")
    };
    
    private static BufferedImage[] wallCorners = {
        ImageLoader.loadImage("/textures/tiles/walls/wall_left_corner.png"),
        ImageLoader.loadImage("/textures/tiles/walls/wall_right_corner.png")
    };

    private static BufferedImage[] wallBottoms = {
        ImageLoader.loadImage("/textures/tiles/walls/wall_bottom_0.png"),
        ImageLoader.loadImage("/textures/tiles/walls/wall_bottom_1.png")
    };

    private static BufferedImage[] wallSides = {
        ImageLoader.loadImage("/textures/tiles/walls/wall_left_0.png"),
        ImageLoader.loadImage("/textures/tiles/walls/wall_left_1.png"),
        ImageLoader.loadImage("/textures/tiles/walls/wall_right_0.png"),
        ImageLoader.loadImage("/textures/tiles/walls/wall_right_1.png")
    };

    private static BufferedImage[] wallTops = {
        ImageLoader.loadImage("/textures/tiles/walls/wall_top_0.png"),
        ImageLoader.loadImage("/textures/tiles/walls/wall_top_1.png"),
        ImageLoader.loadImage("/textures/tiles/walls/wall_top_2.png")
    };

    private static BufferedImage[] players = {
        ImageLoader.loadImage("/textures/creatures/player0/player_0.png")
    };

    private static BufferedImage[][] playerAnimations = {
        {
            ImageLoader.loadImage("/textures/creatures/player0/idle/idle_0.png"),
            ImageLoader.loadImage("/textures/creatures/player0/idle/idle_1.png"),
            ImageLoader.loadImage("/textures/creatures/player0/idle/idle_2.png"),
            ImageLoader.loadImage("/textures/creatures/player0/idle/idle_3.png"),
            ImageLoader.loadImage("/textures/creatures/player0/idle/idle_4.png"),
            ImageLoader.loadImage("/textures/creatures/player0/idle/idle_5.png"),
        },
        {
            ImageLoader.loadImage("/textures/creatures/player0/walk/walk_0.png"),
            ImageLoader.loadImage("/textures/creatures/player0/walk/walk_1.png"),
            ImageLoader.loadImage("/textures/creatures/player0/walk/walk_2.png"),
            ImageLoader.loadImage("/textures/creatures/player0/walk/walk_3.png"),
            ImageLoader.loadImage("/textures/creatures/player0/walk/walk_4.png"),
            ImageLoader.loadImage("/textures/creatures/player0/walk/walk_5.png"),
            ImageLoader.loadImage("/textures/creatures/player0/walk/walk_6.png"),
            ImageLoader.loadImage("/textures/creatures/player0/walk/walk_7.png"),
            ImageLoader.loadImage("/textures/creatures/player0/walk/walk_8.png")
        }
    };

    public static BufferedImage[] getFloorArray() {
        return floors;
    }

    public static BufferedImage getFloor(int num) {
        return floors[num];
    }

    public static BufferedImage[] getWallCornerArray() {
        return wallCorners;
    }

    public static BufferedImage getWallCorner(int num) {
        return wallCorners[num];
    }

    public static BufferedImage[] getWallBottomArray() {
        return wallBottoms;
    }

    public static BufferedImage getWallBottom(int num) {
        return wallBottoms[num];
    }

    public static BufferedImage[] getWallSideArray() {
        return wallSides;
    }

    public static BufferedImage getWallSide(int num) {
        return wallSides[num];
    }

    public static BufferedImage[] getWallTopArray() {
        return wallTops;
    }

    public static BufferedImage getWallTop(int num) {
        return wallTops[num];
    }

    public static BufferedImage[] getPlayerArray() {
        return players;
    }

    public static BufferedImage getPlayer(int num) {
        return players[num];
    }

    public static BufferedImage[] getPlayerAnimation(int num) {
        return playerAnimations[num];
    }
}