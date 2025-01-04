package gr.aueb.cf.projects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class project1 {

    public static void main(String[] args) {
        String[] tokens;
        int[] numArray = new int[50];
        int count = 0;
        final int COMBINATIONS = 6;
        int[] num = new int[COMBINATIONS];
        int numbers = 0;


        try(Scanner in = new Scanner(new File("C:/tmp/project-1.txt"));
            PrintStream ps = new PrintStream(new File("C:/tmp/project-1-out.txt"), StandardCharsets.UTF_8)) {

                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    tokens = line.split("\\s+");

                    for (String token : tokens) {
                        try {
                            numbers = Integer.parseInt(token.trim());

                            if (numbers < 1 || numbers > 49 ) {
                                throw new ArithmeticException("Ο αριθμος: " + numbers + " ειναι εκτος επιτρεπτου ευρους (1 - 49).");
                            }

                            if (count < numArray.length) {
                                numArray[count++] = numbers;
                            }

                        }catch (NumberFormatException e) {
                            System.err.println("Σφαλμα το:" + token + " δεν ειναι αριθμος. Παρακαλω ειαγετε μονο ακεραιους αριθμους.");
                        }
                    }
                }

                numArray =Arrays.copyOf(numArray, count);
                Arrays.sort(numArray);

            for (int i = 0; i < numArray.length - 5; i++) {
                for (int j = i + 1; j < numArray.length - 4; j++) {
                    for (int k = j + 1; k < numArray.length - 3; k++) {
                        for (int l = k + 1; l < numArray.length - 2; l++) {
                            for (int m = l + 1; m < numArray.length - 1; m++) {
                                for (int n = m + 1; n < numArray.length; n++) {
                                    num[0] = numArray[i];
                                    num[1] = numArray[j];
                                    num[2] = numArray[k];
                                    num[3] = numArray[l];
                                    num[4] = numArray[m];
                                    num[5] = numArray[n];


                                    if (!isEven(num) && !isOdd(num) && !isContiguous(num) && !isSameTen(num)
                                            && !isSameEnding(num)) {
                                        ps.printf("%d %d %d %d %d %d\n",
                                                num[0], num[1], num[2], num[3], num[4], num[5]);

                                        System.out.printf("%d %d %d %d %d %d\n",
                                                num[0], num[1], num[2], num[3], num[4], num[5]);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }catch (IOException e){
            System.err.println("Error. file not found.");
        }





    }

    public static boolean isEven(int[] arr) {
        int evenCount = 0;

        for (int el : arr) {
            if (el % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount > 4 ;
    }

    public static boolean isOdd(int[] arr) {
         int oddsCount = 0;

         for (int el : arr) {
             if (el % 2 != 0) {
                 oddsCount++;
             }
         }
         return oddsCount > 4;
    }

    public static boolean isContiguous(int[] arr) {
        Arrays.sort(arr);
        int contiguousCount = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1] + 1) {
                contiguousCount++;
            }
        }
        return contiguousCount > 2;
    }

    public static boolean isSameEnding(int[] arr) {
        int[] endings = new int[10];

        for (int num : arr ) {
            endings[num % 10]++;
        }

        for (int count : endings) {
            if (count > 3) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSameTen(int[] arr) {
        int[] ten = new int[5];

        for (int num : arr) {
            ten[num / 10]++;
        }

        for (int count : ten) {
            if (count > 3) {
                return true;
            }
        }
        return false;
    }
}
