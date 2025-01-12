import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Board Dimensions:-[N][N]:- ");
        int N = scanner.nextInt();
        char[][] board = new char[N][N];
        for (char[] board1 : board) {
            for (int col = 0; col < board1.length; col++) {
                board1[col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " enter: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (board[row][col] != ' ') {
                System.out.println("Invalid Move. Try again!");
                continue;
            }
            board[row][col] = player;
            gameOver = haveWon(board, player);
            if (gameOver) {
                System.out.println("Player " + player + " has won: ");
                break;
            }
            player = (player == 'X') ? 'O' : 'X';
        }
        printBoard(board);
        System.out.println("Want to play again?: (y/n)");
        if ("y".equals(scanner.next())) {
            main(new String[] { "Play Again" });
        }
    }

    public static boolean haveWon(char[][] board, char player) {
        boolean win = false;
        // row check
        rowCheck: for (char[] row : board) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] != player) {
                    continue rowCheck;
                }
            }
            win = true;
            return win;
        }
        // col check
        colCheck: for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != player) {
                    continue colCheck;
                }
            }
            win = true;
            return win;
        }
        // diagonal check -> top to down (left to right)
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == player) {
                win = win & true;
            } else {
                win = win & false;
            }
        }
        // diagonal check -> top to down (right to left)
        if (win == false) {
            for (int i = board[0].length - 1; i >= 0; i--) {
                if (board[board.length - i - 1][i] != player) {
                    win = win & false;
                }
                else{
                    win = win & true;
                }
            }
        }
        return win;
    }

    public static void printBoard(char board[][]) {
        for (char b[] : board) {
            System.out.print("|");
            for (int i = 0; i < b.length; i++) {
                System.out.print(b[i] + "|");
            }
            System.out.println();
        }
    }
}
