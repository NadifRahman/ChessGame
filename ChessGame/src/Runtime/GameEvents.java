package Runtime;

import javax.swing.*;
import java.awt.event.*;
import Pieces.*;
import java.util.*;

/**
 * Game Events Runtime Class.
 * 
 * @author Charlie Li
 * @author Justin Hanna
 * @author Nadif Rahman
 * @author Mo Lin Li
 */
public class GameEvents implements ActionListener {

    // Variable for the whether the next click is to select a piece (1) or move (2)
    int clickState = 1;

    // Variable for the number of moves
    int moveCount = 1;

    // Declare object variables
    // Player Names
    String whiteName, blackName;
    // GUI object
    GameGUI gui;
    // Gameboard Object
    Gameboard gameboard;
    // Piece Array to store pieces
    Piece[][] board;
    // Click buffer
    int firstClickX, firstClickY;
    // Check Condition Checks
    boolean whiteChecked, blackChecked;
    // Win Condition Checks
    boolean whiteKingExists, blackKingExists;

    // ArrayList for the possible moves of the selected piece
    ArrayList<int[]> selectedPossibleMoves = new ArrayList<int[]>();
    // ArrayLists for the total possible moves of a colour
    ArrayList<int[]> totalPossibleWhiteMoves = new ArrayList<int[]>();
    ArrayList<int[]> totalPossibleBlackMoves = new ArrayList<int[]>();

    // Create coordinates based on button number
    int x, y, num;

    // Import all image icons for buttons
    ImageIcon whitePawnImg = new ImageIcon(getClass().getResource("/Images/white pawn.png"));
    ImageIcon blackPawnImg = new ImageIcon(getClass().getResource("/Images/black pawn.png"));
    ImageIcon whiteKnightImg = new ImageIcon(getClass().getResource("/Images/white knight.png"));
    ImageIcon blackKnightImg = new ImageIcon(getClass().getResource("/Images/black knight.png"));
    ImageIcon whiteBishopImg = new ImageIcon(getClass().getResource("/Images/white bishop.png"));
    ImageIcon blackBishopImg = new ImageIcon(getClass().getResource("/Images/black bishop.png"));
    ImageIcon whiteRookImg = new ImageIcon(getClass().getResource("/Images/white rook.png"));
    ImageIcon blackRookImg = new ImageIcon(getClass().getResource("/Images/black rook.png"));
    ImageIcon whiteQueenImg = new ImageIcon(getClass().getResource("/Images/white queen.png"));
    ImageIcon blackQueenImg = new ImageIcon(getClass().getResource("/Images/black queen.png"));
    ImageIcon whiteKingImg = new ImageIcon(getClass().getResource("/Images/white king.png"));
    ImageIcon blackKingImg = new ImageIcon(getClass().getResource("/Images/black king.png"));
    ImageIcon highlightedImg = new ImageIcon(getClass().getResource("/Images/highlighted.png"));

    ImageIcon checkedWhiteKingImg = new ImageIcon(getClass().getResource("/Images/white king check.png"));
    ImageIcon checkedBlackKingImg = new ImageIcon(getClass().getResource("/Images/black king check.png"));

    ImageIcon whiteImg = new ImageIcon(getClass().getResource("/Images/white.png"));
    ImageIcon blackImg = new ImageIcon(getClass().getResource("/Images/black.png"));

    /**
     * Constructor for this Game Event run.
     * 
     * @param in        GUI to link to
     * @param whiteName Name of White Player
     * @param blackName Name of Black Player
     */
    public GameEvents(GameGUI in, String whiteName, String blackName) {
        // Assign Object Variables
        gui = in;
        this.whiteName = whiteName;
        this.blackName = blackName;

        // Run Initialization Sequence
        init();
    }

