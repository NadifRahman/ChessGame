package Runtime;

import java.awt.*; //imports an API to develop the GUI
import javax.swing.*; //imports the swing components
import javax.swing.ImageIcon;//imports tools needed for the image icons

/**
 * Game GUI Runtime Class.
 * 
 * @author Charlie Li
 * @author Justin Hanna
 * @author Nadif Rahman
 * @author Mo Lin Li
 */
public class GameGUI extends JFrame {

    // Player names to pass on to Leaderboards
    public String whiteName, blackName;

    // ImageIcon variables to store the tile images
    ImageIcon whiteImg = new ImageIcon(getClass().getResource("/Images/white.png"));
    ImageIcon blackImg = new ImageIcon(getClass().getResource("/Images/black.png"));

    // JPanel to hold all Graphics Elements
    JPanel board = new JPanel();

    // Initialize Array for the buttons
    JButton[][] boxes = new JButton[8][8];

    /**
     * Constructor for this GUI class
     * 
     * @param whiteName Name of white player from Names Class
     * @param blackName Name of black player from Names Class
     */
    public GameGUI(final String whiteName, final String blackName) {

        // Set name of JPanel
        super("Chess");

        // Set the size of the frame
        setSize(800, 800);

        // Set proper close function
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize Events class and pipe player names
        GameEvents events = new GameEvents(this, whiteName, blackName);

        // Create a Grid Layout of 8 x 8 with no padding
        GridLayout layout = new GridLayout(8, 8, 0, 0);

        // Apply Layout to JFrame
        board.setLayout(layout);

        // Initialize variable to create event call system
        int eventCall = 0;

        // Loop through all the objects
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                // Increment eventCall value
                eventCall++;

                // Create a new button and set it's call to the eventCall value
                boxes[x][y] = new JButton();
                boxes[x][y].setActionCommand(Integer.toString(eventCall)); // tile as the

                // Add button to JFrame
                board.add(boxes[x][y]);
            }
        }

        // Add JFrame to GUI Object
        add(board);

        // Add a listener to all the buttons that will ping in Events class
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                boxes[x][y].addActionListener(events);
            }
        }

        // Make GUI visible
        setVisible(true);

        // Create Name Variables to pass onto Leaderboard Class
        this.whiteName = whiteName;
        this.blackName = blackName;

        // Update Images to start the game
        events.updateImages(1);
    }

}
