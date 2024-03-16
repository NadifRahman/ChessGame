package Pieces;

import java.util.*;
import javax.swing.*;

/**
 * Knight Piece Object.
 * 
 * @author Charlie Li
 * @author Justin Hanna
 */

public class Knight extends Piece {

    // Importing Piece's Image Icons
    ImageIcon whiteKnightImg = new ImageIcon(getClass().getResource("/Images/white knight.png"));
    ImageIcon blackKnightImg = new ImageIcon(getClass().getResource("/Images/black knight.png"));

    /**
     * Constructor this for Knight piece.
     * 
     * @param posX     X Co-Ordinate on Board.
     * @param posY     Y Co-Ordinate on Board.
     * @param colour   Colour of this piece.
     * @param board    Piece Board.
     * @param pieceImg Assigned Piece Image.
     */
    public Knight(int posX, int posY, int colour, Piece[][] board, ImageIcon pieceImg) {
        super(posX, posY, colour, board, pieceImg);

    }

    /**
     * Method to generate a list of possible moves for this piece.
     * 
     * @param board Piece Board.
     * @return List of possible moves.
     */
    public ArrayList<int[]> possibleMoves(Piece[][] board) {
        // ArrayList for possible moves
        ArrayList<int[]> moves = new ArrayList<>();

        // Condition: Position 1 right and 2 down is in bounds
        if (posX + 1 < 8 && posY + 2 < 8) {
            // Condition: A similar-coloured piece doesn't exist in the position, so add it to the moves arrayList
            if (board[posX + 1][posY + 2].colour != this.colour) {
                moves.add(new int[] {posX + 1, posY + 2});
            }
        }
        // Condition: Position 1 right and 2 up is in bounds
        if (posX + 1 < 8 && posY - 2 > -1) {
            // Condition: A similar-coloured piece doesn't exist in the position, so add it to the moves arrayList
            if (board[posX + 1][posY - 2].colour != this.colour) {
                moves.add(new int[] {posX + 1, posY - 2});
            }
        }
        // Condition: Position 1 left and 2 down is in bounds
        if (posX - 1 > -1 && posY + 2 < 8) {
            // Condition: A similar-coloured piece doesn't exist in the position, so add it to the moves arrayList
            if (board[posX - 1][posY + 2].colour != this.colour) {
                moves.add(new int[] {posX - 1, posY + 2});
            }
        }
        // Condition: Position 1 left and 2 up is in bounds
        if (posX - 1 > -1 && posY - 2 > -1) {
            // Condition: A similar-coloured piece doesn't exist in the position, so add it to the moves arrayList
            if (board[posX - 1][posY - 2].colour != this.colour) {
                moves.add(new int[] {posX - 1, posY - 2});
            }
        }
        // Condition: Position 2 right and 1 down is in bounds
        if (posX + 2 < 8 && posY + 1 < 8) {
            // Condition: A similar-coloured piece doesn't exist in the position, so add it to the moves arrayList
            if (board[posX + 2][posY + 1].colour != this.colour) {
                moves.add(new int[] {posX + 2, posY + 1});
            }
        }
        // Condition: Position 2 right and 1 up is in bounds
        if (posX + 2 < 8 && posY - 1 > -1) {
            // Condition: A similar-coloured piece doesn't exist in the position, so add it to the moves arrayList
            if (board[posX + 2][posY - 1].colour != this.colour) {
                moves.add(new int[] {posX + 2, posY - 1});
            }
        }
        // Condition: Position 2 left and 1 down is in bounds
        if (posX - 2 > -1 && posY + 1 < 8) {
            // Condition: A similar-coloured piece doesn't exist in the position, so add it to the moves arrayList
            if (board[posX - 2][posY + 1].colour != this.colour) {
                moves.add(new int[] {posX - 2, posY + 1});
            }
        }
        // Condition: Position 2 left and 1 up is in bounds
        if (posX - 2 > -1 && posY - 1 > -1) {
            // Condition: A similar-coloured piece doesn't exist in the position, so add it to the moves arrayList
            if (board[posX - 2][posY - 1].colour != this.colour) {
                moves.add(new int[] {posX - 2, posY - 1});
            }
        }

        // Returning the arrayList of possible moves
        return moves;
    }

    /**
     * Method to reset Piece Image to original value.
     */
    public void resetImg() {
        // Condition: Piece is white
        if (this.colour == 1) {
            // Setting the piece image to a white kinght
            this.pieceImg = whiteKnightImg;
        } 
        // Condition: Piece is white
        else if (colour == 2) {
            // Setting the piece image to a black kinght
            this.pieceImg = blackKnightImg;
        }
    }
}
