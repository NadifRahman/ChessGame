package Pieces;

import java.util.*;
import javax.swing.ImageIcon;

/**
 * King Chess Piece.
 * 
 * @author Charlie Li
 * @author Justin Hanna
 */
public class King extends Piece {

    // Importing Piece's Image Icons
    ImageIcon whiteKingImg = new ImageIcon(getClass().getResource("/Images/white king.png"));
    ImageIcon blackKingImg = new ImageIcon(getClass().getResource("/Images/black king.png"));

    /**
     * Constructor for this King piece.
     * 
     * @param posX     X Co-Ordinate on Board.
     * @param posY     Y Co-Ordinate on Board.
     * @param colour   Colour of this piece.
     * @param board    Piece Board.
     * @param pieceImg Assigned Piece Image.
     * @param checked  This piece's check state.
     */
    public King(int posX, int posY, int colour, Piece[][] board, ImageIcon pieceImg, boolean checked) {
        super(posX, posY, colour, board, pieceImg);
    }

    /**
     * Method to generate a list of possible moves for this piece.
     * 
     * @param board Piece Board.
     * @return ArrayList<int[]> List of possible moves.
     */
    public ArrayList<int[]> possibleMoves(Piece[][] board) {
        // ArrayList for possible moves
        ArrayList<int[]> moves = new ArrayList<>();

        // Condition: Position 1 right is in bounds
        if (posX + 1 < 8) {
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[posX + 1][posY].colour != this.colour) {
                moves.add(new int[] { posX + 1, posY });
            }
        }
        // Condition: Position 1 left is in bounds
        if (posX - 1 > -1) {
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[posX - 1][posY].colour != this.colour) {
                moves.add(new int[] {posX - 1, posY});
            }
        }
        // Condition: Position 1 down is in bounds
        if (posY + 1 < 8) {
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[posX][posY + 1].colour != this.colour) {
                moves.add(new int[] {posX, posY + 1});
            }
        }
        // Condition: Position 1 up is in bounds
        if (posY - 1 > -1) {
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[posX][posY - 1].colour != this.colour) {
                moves.add(new int[] {posX, posY - 1});
            }
        }
        // Condition: Position bottom right is in bounds
        if (posX + 1 < 8 && posY + 1 < 8) {
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[posX + 1][posY + 1].colour != this.colour) {
                moves.add(new int[] {posX + 1, posY + 1});
            }
        }
        // Condition: Position top right is in bounds
        if (posX + 1 < 8 && posY - 1 > -1) {
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[posX + 1][posY - 1].colour != this.colour) {
                moves.add(new int[] {posX + 1, posY - 1});
            }
        }
        // Condition: Position bottom left is in bounds
        if (posX - 1 > -1 && posY + 1 < 8) {
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[posX - 1][posY + 1].colour != this.colour) {
                moves.add(new int[] {posX - 1, posY + 1});
            }
        }
        // Condition: Position top left is in bounds
        if (posX - 1 > -1 && posY - 1 > -1) {
            // Condition: Position doesn't have a similar-coloured piece, so add it to the moves arrayList
            if (board[posX - 1][posY - 1].colour != this.colour) {
                moves.add(new int[] {posX - 1, posY - 1});
            }
        }

        // Returning the arrayList of possible moves
        return moves;
    }

    /**
     * Method to update King piece's check state.
     * 
     * @param board Piece Board.
     * @return boolean containing the updated check state of King piece.
     */
    public boolean checked(Piece[][] board) {
        // Searching through the board for are of the opponent's pieces
        for (Piece[] line : board) {
            for (Piece piece : line) {
                // Condition: A piece is not the same colour as the king
                if (piece.colour != this.colour) {
                    // Searching through the piece's possible moves for threats to the king
                    for (int[] move : piece.possibleMoves(board)) {
                        // Condition: A possible move of the piece can capture the king, so return true
                        if (move[0] == this.posX && move[1] == this.posY) {
                            return true;
                        }
                    }
                }
            }
        }

        // Returning false
        return false;
    }

    /**
     * Method to reset Piece Image to original value.
     */
    public void resetImg() {
        // Condition: Piece is white
        if (this.colour == 1) {
            // Setting the piece image to a white king
            this.pieceImg = whiteKingImg;
        } 
        // Condition: Piece is black
        else if (colour == 2) {
            // Setting the piece image to a black king
            this.pieceImg = blackKingImg;
        }
    }
}
