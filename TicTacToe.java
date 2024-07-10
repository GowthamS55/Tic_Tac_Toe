import java.util.Scanner;
public class TicTacToe {
    int SIZE = 3;
    char[][] board = new char[SIZE][SIZE];
    char currentPlayer = 'X';

    public TicTacToe() {
        this.initializeBoard();
    }
    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }
    public void displayBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
                if (j < SIZE - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < SIZE - 1) {
                System.out.println("  -----");
            }
        }
    }

    private boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Switch the current player between 'X' and 'O'
    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    private boolean checkWinner() {

        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }

        for (int j = 0; j < SIZE; j++) {
            if (board[0][j] == currentPlayer && board[1][j] == currentPlayer && board[2][j] == currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    // Main game logic
    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        System.out.println("Welcome to Tic-Tac-Toe!");
        displayBoard();
        while (playing) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                displayBoard();
                if (checkWinner()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    playing = false;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw.");
                    playing = false;
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
        public static void main(String[] var0) {

            TicTacToe player = new TicTacToe();
            player.play();

        }
}
