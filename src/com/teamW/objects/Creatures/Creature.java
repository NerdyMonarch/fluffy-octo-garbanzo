package com.teamW.objects.Creatures;

import com.teamW.Config;
import com.teamW.Handler;
import com.teamW.objects.GameObject;
import com.teamW.tiles.TileHandler;

public abstract class Creature extends GameObject {

    protected int health;
    protected double speed;

    protected double xMove;
    protected double yMove;

    public Creature() {
        super(0, 0, Config.DEFAULT_OBJECT_WIDTH, Config.DEFAULT_OBJECT_HEIGHT);
        this.health = Config.DEFAULT_HEALTH;
        this.speed = Config.DEFAULT_SPEED;
    }
    public Creature(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.health = Config.DEFAULT_HEALTH;
        this.speed = Config.DEFAULT_SPEED;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getXMove() {
        return xMove;
    }

    public void setXMove(double xMove) {
        this.xMove = xMove;
    }

    public double getYMove() {
        return yMove;
    }

    public void setYMove(double yMove) {
        this.yMove = yMove;
    }

    public void move() {
        moveX();
        moveY();
    }

    public void moveX() {
        int tx = 0;

        // Gets Corner of Bound Box
        if(xMove > 0) {
            tx = (int) (x + xMove + bounds.getX() + bounds.getWidth()) / (Config.TILE_WIDTH * Config.TILE_SCALE);
        }
        else if(xMove < 0) {
            tx = (int) (x + xMove + bounds.getX()) / (Config.TILE_WIDTH * Config.TILE_SCALE);
        }

        // If Corners are Touching Bound Box, DO NOT MOVE
        if(!tileCollided(tx, (int) (y + bounds.getY()) / (Config.TILE_WIDTH * Config.TILE_SCALE)) &&
                !tileCollided(tx, (int) (y + bounds.getY() + bounds.getHeight()) / (Config.TILE_HEIGHT * Config.TILE_SCALE))) {
                    x += xMove;
        }
    }

    public void moveY() {
        int ty = 0;

        // Gets Corner of Bound Box
        if(yMove < 0) {
            ty = (int) (y + yMove + bounds.getY()) / (Config.TILE_HEIGHT * Config.TILE_SCALE);
        }
        else if(yMove > 0) {
            ty = (int) (y + yMove + bounds.getY() + bounds.getHeight()) / (Config.TILE_HEIGHT * Config.TILE_SCALE);
        }

        // If Corners are Touching Bound Box, DO NOT MOVE
        if(!tileCollided((int) (x + bounds.getX()) / (Config.TILE_WIDTH * Config.TILE_SCALE), ty) &&
                !tileCollided((int) (x + bounds.getX() + bounds.getWidth()) / (Config.TILE_WIDTH * Config.TILE_SCALE), ty)) {
                    y += yMove;
        }
    }

    public boolean tileCollided(int x, int y) {
        int tileData = Handler.getRoom().getTileData(x, y);
        return TileHandler.getTile(tileData).isSolid();
    }
}