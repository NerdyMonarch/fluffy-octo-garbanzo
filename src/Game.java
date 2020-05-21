import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

    // MAIN METHOD

    public static void main(String[] args) {
        // Runs Game Class
        new Game();
    }

    // FIELDS 

    // Required when extending to Canvas, This Serializes the Class
    private static final long serialVersionUID = -7803629994015778818L;

    // Holds Thread that Game is Running On
    private Thread thread;

    // Boolean to See if Game is Running
    private boolean running;

    // CONSTRUCTOR

    public Game() {
        // Runs the Windows Constructor
        new Window(Config.WIDTH, Config.HEIGHT, "Wessica + Wikhil", this);
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
    }

    private void tick() {

    }

    private void render() {

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