package gr.aueb.cf.projects;

import java.util.Scanner;

public class project5 {
    static boolean seats[][] = new boolean[30][12];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char column;
        int row;

        while (true) {
            System.out.println("Please choose a seat to book between A1 - L30 or type 'exit' ");
            String input = in.next();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using the program.\nQuiting...");
                break;
            }
            column = input.charAt(0);
            row = in.nextInt();

            book(column, row);

        }




    }

    public static void book(char column, int row) {
        int columnSearch = column - 'A';
        int rowSearch = row - 1;

        if (isValidPosition(columnSearch, rowSearch)) {
            if (!seats[rowSearch][columnSearch]) {
                seats[rowSearch][columnSearch] = true;
                System.out.println("The seat " + column + row + " is booked");
            } else {
                cancel(column, row);
            }
        } else {
            System.out.println("This seat does not exist.");
        }
    }

    public static void cancel(char column, int row) {
        int columnSearch = column - 'A';
        int rowSearch = row - 1;

        if (isValidPosition(columnSearch, rowSearch)) {
            if (seats[rowSearch][columnSearch]) {
                //Δεν ειμαι σιγουρος αν θελετε οταν υπαρχει κρατημενη θεση να κανει ακυρωση την ηδη υπαρχουσα κρατημενη
                //θεση η οχι για αυτο την εχω βαλει σε σχολιο την παρακατω εντολη.
                //seats[rowSearch][columnSearch] = false;
                System.out.println("The seat " + column + row + " is already taken. Cancel booking.");
            }

        }
    }

    public static boolean isValidPosition(int column, int row) {
        return column >= 0 && column < 12 && row >= 0 && row < 30;
    }
}
