package Pieces;

import java.util.*;
import javax.swing.*;

/**
 * Base Piece Object.
 * 
 * @author Charlie Li
 * @author Justin Hanna
 */

public class Pawn extends Piece {

    // Importing Piece's Image Icons
    ImageIcon whitePawnImg = new ImageIcon(getClass().getResource("/Images/white pawn.png"));
    ImageIcon blackPawnImg = new ImageIcon(getClass().getResource("/Images/black pawn.png"));

    /**
     * Constructor for this Pawn piece.
     * 
     * @param posX     X Co-Ordinate on Board.
     * @param posY     Y Co-Ordinate on Board.
     * @param colour   Colour of this piece.
     * @param board    Piece Board.
     * @param pieceImg Assigned Piece Image.
     */
    public Pawn(int posX, int posY, int colour, Piece[][] board, ImageIcon pieceImg) {
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

        // Condition: White's move
        if (this.colour == 1) {
            // Condition: It's the pawn's first move
            if (posY == 6) {
                // Condition: Position 1 and 2 above is empty
                if (board[posX][posY - 1].colour == 0 && board[posX][posY - 2].colour == 0) {
                    // Adding the position to the moves arrayList
                    moves.add(new int[] {posX, posY - 2});
                }
            }

            // Condition: Position 1 above is empty
            if (board[posX][posY - 1].colour == 0) {
                // Adding the position to the moves arrayList
                moves.add(new int[] {posX, posY - 1});
            }

            // Condition: Diagonal 1 is in bounds
            if (posX - 1 > -1 && posY - 1 > -1) {
                // Condition: Position has a black piece
                if (board[posX - 1][posY - 1].colour == 2) {
                    // Adding the position to the moves arrayList
                    moves.add(new int[] {posX - 1, posY - 1});
                }
            }
            // Condition: Diagonal 2 is in bounds
            if (posX + 1 < 8 && posY - 1 > -1) {
                // Condition: Position has a black piece
                if (board[posX + 1][posY - 1].colour == 2) {
                    // Adding the position to the moves arrayList
                    moves.add(new int[] {posX + 1, posY - 1});
                }
            }
        }

        // Condition: It's black's move
        if (this.colour == 2) {
            // Condition: It's the pawn's first move
            if (posY == 1) {
                // Condition: Position 1 and 2 below is empty
                if (board[posX][posY + 1].colour == 0 && board[posX][posY + 2].colour == 0) {
                    // Adding the position to the moves arrayList
                    moves.add(new int[] {posX, posY + 2});
                }
            }
            // Condition: Position 1 below is empty
            if (board[posX][posY + 1].colour == 0) {
                // Adding the position to the moves arrayList
                moves.add(new int[] {posX, posY + 1});
            }
            // Condition: Diagonal 1 is in bounds
            if (posX + 1 < 8 && posY + 1 < 8) {
                // Condition: Position has a white piece
                if (board[posX + 1][posY + 1].colour == 1) {
                    // Adding the position to the moves arrayList
                    moves.add(new int[] {posX + 1, posY + 1});
                }
            }
            // Condition: Diagonal 2 is in bounds
            if (posX - 1 > -1 && posY + 1 < 8) {
                // Condition: Position has a white piece
                if (board[posX - 1][posY + 1].colour == 1) {
                    // Adding the position to the moves arrayList
                    moves.add(new int[] {posX - 1, posY + 1});
                }
            }
        }

        // Returning the arrayList of possible moves
        return moves;
    }

    /**
     * Method to reset Piece Image to original value.
     */
    public void resetImg() {
        // Piece is white
        if (this.colour == 1) {
            // Setting the image to a white pawn
            this.pieceImg = whitePawnImg;
        } 
        // Piece is black
        else if (colour == 2) {
            // Setting the image to a black pawn
            this.pieceImg = blackPawnImg;
        }
    }
}
