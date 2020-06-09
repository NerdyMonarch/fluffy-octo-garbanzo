package com.teamW.states;

import java.awt.Graphics;

import com.teamW.Handler;
import com.teamW.objects.Creatures.Player;
import com.teamW.tiles.TileHandler;
import com.teamW.worldGen.Room;

public class GameState extends State {

    private Player player;
    private Room room;
    
    public GameState(Handler handler) {
        super(handler);
        room = new Room(handler,"/worldLib/top.txt");
        handler.setRoom(room);
        player = new Player(handler, 0, 0);
        
    }

    @Override
    public void tick() {
        room.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        room.render(g);
        player.render(g);
    }
    
}