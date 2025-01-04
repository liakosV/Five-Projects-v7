package gr.aueb.cf.projects;

import java.util.Scanner;

public class project4 {


    public static char[][] board = new char[3][3];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final char PLAYER_X = 'X';
        final char PLAYER_O = 'O';
        final int SIZE = 3;
        char currentPlayer = PLAYER_X;
        int row;
        int col;
        int moves = 0;

        board();

        System.out.println("Welcome to TicTacToe");
        makeboard();


        while (true) {
            System.out.println("Παιζει ο: " + currentPlayer);
            System.out.println("Δωσε γραμμη 0-2 και δωσε στηλη 0-2.");

            row = in.nextInt();
            col = in.nextInt();



            if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == ' ') {
                System.out.println();
            }else {
                System.out.println("Μη έγκυρη κίνηση! Δοκίμασε ξανά.");
                moves--;
                makeboard();


                continue;
            }

            board[row][col] = currentPlayer;
            makeboard();
            moves++;

            if (winConditions(currentPlayer)) {
                System.out.println("Συγχαρητιρισ ο παικτης: " + currentPlayer + " Κερδισε!!!");
                break;
            } else if (moves == SIZE * SIZE) {
                System.out.println("Ισοπαλια.");
                break;
            }

            if (currentPlayer == PLAYER_X) {
                currentPlayer = PLAYER_O;
            } else {
                currentPlayer = PLAYER_X;
            }


        }
    }

    public static void board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void makeboard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 3 - 1) {
                    System.out.print(" |  ");
                }
            }
            System.out.println();
            if (i < 3 - 1) {
                System.out.println("----------");
            }
        }
    }

    public static boolean winConditions (char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }
}
