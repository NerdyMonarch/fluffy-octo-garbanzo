package com.teamW.objects;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics;

import com.teamW.Config;
import com.teamW.objects.Creatures.Bat;
import com.teamW.objects.Creatures.Creature;
import com.teamW.objects.Creatures.Player;

public class EntityHandler {
    private Player player;
    private ArrayList<Creature> objects;
    private Random rand;

    public EntityHandler(Player player) {
        this.player = player;
        objects = new ArrayList<Creature>();
        rand = new Random();
    }

    public void tick() {
        int num = rand.nextInt(Math.max(50, 200 - 2 * Bat.batsKilled));
        if(num == 0) {
            objects.add(new Bat(rand.nextInt(Config.WIDTH - 64 - 300) + 32, rand.nextInt(Config.HEIGHT - 96 - 64) + 32));
        }

        for(int i = 0; i < objects.size(); i++) {
            Creature obj = objects.get(i);
            obj.tick();
            if(!obj.isAlive()) {
                removeObject(obj);
            }
        }
        player.tick();
    }

    public void render(Graphics g) {
        for(int i = 0; i < objects.size(); i++) {
            objects.get(i).render(g);
        }
        player.render(g);
    }

    public void addObject(Creature obj) {
        objects.add(obj);
    }

    public void removeObject(Creature obj) {
        objects.remove(obj);
    }

    public ArrayList<Creature> getObjects() {
        return objects;
    }

    public Player getPlayer() {
        return player;
    }

    public void cleanBoard() {
        this.player = new Player(300, 300);
        objects = new ArrayList<Creature>();
    }
}