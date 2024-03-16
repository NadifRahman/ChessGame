package Pieces;

import javax.swing.*;

/**
 * Gameboard to store piece data.
 * 
 * @author Charlie Li
 * @author Justin Hanna
 */
public class Gameboard {

    // Array of 8x8 board
    public Piece[][] board = new Piece[8][8];

    // ImageIcon variables to store the tile images
    ImageIcon whiteImg = new ImageIcon(getClass().getResource("/Images/white.png"));
    ImageIcon blackImg = new ImageIcon(getClass().getResource("/Images/black.png"));

    /**
     * Constructor for the Gameboard. Fills board with empty pieces with alternating
     * colours.
     */
    public Gameboard() {
        // Loop through the board and initialize with empty pieces
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if ((i + j) % 2 == 0) {
                    board[i][j] = new Piece(i, j, 0, board, whiteImg);
                } else {
                    board[i][j] = new Piece(i, j, 0, board, blackImg);
                }
            }
        }
    }

    /**
     * Method to print piece types and colours for debugging.
     * 
     */
    public void print() {
        // Write contents of line to a string and print that line, then reset
        String line = "";
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                // Parse string to make output look cleaner and less redundant
                line += (board[x][y].getClass().toString() + "\t").replaceAll("class Pieces.", "");
            }
            System.out.println(line);
            line = "";
        }
        System.out.println();

        line = "";
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                line += board[x][y].colour + "\t";
            }
            System.out.println(line);
            line = "";
        }
        System.out.println();
    }
}