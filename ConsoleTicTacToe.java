
import java.util.Scanner;

public class ConsoleTicTacToe {

    int swabPlayers(int currentPlayer) {
        return currentPlayer *= -1;
    }

    public static void main(String[] args) {
        // Array declaration
        char[][] visibleBoard = new char[3][3];
        int[][] logicBoard = new int[3][3];
        // declaring variables
        char playerOne = 'X';
        char playerTwo = 'O';
        int currentPlayer = 1;
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
            System.out.print("\033[H\033[2J"); // ANSI-Sequenz to clear the console
            System.out.flush();
            // Print the visible board
            for (int row = 0; row < visibleBoard.length; row++) {

                for (int col = 0; col < visibleBoard[row].length; col++) {
                    if (logicBoard[row][col] == 1) {
                        System.out.print(playerOne);
                    } else if (logicBoard[row][col] == -1) {
                        System.out.print(playerTwo);
                    } else {
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
            while (choice == 0) {
                int playerNumber;
                if (currentPlayer == 1) {
                    playerNumber = 1;
                } else {
                    playerNumber = 2;
                }
                System.out.printf("Player %d enter number (1-9): ", playerNumber);
                if (scanner.hasNextInt() && scanner.nextInt() >= 1 && scanner.nextInt() <= 9) {
                    choice = scanner.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
            choice = 0;

        }
    }
}
