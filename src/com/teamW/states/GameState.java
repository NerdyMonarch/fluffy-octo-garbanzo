package com.teamW.states;

import java.awt.Graphics;
import java.io.FileNotFoundException;

import com.teamW.Handler;
import com.teamW.objects.EntityHandler;
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
        player = new Player(360, 360);
        handler = new EntityHandler(player);
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
}