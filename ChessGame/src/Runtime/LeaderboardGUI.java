package Runtime;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;
import java.util.*;
import Pieces.*;

/**
 * Leaderboards GUI Runtime Class.
 * 
 * @author Justin Hanna
 * @author Nadif Rahman
 */
public class LeaderboardGUI {

    // Declare objecct variables
    String firstName, secondName;
    int winner;

    /**
     * Constructor for this Leaderboards Class.
     * 
     * @param firstName  Name of first player
     * @param secondName Name of second player
     * @param winner     Win condiiton of the game (1 - first player, 2 - second
     *                   player, 3 - stalemate)
     */
    public LeaderboardGUI(final String firstName, final String secondName, final int winner) {

        // Assign object variables
        this.firstName = firstName;
        this.secondName = secondName;
        this.winner = winner;

        // Import icons for popups
        ImageIcon whiteKing = new ImageIcon(getClass().getResource("/Images/white king.png"));
        ImageIcon blackKing = new ImageIcon(getClass().getResource("/Images/black king.png"));

        // Open files for writing/reading
        File scores = new File(".\\scores.txt");
        File names = new File(".\\names.txt");

        // Create arrayLists to hold read/processed data in between serialization
        ArrayList<String> namesArray = new ArrayList<String>();
        ArrayList<Integer> scoresArray = new ArrayList<Integer>();
        ArrayList<Entry> entryArray = new ArrayList<Entry>();

        try {
            // Scan through names file and dump to arraylist
            Scanner nameScanner = new Scanner(names);
            while (nameScanner.hasNextLine()) {
                String a = nameScanner.nextLine();
                namesArray.add(a);
            }
            nameScanner.close();

            // Scan through scores file and dump to arraylist
            Scanner scoreScanner = new Scanner(scores);
            while (scoreScanner.hasNextLine()) {
                int a = Integer.parseInt(scoreScanner.nextLine());
                scoresArray.add(a);
            }
            scoreScanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Search for first and second name in saved entries
        int firstNameIndex = -1;
        int secondNameIndex = -1;

        for (int i = 0; i < namesArray.size(); i++) {
            if (namesArray.get(i).equals(firstName)) {
                firstNameIndex = i;
            }
        }
        for (int i = 0; i < namesArray.size(); i++) {
            if (namesArray.get(i).equals(secondName)) {
                secondNameIndex = i;
            }
        }

        // If Non Existent, create a new entry with first and/or second name(s)
        if (firstNameIndex == -1) {
            namesArray.add(firstName);
            scoresArray.add(0);
            firstNameIndex = namesArray.size() - 1;
        }
        if (secondNameIndex == -1) {
            namesArray.add(secondName);
            scoresArray.add(0);
            secondNameIndex = namesArray.size() - 1;
        }

        // Award the winnner a point in their score
        if (winner == 1) {
            int winnerScore = scoresArray.get(firstNameIndex);
            winnerScore++;
            scoresArray.set(firstNameIndex, winnerScore);
        }
        if (winner == 2) {
            int winnerScore = scoresArray.get(secondNameIndex);
            winnerScore++;
            scoresArray.set(secondNameIndex, winnerScore);
        }

        // Load entries arrayList with adjusted values
        for (int i = 0; i < namesArray.size(); i++) {
            entryArray.add(new Entry(namesArray.get(i), scoresArray.get(i)));
        }

        // Sort Entries by score
        entryArray.sort(new ScoreSorter());

        // Write arrays back to files by deconstructing Entries in order
        try {
            FileWriter nameWriter = new FileWriter(names);
            String nameList = "";
            for (Entry e : entryArray) {
                nameList += e.name + System.lineSeparator();
            }
            nameWriter.write(nameList);
            nameWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter scoreWriter = new FileWriter(scores);
            String scoreList = "";
            for (Entry e : entryArray) {
                scoreList += e.score + System.lineSeparator();
            }
            scoreWriter.write(scoreList);
            scoreWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Tell the user who won
        if (winner == 0) {
            JOptionPane.showMessageDialog(null, "No One Won", "Stalemate", JOptionPane.INFORMATION_MESSAGE);
        } else if (winner == 1) {
            JOptionPane.showMessageDialog(null, firstName + " Won", "Stalemate", JOptionPane.INFORMATION_MESSAGE,
                    whiteKing);
        } else if (winner == 2) {
            JOptionPane.showMessageDialog(null, secondName + " Won", "Stalemate", JOptionPane.INFORMATION_MESSAGE,
                    blackKing);
        }

        // List Leaderboard Data
        String message = "";

        for (Entry e : entryArray) {
            message += e.name + "\t" + e.score + "\n";
        }

        // Create new JFrame to display Leaderboards
        JFrame frame = new JFrame();
        BoxLayout layout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setTitle("Leaderboards");
        frame.setLayout(layout);
        frame.setSize(400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create title and add to JFrame
        JLabel title = new JLabel("Leaderboards");
        title.setBorder(new EmptyBorder(20, 20, 20, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.add(title);

        // Create text area
        JTextArea messageBox = new JTextArea(message);
        messageBox.setEditable(false);
        messageBox.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Place text area in scroll pane and add to JFrame
        JScrollPane scrollPane = new JScrollPane(messageBox);
        scrollPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        frame.add(scrollPane);

        // Make JFrame visible
        frame.setVisible(true);
    }
}
