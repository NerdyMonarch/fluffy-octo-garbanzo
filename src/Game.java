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