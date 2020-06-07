package com.teamW.objects.Creatures;

import com.teamW.Config;
import com.teamW.objects.GameObject;

public abstract class Creature extends GameObject {

    protected int health;
    protected double speed;

    public Creature(int x, int y) {
        super(x, y);
        this.health = Config.DEFAULT_HEALTH;
        this.speed = Config.DEFAULT_SPEED;
    }

    public int getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }
}