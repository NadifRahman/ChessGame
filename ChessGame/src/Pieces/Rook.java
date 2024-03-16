package Pieces;

import java.util.*;
import javax.swing.ImageIcon;

/**
 * Rook Chess Piece.
 * 
 * @author Charlie Li
 * @author Justin Hanna
 */
public class Rook extends Piece {

    // Importing Piece's Image Icons
    ImageIcon whiteRookImg = new ImageIcon(getClass().getResource("/Images/white rook.png"));
    ImageIcon blackRookImg = new ImageIcon(getClass().getResource("/Images/black rook.png"));

    /**
     * Constructor for this Rook piece.
     * 
     * @param posX     X Co-Ordinate on Board.
     * @param posY     Y Co-Ordinate on Board.
     * @param colour   Colour of this piece.
     * @param board    Piece Board.
     * @param pieceImg Assigned Piece Image.
     */
    public Rook(int posX, int posY, int colour, Piece[][] board, ImageIcon pieceImg) {
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

        // Variables for calculating the sides
        boolean obstacle = false;
        int tempPosX = posX;
        int tempPosY = posY;

        // Checking if the right side is in bounds and has not met an obstacle
        while (tempPosX + 1 < 8 && !obstacle) {
            // Altering the calculating variables accordingly
            tempPosX++;
            // Condition: Position is not empty, so set obstacle to true
            if (board[tempPosX][posY].colour != 0) {
                obstacle = true;
            }
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[tempPosX][posY].colour != this.colour) {
                moves.add(new int[] {tempPosX, posY});
            }
        }

        // Resetting the variables for calculating the sides (1)
        obstacle = false;
        tempPosX = posX;
        tempPosY = posY;

        // Checking if the left side is in bounds and has not met an obstacle
        while (tempPosX - 1 > -1 && !obstacle) {
            // Altering the calculating variables accordingly
            tempPosX--;
            // Condition: Position is not empty, so set obstacle to true
            if (board[tempPosX][posY].colour != 0) {
                obstacle = true;
            }
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[tempPosX][posY].colour != this.colour) {
                moves.add(new int[] {tempPosX, posY});
            }
        }

        // Resetting the variables for calculating the sides (2)
        obstacle = false;
        tempPosX = posX;
        tempPosY = posY;

        // Checking if the botton side is in bounds and has not met an obstacle
        while (tempPosY + 1 < 8 && !obstacle) {
            // Altering the calculating variables accordingly
            tempPosY++;
            // Condition: Position is not empty, so set obstacle to true
            if (board[posX][tempPosY].colour != 0) {
                obstacle = true;
            }
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[posX][tempPosY].colour != this.colour) {
                moves.add(new int[] {posX, tempPosY});
            }
        }

        // Resetting the variables for calculating the sides (3)
        obstacle = false;
        tempPosX = posX;
        tempPosY = posY;

        // Checking if the top side is in bounds and has not met an obstacle
        while (tempPosY - 1 > -1 && !obstacle) {
            // Altering the calculating variables accordingly
            tempPosY--;
            // Condition: Position is not empty, so set obstacle to true
            if (board[posX][tempPosY].colour != 0) {
                obstacle = true;
            }
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[posX][tempPosY].colour != this.colour) {
                moves.add(new int[] {posX, tempPosY});
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
            // Setting the piece image to a white rook
            this.pieceImg = whiteRookImg;
        } 
        // Condition: Piece is black
        else if (colour == 2) {
            // Setting the piece image to a black rook
            this.pieceImg = blackRookImg;
        }
    }
}
