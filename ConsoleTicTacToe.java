
import java.util.Scanner;

public class ConsoleTicTacToe {

    int swabPlayers(int currentPlayer) {
        return currentPlayer *= -1;
    }

    boolean checkWinning(int[][] logicBoard) {
        // check rows and columns
        for (int i = 0; i < 3; i++) {
            if (logicBoard[0][i] + logicBoard[1][i] + logicBoard[2][i] == 3) {
                return true;
            }
            if (logicBoard[0][i] + logicBoard[1][i] + logicBoard[2][i] == -3) {
                return true;
            }
            if (logicBoard[i][0] + logicBoard[i][1] + logicBoard[i][2] == 3) {
                return true;
            }
            if (logicBoard[i][0] + logicBoard[i][1] + logicBoard[i][2] == -3) {
                return true;
            }
        }
        // check diagonals
        if (logicBoard[0][0] + logicBoard[1][1] + logicBoard[2][2] == 3) {
            return true;
        }
        if (logicBoard[0][0] + logicBoard[1][1] + logicBoard[2][2] == -3) {
            return true;
        }
        if (logicBoard[0][2] + logicBoard[1][1] + logicBoard[2][0] == 3) {
            return true;
        }
        if (logicBoard[0][2] + logicBoard[1][1] + logicBoard[2][0] == -3) {
            return true;
        }
        return false;
    }

    void drawBoard(char[][] visibleBoard, int[][] logicBoard) {
        System.out.print("\033[H\033[2J"); // ANSI-Sequence to clear the console
        System.out.flush();
        // Print the visible board
        for (int row = 0; row < visibleBoard.length; row++) {
            for (int col = 0; col < visibleBoard[row].length; col++) {
                switch (logicBoard[row][col]) {
                    case 1 ->
                        System.out.print("X");
                    case -1 ->
                        System.out.print("O");
                    default ->
                        System.out.print(visibleBoard[row][col]);
                }

                if (col != 2) {
                    System.out.print(" | ");
                } else {
                    System.out.println();
                }
            }
            if (row != 2) {
                System.out.println("----------");
            }
        }
    }

    public int getPlayerNumber(int currentPlayer) {
        if (currentPlayer == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) {
        ConsoleTicTacToe game = new ConsoleTicTacToe();
        // Array declaration
        char[][] visibleBoard = new char[3][3];
        int[][] logicBoard = new int[3][3];
        // declaring variables
        int currentPlayer = 1;
        int playerNumber;
        int choice = 0;
        boolean gameOver = false;
        char number = '1';
        // Scanner object
        Scanner scanner = new Scanner(System.in);

        // Fill the visible board with the numbers from 1 to 9
        // and the logic board with zeros
        for (int row = 0; row < visibleBoard.length; row++) {
            for (int col = 0; col < visibleBoard[row].length; col++) {
                visibleBoard[row][col] = number++;
                logicBoard[row][col] = 0;
            }
        }

        while (!gameOver) {
            // Draw the board
            game.drawBoard(visibleBoard, logicBoard);
            // get the real player number 1 or 2 instead of 1 and -1
            playerNumber = game.getPlayerNumber(currentPlayer);
            // get the player input
            while (true) {
                System.out.printf("Player %d enter number (1-9): ", playerNumber);
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > 9) {
                        System.out.println("Invalid input. Please enter a number between 1 and 9.");
                    } else {
                        break;
                    }
                } else {

                    choice = 0;
                }
            }
            choice--;
            logicBoard[(int) choice / 3][(int) choice % 3] = currentPlayer;
            gameOver = game.checkWinning(logicBoard);
            choice = 0;
            if (!gameOver) {
                currentPlayer = game.swabPlayers(currentPlayer);
            } else {
                game.drawBoard(visibleBoard, logicBoard);
                playerNumber = game.getPlayerNumber(currentPlayer);
                System.out.printf("Game Over. Player %d won!%n", playerNumber);
                break;
            }

        }
        scanner.close();
    }
}
