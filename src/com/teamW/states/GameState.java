package com.teamW.states;

import java.awt.Graphics;
import java.io.FileNotFoundException;

import com.teamW.Handler;
import com.teamW.objects.EntityHandler;
import com.teamW.objects.Creatures.Bat;
import com.teamW.objects.Creatures.Player;
import com.teamW.worldGen.Room;

public class GameState extends State {

    private Player player;
    private Room room;
    private EntityHandler handler;
    
    public GameState() throws FileNotFoundException {
        super();
        room = new Room("res/worldLib/top.txt");
        Handler.setRoom(room);
        player = new Player(300, 300);
        handler = new EntityHandler(player);
        handler.addObject(new Bat(64, 64));
    }

    @Override
    public void tick() {
        room.tick();
        handler.tick();
    }

    @Override
    public void render(Graphics g) {
        room.render(g);
        handler.render(g);
    }  

    public EntityHandler getHandler() {
        return handler;
    }
}