    /**
     * Method to initialize and populate the Gameboard.
     */
    public void init() {
        // Initializing the gameboard
        gameboard = new Gameboard();
        board = gameboard.board;

        // Initializing the pieces
        new Pawn(0, 6, 1, board, whitePawnImg);
        new Pawn(1, 6, 1, board, whitePawnImg);
        new Pawn(2, 6, 1, board, whitePawnImg);
        new Pawn(3, 6, 1, board, whitePawnImg);
        new Pawn(4, 6, 1, board, whitePawnImg);
        new Pawn(5, 6, 1, board, whitePawnImg);
        new Pawn(6, 6, 1, board, whitePawnImg);
        new Pawn(7, 6, 1, board, whitePawnImg);
        new Pawn(0, 1, 2, board, blackPawnImg);
        new Pawn(1, 1, 2, board, blackPawnImg);
        new Pawn(2, 1, 2, board, blackPawnImg);
        new Pawn(3, 1, 2, board, blackPawnImg);
        new Pawn(4, 1, 2, board, blackPawnImg);
        new Pawn(5, 1, 2, board, blackPawnImg);
        new Pawn(6, 1, 2, board, blackPawnImg);
        new Pawn(7, 1, 2, board, blackPawnImg);

        new Knight(1, 7, 1, board, whiteKnightImg);
        new Knight(6, 7, 1, board, whiteKnightImg);
        new Knight(1, 0, 2, board, blackKnightImg);
        new Knight(6, 0, 2, board, blackKnightImg);

        new Bishop(2, 7, 1, board, whiteBishopImg);
        new Bishop(5, 7, 1, board, whiteBishopImg);
        new Bishop(2, 0, 2, board, blackBishopImg);
        new Bishop(5, 0, 2, board, blackBishopImg);

        new Rook(0, 7, 1, board, whiteRookImg);
        new Rook(7, 7, 1, board, whiteRookImg);
        new Rook(0, 0, 2, board, blackRookImg);
        new Rook(7, 0, 2, board, blackRookImg);

        new Queen(3, 7, 1, board, whiteQueenImg);
        new Queen(3, 0, 2, board, blackQueenImg);

        new King(4, 7, 1, board, whiteKingImg, false);
        new King(4, 0, 2, board, blackKingImg, false);
    }

