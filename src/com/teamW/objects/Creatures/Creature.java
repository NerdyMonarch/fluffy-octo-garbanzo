package com.teamW.objects.Creatures;

import com.teamW.objects.GameObject;

public abstract class Creature extends GameObject {

    protected int health;

    public Creature(int x, int y) {
        super(x, y);
        this.health = 10;
    }
}