package gr.aueb.cf.projects;

public class project2 {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Το μεγιστο αθροισμα του πινακα ειναι: " + maxSubArray(arr));

    }

    public static int maxSubArray(int[] arr) {
        int max = arr[0];
        int maxSubEnding = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (maxSubEnding + arr[i] > arr[i]) {
                maxSubEnding = maxSubEnding + arr[i];
            } else {
                maxSubEnding = arr[i];
            }

            if (maxSubEnding > max) {
                max = maxSubEnding;
            }
        }
        return max;
    }
}