    /**
     * Method to update all piece images across the Gameboard.
     * 
     * @param clickState User's current selection state in game (Piece choose or
     *                   Movement Choose).
     */
    public void updateImages(int clickState) {
        // Setting the check booleans to default false value
        whiteChecked = false;
        blackChecked = false;

        // Checking through the gameboard squares to update the images
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Condition: Player is selecting a piece
                if (clickState == 1) {
                    // Condition: Piece is empty, so assign checkerboard pattern
                    if (board[i][j].colour == 0) {
                        if ((i + j) % 2 == 0) {
                            board[i][j].pieceImg = whiteImg;
                        } else {
                            board[i][j].pieceImg = blackImg;
                        }
                    }
                    // Resetting all images to original piece icons
                    board[i][j].resetImg();
                }

                // Condition: King is in check, so apply different icon to let player know and set the check booleans
                if (board[i][j] instanceof King && board[i][j].checked(board)
                        && board[i][j].pieceImg != highlightedImg) {
                    if (board[i][j].colour == 1) {
                        board[i][j].pieceImg = checkedWhiteKingImg;
                        whiteChecked = true;
                    } else if (board[i][j].colour == 2) {
                        board[i][j].pieceImg = checkedBlackKingImg;
                        blackChecked = true;
                    }
                }

                // Applying all icons to pieces
                gui.boxes[i][j].setIcon(board[i][j].pieceImg);
            }
        }
    }

    /**
     * Method to listen and act whenever a button is pressed.
     * 
     * @param event Input event from button.
     */
    public void actionPerformed(ActionEvent event) {
        // Create coordinates based on button number
        String command = event.getActionCommand();
        num = Integer.parseInt(command);
        x = (int) (num - 1) % 8;
        y = (int) Math.floor((num - 1) / 8);

        // Calling on the movement method for white and black
        movement(1, 0, whitePawnImg);
        movement(2, 7, blackPawnImg);

        // Update all button icons
        updateImages(clickState);

        // Setting the king existence booleans to false as default
        whiteKingExists = false;
        blackKingExists = false;

        // Searching for both kings and setting their existence booleans accordlingly
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] instanceof King) {
                    if (board[i][j].colour == 1) {
                        whiteKingExists = true;
                    }
                    if (board[i][j].colour == 2) {
                        blackKingExists = true;
                    }
                }
            }
        }

        // Win Conditions for white and black (the opponent's king does not exist)
        // Calling on leaderboards and hiding the game
        if (!blackKingExists) {
            new LeaderboardGUI(whiteName, blackName, 1);
            gui.setVisible(false);
            return;
        }
        if (!whiteKingExists) {
            new LeaderboardGUI(whiteName, blackName, 2);
            gui.setVisible(false);
            return;
        }

        // Clearing the arrayLists with the possible white and black moves
        totalPossibleBlackMoves.clear();
        totalPossibleWhiteMoves.clear();

        // Condition: Black king is not checked
        if (!blackChecked) {
            // Searching through the board for black pieces and adding their possible moves to the totalPossibleBlackMoves arrayList
            for (Piece[] line : board) {
                for (Piece piece : line) {
                    if (piece.colour == 2) {
                        for (int[] move : piece.possibleMoves(board)) {
                            totalPossibleBlackMoves.add(move);
                        }
                    }
                }
            }

            // Condition: Black has no possible moves
            if (totalPossibleBlackMoves.size() == 0) {
                // Calling on leaderboards and hiding the game
                new LeaderboardGUI(whiteName, blackName, 0);
                gui.setVisible(false);
                return;
            }
        }

        // Condition: White king is not checked
        if (!whiteChecked) {
            // Searching through the board for white pieces and adding their possible moves to the totalPossibleWhiteMoves arrayList
            for (Piece[] line : board) {
                for (Piece piece : line) {
                    if (piece.colour == 1) {
                        for (int[] move : piece.possibleMoves(board)) {
                            totalPossibleWhiteMoves.add(move);
                        }
                    }
                }
            }

            // Condition: White has no possible moves
            if (totalPossibleWhiteMoves.size() == 0) {
                // Calling on leaderboards and hiding the game
                new LeaderboardGUI(whiteName, blackName, 0);
                gui.setVisible(false);
                return;
            }
        }
    }

    /**
     * Method to select and move pieces.
     * 
     * @param pieceColour Colour of the piece to move
     * @param endPos Y-coordinate for the end of the board opposite to the side of the pieceColour
     * @param pawnImg Image for the pawn
     */
    public void movement(int pieceColour, int endPos, ImageIcon pawnImg) {
        // Condition: It is the pieceColour's turn to move
        if (moveCount % 2 == pieceColour % 2) {
            // Condition: Selecting a piece to move. It has to be the pieceColour
            if (clickState == 1 && board[x][y].colour == pieceColour) {
                // Assigning the possible moves of the selected piece to the arrayList
                selectedPossibleMoves = board[x][y].possibleMoves(board);

                // Highlighting the squares that are possible moves
                for (int i = 0; i < selectedPossibleMoves.size(); i++) {
                    board[selectedPossibleMoves.get(i)[0]][selectedPossibleMoves.get(i)[1]].pieceImg = highlightedImg;
                }

                // Saving the coordinate values of the original position
                firstClickX = x;
                firstClickY = y;

                // Changing the click state to 2
                clickState = 2;
            }

            // Condition: Selecting a position for the piece to move to
            else if (clickState == 2) {
                // Variable for whether the selected square is a possible move
                boolean moveExists = false;

                // Checking for the selected square in the arrayList of possible moves and
                // setting the moveExists variable accordingly
                for (int i = 0; i < selectedPossibleMoves.size(); i++) {
                    if (selectedPossibleMoves.get(i)[0] == x && selectedPossibleMoves.get(i)[1] == y) {
                        moveExists = true;
                    }
                }

                // Condition: Selected move is possible
                if (moveExists) {
                    // Initializing another piece object to copy the selected piece onto
                    Piece oldPiece = board[firstClickX][firstClickY];

                    // Change the coordinate properties of the selected piece
                    oldPiece.posX = x;
                    oldPiece.posY = y;

                    // Setting the selected position on the board to the selected piece
                    board[x][y] = oldPiece;

                    // Condition: Selected piece is a pawn
                    if (oldPiece instanceof Pawn) {
                        // Condition: A pawn has reached the end, so change it to a queen piece
                        if (oldPiece.colour == pieceColour && oldPiece.posY == endPos) {
                            board[x][y] = new Queen(x, y, pieceColour, board, pawnImg);
                        }
                    }

                    // Setting the original position of the piece to an empty piece
                    board[firstClickX][firstClickY] = new Piece(firstClickX, firstClickY, 0, board, whiteImg);

                    // Incrementing the move count and changing the click state
                    moveCount++;
                    clickState = 1;
                }
                // Condition: Selected move is not possible and the user selected another piece
                // of pieceColour
                else if (!moveExists && board[x][y].colour == pieceColour) {
                    // Changing the click state to 2
                    clickState = 2;
                    // Updating the images
                    updateImages(1);
                    // Assigning the possible moves of the selected piece to the arrayList
                    selectedPossibleMoves = board[x][y].possibleMoves(board);

                    // Highlighting the squares that are possible moves
                    for (int i = 0; i < selectedPossibleMoves.size(); i++) {
                        board[selectedPossibleMoves.get(i)[0]][selectedPossibleMoves
                                .get(i)[1]].pieceImg = highlightedImg;
                    }

                    // Saving the coordinate values of the original position
                    firstClickX = x;
                    firstClickY = y;
                }
            }
        }
    }
}