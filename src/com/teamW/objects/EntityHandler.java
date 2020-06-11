package com.teamW.objects;

import java.util.ArrayList;
import java.awt.Graphics;

import com.teamW.objects.Creatures.Player;

public class EntityHandler {
    private Player player;
    private ArrayList<GameObject> objects;

    public EntityHandler(Player player) {
        this.player = player;
        objects = new ArrayList<GameObject>();
    }

    public void tick() {
        for(int i = 0; i < objects.size(); i++) {
            objects.get(i).tick();
        }
        player.tick();
    }

    public void render(Graphics g) {
        for(int i = 0; i < objects.size(); i++) {
            objects.get(i).render(g);
        }
        player.render(g);
    }

    public void addObject(GameObject obj) {
        objects.add(obj);
    }

    public void removeObject(GameObject obj) {
        objects.remove(obj);
    }
}