package Runtime;

import java.awt.*;
import javax.swing.*;

/**
 * Names GUI Runtime Class.
 *
 * @author Charlie Li
 * @author Justin Hanna
 * @author Nadif Rahman
 * @author Mo Lin Li
 */
public class NamesGUI extends JFrame {

    // Declare object variables
    String firstName, secondName;

    /**
     * Constructor for NamesGUI.
     */
    public NamesGUI() {

        // Import icons for popups
        ImageIcon whiteKing = new ImageIcon(getClass().getResource("/Images/white king.png"));
        ImageIcon blackKing = new ImageIcon(getClass().getResource("/Images/black king.png"));

        // Create Popup JFrame Parent
        JFrame inputBox = new JFrame();

        this.firstName = "";
        this.secondName = "";

        while (this.firstName.equals(this.secondName) || this.firstName.isEmpty() || this.secondName.isEmpty()) {
            // Ask users for white's name
            this.firstName = askQuestion(inputBox, "What is Player One's Name?", whiteKing);
            // Ask for the white's name again until it is not an empty string
            while (this.firstName.isEmpty()) {
                this.firstName = askQuestion(inputBox, "Your entry cannot be empty. What is Player One's Name?",
                        whiteKing);
            }

            // Ask users for black's name
            this.secondName = askQuestion(inputBox, "What is Player Two's Name?", blackKing);
            // Ask for the black's name again until it is not an empty string
            while (this.secondName.isEmpty()) {
                this.secondName = askQuestion(inputBox, "Your entry cannot be empty. What is Player Two's Name?",
                        whiteKing);
            }

            // Ask for both players' names again until they do not match
            while (this.firstName.equals(this.secondName)) {
                this.secondName = askQuestion(inputBox,
                        "Please enter a different name than player one. What is Player Two's Name?", blackKing);
            }
        }

        // Create a GameGUI while piping in player names
        new GameGUI(firstName, secondName);
    }

    /**
     * Method to create a popup and ask the user a question.
     *
     * @param parent Parent object (Usually a JFrame)
     * @param question Question to ask
     * @param icon Icon to create beside question
     * @return String containing user input
     */
    public String askQuestion(Container parent, String question, ImageIcon icon) {
        GridBagConstraints c = new GridBagConstraints();

        JTextField input = new JTextField();
        input.setPreferredSize(new Dimension(160, 20));

        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 2;
        JPanel panel = new JPanel(new GridBagLayout());

        c.gridx = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.SOUTHWEST;
        panel.add(new JLabel(question), c);

        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.NORTHWEST;

        panel.add(new JPanel().add(input), c);
        JOptionPane.showMessageDialog(parent, panel, question, JOptionPane.PLAIN_MESSAGE, icon);

        return input.getText();
    }

    /**
     * Program Creation Method.
     *
     * @param args Command Line Arguments
     */
    public static void main(String[] args) {
        new NamesGUI();
    }
}
