import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {

    // Holds Window Object
    private JFrame frame;

    // Dimensions
    private Dimension dimension;
    private int width;
    private int height;

    // Holds Drawing Object
    private Canvas canvas;

    public Window(String title, int width, int height) {

        // Window Screen
        this.frame = new JFrame(title);

        // Dimensions
        this.width = width;
        this.height = height;
        this.dimension = new Dimension(this.width, this.height);

        // Allows Us to Draw
        this.canvas = new Canvas();

        startDisplay();
    }

    private void startDisplay() {

        // Setting Dimensions of Window Screen
        frame.setPreferredSize(dimension);
        frame.setMinimumSize(dimension);
        frame.setMaximumSize(dimension);

        // Stops Game Operation after Game is Closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Starts Window in the Middle
        frame.setLocationRelativeTo(null);

        // Doesn't Allow Us to Resize our Window
        frame.setResizable(false);

        // Starts Showing the Frame
        frame.setVisible(true);

        // Adds Canvas into Frame
        addCanvas();
    }

    private void addCanvas() {

        // Setting Dimensions of Canvas
        canvas.setPreferredSize(dimension);
        canvas.setMinimumSize(dimension);
        canvas.setMaximumSize(dimension);

        // Lets the Frame have Focus over Graphics
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    // Accessor for Canvas
    public Canvas getCanvas() {
        return canvas;
    }

    // Accessor for JFrame
    public JFrame getFrame() {
        return frame;
    }
}