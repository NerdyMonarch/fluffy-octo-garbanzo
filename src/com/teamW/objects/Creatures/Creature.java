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
        // Gets Corner of Bound Box
        if(xMove > 0) {
            int tx = (int) (x + xMove + bounds.getX() + bounds.getWidth()) / (Config.TILE_WIDTH * Config.TILE_SCALE);

            // If Corners are Touching Bound Box, DO NOT MOVE
            if(!tileCollided(tx, (int) (y + bounds.getY()) / (Config.TILE_WIDTH * Config.TILE_SCALE)) &&
                !tileCollided(tx, (int) (y + bounds.getY() + bounds.getHeight()) / (Config.TILE_HEIGHT * Config.TILE_SCALE))) {
                    x += xMove;
            }
            else {
                x = tx * (Config.TILE_WIDTH * Config.TILE_SCALE) - bounds.getX() - bounds.getWidth() - 1;
            }
        }
        else if(xMove < 0) {
            int tx = (int) (x + xMove + bounds.getX()) / (Config.TILE_WIDTH * Config.TILE_SCALE);

            // If Corners are Touching Bound Box, DO NOT MOVE
            if(!tileCollided(tx, (int) (y + bounds.getY()) / (Config.TILE_WIDTH * Config.TILE_SCALE)) &&
                !tileCollided(tx, (int) (y + bounds.getY() + bounds.getHeight()) / (Config.TILE_HEIGHT * Config.TILE_SCALE))) {
                    x += xMove;
            }
            else {
                x = tx * (Config.TILE_WIDTH * Config.TILE_SCALE) + (Config.TILE_WIDTH * Config.TILE_SCALE) - bounds.getX();
            }
        }
    }

    public void moveY() {
        // Gets Corner of Bound Box
        if(yMove < 0) {
            int ty = (int) (y + yMove + bounds.getY()) / (Config.TILE_HEIGHT * Config.TILE_SCALE);

            // If Corners are Touching Bound Box, DO NOT MOVE
            if(!tileCollided((int) (x + bounds.getX()) / (Config.TILE_WIDTH * Config.TILE_SCALE), ty) &&
                !tileCollided((int) (x + bounds.getX() + bounds.getWidth()) / (Config.TILE_WIDTH * Config.TILE_SCALE), ty)) {
                    y += yMove;
            }
            else {
                y = ty * (Config.TILE_HEIGHT * Config.TILE_SCALE) + (Config.TILE_HEIGHT * Config.TILE_SCALE) - bounds.getY();
            }
        }
        else if(yMove > 0) {
            int ty = (int) (y + yMove + bounds.getY() + bounds.getHeight()) / (Config.TILE_HEIGHT * Config.TILE_SCALE);

            // If Corners are Touching Bound Box, DO NOT MOVE
            if(!tileCollided((int) (x + bounds.getX()) / (Config.TILE_WIDTH * Config.TILE_SCALE), ty) &&
                !tileCollided((int) (x + bounds.getX() + bounds.getWidth()) / (Config.TILE_WIDTH * Config.TILE_SCALE), ty)) {
                    y += yMove;
            }
            else {
                y = ty * (Config.TILE_HEIGHT * Config.TILE_SCALE) - bounds.getY() - bounds.getHeight() - 1;
            }
        }
    }

    public boolean tileCollided(int x, int y) {
        int tileData = Handler.getRoom().getTileData(x, y);
        return TileHandler.getTile(tileData).isSolid();
    }
}