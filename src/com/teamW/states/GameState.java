package com.teamW.states;

import java.awt.Graphics;
import java.io.FileNotFoundException;

import com.teamW.Game;
import com.teamW.objects.Creatures.Player;
import com.teamW.worldGen.Room;

public class GameState extends State {

    private Player player;
    private Room room;

    public GameState(Game game) throws FileNotFoundException {
        super(game);
        player = new Player(game, 0, 0);
        room = new Room("res\\worldLib\\top.txt");
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