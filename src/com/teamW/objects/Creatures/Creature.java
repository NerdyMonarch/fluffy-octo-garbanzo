package com.teamW.objects.Creatures;

import com.teamW.Config;
import com.teamW.objects.GameObject;

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
        x += xMove;
        y += yMove;
    }
}