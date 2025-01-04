package gr.aueb.cf.projects;

import java.io.*;
import java.util.Scanner;

// Δεν καταφερα να την λυσω. Εψαξα στο ιντερνετ για καποιες λυσεις του προβληματος αλλα εβλεπα εντολες τις οποιες
// δεν εχουμε διδαχθει ακομα και δεν ξερω κατα ποσο θα περνουσε ως σωστη λυση.

public class project3 {

    public static void main(String[] args) {
        char[][] arr = new char[128][2];

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = (char) i;
            arr[i][1] = 0;

            try (BufferedReader bf = new BufferedReader(new FileReader("C:/tmp/project-3.txt"))) {
                int currentChar;

                while ((currentChar = bf.read()) != -1) {
                    if (!Character.isWhitespace(currentChar)) {
                        arr[currentChar][1]++;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
