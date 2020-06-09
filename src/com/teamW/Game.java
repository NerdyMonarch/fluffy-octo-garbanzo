package com.teamW;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

import com.teamW.inputs.KeyInput;
import com.teamW.states.GameState;
import com.teamW.states.State;
import com.teamW.graphics.Window;

public class Game implements Runnable {
    // Holds Title of Game
    private String title;
    // Holds The Game Window
    private Window window;
    // Dimensions of Window
    private int width;
    private int height;

    // Holds Thread that Game is Running On
    private Thread thread;
    // Boolean to See if Game is Running
    private boolean running;

    // Buffers for Rendering
    private BufferStrategy buffer;
    // Graphics Object for Rendering
    private Graphics graphics;

    // Inputs KeyPresses
    private KeyInput keyInput;

    // Handler for GameObjects
    private Handler handler;

    // Holds JFrame
    private JFrame frame;

    // States
    private State gameState;

    public Game(String title) {
        // Stores Parameters as Fields
        this.title = title;
        this.width = Config.WIDTH;
        this.height = Config.HEIGHT;
        
        // Game Hasn't Started Running Yet
        this.running = false;

        // Starts Window
        this.window = new Window(this.title, this.width, this.height);

        // Listens to Keyboard
        this.frame = window.getFrame();
        this.keyInput = new KeyInput();
        frame.addKeyListener(keyInput);

        // Creates a Handler Object
        handler = new Handler(this);

        gameState = new GameState(handler);
        State.setState(gameState);
    }

    // Starts Game
    public synchronized void start() {
        // Threads the Game
        thread = new Thread(this);

        // Starts the Thread
        thread.start();

        // Sets Running to True
        running = true;
        System.out.println("Running: " + running);
    }

    // Runs Game
    public void run() {
        // Obtains Time in NanoSeconds
        long lastTime = System.nanoTime();
        // Amount of Ticks per Second in Our Game
        double ticksPerSecond = 60.0;
        // Finds Nanoseconds Per Tick
        double nanoPerTick = 1000000000 / ticksPerSecond;
        // Holds Difference in Time
        double delta = 0;
        // Obtains Time in Milliseconds
        long timer = System.currentTimeMillis();
        // Counts Number of Frames
        int frames = 0;
        while(running) {
            // Current Time in NanoSeconds
            long now = System.nanoTime();
            // Difference in Time Converted into Ticks
            delta += (now - lastTime) / nanoPerTick;
            // Current Time Becomes Previous Time
            lastTime = now;
            // Runs Loop Based on Number of Ticks Passed
            while(delta >= 1) {
                // Runs this Method for Every Tick Passed
                tick();
                // Decrements a Tick because Method was Called
                delta--;
            }

            // Updates Window
            if(running) {
                render();
            }
            // Frame Increases Because Render was Completed
            frames++;
            
            // Checks if a Second Has Passed
            if(System.currentTimeMillis() - timer > 1000) {
                // Accounts for the Second that has Passed
                timer += 1000;
                // Prints out Frames Rendered in that Second
                System.out.println("FPS: " + frames);
                // Resets Frame to 0
                frames = 0;
            }
        }

        stop();
    }

    // Getter for Input
    public KeyInput getKeyInput() {
        return keyInput;
    }

    
    private void tick() {
        keyInput.tick();

        // Ticks State
        if(State.getState() != null) {
            State.getState().tick();
        }

        // Calls all Tick Methods using Handler
        handler.tick();
    }

    // Handles Rendering Graphics
    private void render() {
        Canvas canvas = window.getCanvas();
        buffer = canvas.getBufferStrategy();
        // Buffer Starts off as null
        if(buffer == null) {
            // Creates new Buffer
            canvas.createBufferStrategy(Config.NUMBER_OF_BUFFERS);
            return;
        }

        // Obtains Graphics from Buffer
        graphics = buffer.getDrawGraphics();

        // Clear Screen
        graphics.clearRect(0, 0, width, height);

        // Renders State
        if(State.getState() != null) {
            State.getState().render(graphics);
        }

        // Shows the Buffer That Holds the Render
        buffer.show();
        // Clears the Graphics
        graphics.dispose();
    }

    // Stops Game
    public synchronized void stop() {
        // Checks if the Thread is On or Not
        try {
            // Joins the Thread
            thread.join();
            // Sets Running to False
            running = false;
            System.out.println("Running: " + running);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}