# Console Tic Tac Toe

This is a simple Tic Tac Toe game written in Java, designed to be played in the console by two players.

How to Run
Ensure you have Java 8 or later installed.
Copy the code into a file named ConsoleTicTacToe.java.

Compile the program:
javac ConsoleTicTacToe.java

Run the program:
java ConsoleTicTacToe

Game Rules:
The game is played by two players: Player 1 (X) and Player 2 (O).
Players take turns choosing a position on a 3x3 grid by entering a number between 1 and 9, corresponding to the grid

positions:
1 | 2 | 3

---

## 4 | 5 | 6

7 | 8 | 9

The first player to align three of their symbols (horizontally, vertically, or diagonally) wins.
If all grid spaces are filled without a winner, the game ends in a draw.

Features
Input validation ensures players can only choose unoccupied grid spaces.
Displays the board state after each turn.
Announces the winner or declares a draw at the end of the game.

Code Structure
Classes and Methods:
swapPlayers(int currentPlayer): Switches the current player between 1 and -1.
checkWinning(int[][] logicBoard): Checks for a winning condition based on the logical board.
drawBoard(char[][] visibleBoard, int[][] logicBoard): Displays the game board in the console.
getPlayerNumber(int currentPlayer): Maps internal player representation to player numbers (1 or 2).
main(String[] args): Contains the game loop and controls the overall program flow.

Game Logic:
The logical game board uses integers: 1 for Player 1 (X), -1 for Player 2 (O), and 0 for unoccupied spaces.
The visible game board reflects the grid with numbers (1–9) or player symbols (X or O).
