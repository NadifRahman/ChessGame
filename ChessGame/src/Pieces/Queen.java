package Pieces;

import java.util.*;
import javax.swing.ImageIcon;

/**
 * Queen Chess Piece.
 * 
 * @author Charlie Li
 * @author Justin Hanna
 */
public class Queen extends Piece {

    // Importing Piece's Image Icons
    ImageIcon whiteQueenImg = new ImageIcon(getClass().getResource("/Images/white queen.png"));
    ImageIcon blackQueenImg = new ImageIcon(getClass().getResource("/Images/black queen.png"));

    /**
     * Constructor for this Queen piece.
     * 
     * @param posX     X Co-Ordinate on Board.
     * @param posY     Y Co-Ordinate on Board.
     * @param colour   Colour of this piece.
     * @param board    Piece Board.
     * @param pieceImg Assigned Piece Image.
     */
    public Queen(int posX, int posY, int colour, Piece[][] board, ImageIcon pieceImg) {
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

        // Variables for calculating the diagonals
        boolean obstacle = false;
        int tempPosX = posX;
        int tempPosY = posY;

        // Checking if the bottom right diagonal is in bounds and has not met an obstacle
        while (tempPosX + 1 < 8 && tempPosY + 1 < 8 && !obstacle) {
            // Altering the calculating variables accordingly
            tempPosX++;
            tempPosY++;
            // Condition: Position is not empty, so set obstacle to true
            if (board[tempPosX][tempPosY].colour != 0) {
                obstacle = true;

            }
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[tempPosX][tempPosY].colour != this.colour) {
                moves.add(new int[] {tempPosX, tempPosY});
            }
        }

        // Resetting the variables for calculating the diagonals (1)
        obstacle = false;
        tempPosX = posX;
        tempPosY = posY;

        // Checking if the top right diagonal is in bounds and has not met an obstacle
        while (tempPosX + 1 < 8 && tempPosY - 1 > -1 && !obstacle) {
            // Altering the calculating variables accordingly
            tempPosX++;
            tempPosY--;
            // Condition: Position is not empty, so set obstacle to true
            if (board[tempPosX][tempPosY].colour != 0) {
                obstacle = true;
            }
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[tempPosX][tempPosY].colour != this.colour) {
                moves.add(new int[] {tempPosX, tempPosY});
            }
        }

        // Resetting the variables for calculating the diagonals (2)
        obstacle = false;
        tempPosX = posX;
        tempPosY = posY;

        // Checking if the bottom left diagonal is in bounds and has not met an obstacle
        while (tempPosX - 1 > -1 && tempPosY + 1 < 8 && !obstacle) {
            // Altering the calculating variables accordingly
            tempPosX--;
            tempPosY++;
            // Condition: Position is not empty, so set obstacle to true
            if (board[tempPosX][tempPosY].colour != 0) {
                obstacle = true;
            }
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[tempPosX][tempPosY].colour != this.colour) {
                moves.add(new int[] {tempPosX, tempPosY});
            }
        }

        // Resetting the variables for calculating the diagonals (3)
        obstacle = false;
        tempPosX = posX;
        tempPosY = posY;

        // Checking if the top left diagonal is in bounds and has not met an obstacle
        while (tempPosX - 1 > -1 && tempPosY - 1 > -1 && !obstacle) {
            // Altering the calculating variables accordingly
            tempPosX--;
            tempPosY--;
            // Condition: Position is not empty, so set obstacle to true
            if (board[tempPosX][tempPosY].colour != 0) {
                obstacle = true;
            }
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[tempPosX][tempPosY].colour != this.colour) {
                moves.add(new int[] {tempPosX, tempPosY});
            }
        }

        // Resetting the variables for calculating the sides (4)
        obstacle = false;
        tempPosX = posX;
        tempPosY = posY;

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

        // Resetting the variables for calculating the sides (5)
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

        // Resetting the variables for calculating the sides (6)
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

        // Resetting the variables for calculating the sides (7)
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
            // Setting the piece image to a white queen
            this.pieceImg = whiteQueenImg;
        } 
        // Condition: Piece is black
        else if (colour == 2) {
            // Setting the piece image to a black queen
            this.pieceImg = blackQueenImg;
        }
    }
}
