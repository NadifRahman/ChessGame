package Pieces;

import java.util.*;
import javax.swing.*;

/**
 * Base Piece Object.
 * 
 * @author Charlie Li
 * @author Justin Hanna
 */
public class Piece {

    // Declare Object Variables
    public int posX, posY, colour;
    public ImageIcon pieceImg;

    /**
     * General Constructor for Pieces.
     * 
     * @param posX     X Co-Ordinate on Board.
     * @param posY     Y Co-Ordinate on Board.
     * @param colour   Colour of this piece.
     * @param board    Piece Board.
     * @param pieceImg Assigned Piece Image.
     */
    public Piece(int posX, int posY, int colour, Piece[][] board, ImageIcon pieceImg) {
        this.posX = posX;
        this.posY = posY;
        this.colour = colour;
        this.pieceImg = pieceImg;
        board[posX][posY] = this;
    }

    /**
     * Method to generate a list of possible moves for this piece.
     * 
     * @param board Piece Board.
     * @return List of possible moves.
     */
    public ArrayList<int[]> possibleMoves(Piece[][] board) {
        ArrayList<int[]> moves = new ArrayList<>();
        return moves;
    }

    /**
     * Method to print position and colour of this piece for debugging.
     */
    public void printValues() {
        System.out.println(posX + " " + posY + "\t" + colour);
    }

    /**
     * Method to return check state for King pieces, otherwise useless.
     * 
     * @param board Game Board.
     * @return Check state of King. Null if piece is not a King.
     */
    public boolean checked(Piece[][] board) {
        return false;
    }

    /**
     * Method to reset Piece Image to original value.
     */
    public void resetImg() {
    }
}
