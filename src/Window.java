import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {
    
    // FIELDS

    // Required when extending to Canvas, This Serializes the Class
    private static final long serialVersionUID = -8255319694373975038L;

    private JFrame frame;

    // CONSTRUCTOR

    public Window(int width, int height, String title, Game game) {
        // Window Screen
        this.frame = new JFrame(title);

        // Setting Dimensions of Window Screen
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));

        // Stops Game Operation after Game is Closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Doesn't Allow Us to Resize our Window
        frame.setResizable(false);

        // Starts at the Middle of the Screen instead of Top Left
        frame.setLocationRelativeTo(null);

        // Adds Game Class into the Frame
        frame.add(game);

        // Starts Showing the Frame
        frame.setVisible(true);

        // Runs Start Method for Game
        game.start();
    }
}