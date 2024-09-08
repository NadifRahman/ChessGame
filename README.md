# Chess Game

## Overview

This is a chess game developed using Java and the Swing framework. It allows users to play a digital version of the classic chess game against another player on the same machine. The game offers an intuitive GUI, handles piece movement rules, and includes features like scorekeeping and a leaderboard to track player performance across multiple sessions.

The game is designed for two players, with white always moving first. It highlights possible moves for each selected piece, ensuring that players only make valid moves according to chess rules.

## Features

### 1. **Player Names**
- At the start of the game, players are prompted to enter their names. These names are used to identify players and track wins.
- The game does not allow empty or duplicate names for both players.

### 2. **Scorekeeping and Leaderboard**
- The game tracks wins for each player across multiple sessions. Wins are stored in permanent data files, ensuring that player stats persist even after closing the game.
- After each match, a leaderboard is displayed, showing all players who have participated and their respective win counts, ranked in descending order.

### 3. **Move Highlighting**
- The game highlights legal moves for a selected piece, preventing invalid moves. This ensures that players can only move pieces according to the rules of chess.
- Players can change their piece selection if needed by clicking on another piece.

### 4. **Modified Checkmate Condition**
- Checkmate occurs when a player's king is captured, rather than the traditional method of being placed in a checkmate position. This modification ensures both players remain vigilant during gameplay.

### 5. **Modified Stalemate Condition**
- Stalemate occurs when a player has no legal moves left but their king is not in check. The game is declared a tie under these conditions.

## How to Play

### 1. **Input Player Names**
- After launching the game, two popups will appear. Enter the name of the white player in the first popup and the name of the black player in the second popup. Ensure that the names are not identical or empty.

### 2. **Starting a Match**
- Once the names have been entered, the chessboard will appear with all pieces in their starting positions. White always moves first.

### 3. **Selecting and Moving Pieces**
- To move a piece, first select it by clicking on it. The game will highlight the possible legal moves for that piece in blue.
- Click on a highlighted square to move the piece to that location.
- After the white player's move, the black player follows the same steps to make their move.

### 4. **Game Progression**
- Players alternate turns until one player checkmates the other's king or a stalemate occurs.

### 5. **Game Over and Leaderboard**
- Once the game ends (by checkmate or stalemate), a popup will display the outcome, declaring the winner or indicating a tie.
- After dismissing the popup, the leaderboard is shown, displaying all players and their accumulated wins.

## Installation and Setup

To run the chess game, follow these steps:

1. **Download the Repository**:
   - Clone or download the repository to your local machine by clicking on the "Download ZIP" button or by running:
     ```bash
     git clone https://github.com/NadifRahman/ChessGame
     ```

2. **Unzip the Files**:
   - Unzip the downloaded files. Inside, you will find a folder named `ChessGame` and a `README.md` file.

3. **Setting Up in NetBeans**:
   - Move the `ChessGame` folder to your `NetBeansProjects` directory, or any folder of your choice.
   - Launch NetBeans, navigate to `File > Open Project`, and select the `ChessGame` folder.

4. **Run the Game**:
   - Press the green play button in NetBeans to start the chess game.


## Credits

### Team Members:
- Nadif Rahman
- Justin Hanna
- Charlie Li
- Mo Lin Li

