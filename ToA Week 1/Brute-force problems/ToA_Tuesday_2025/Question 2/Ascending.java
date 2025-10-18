import java.util.*;

public class Ascending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user for the array length
        System.out.print("Enter the number of elements in the array: ");
        int length = sc.nextInt();

        // Create an array to store the numbers
        int[] numbers = new int[length];
        System.out.println("Enter " + length + " integers (space-separated or one per line):");
        for (int i = 0; i < length; i++) {
            numbers[i] = sc.nextInt();
        }

        // dp[i] stores the length of the longest increasing subsequence ending at numbers[i]
        int[] dp = new int[length];
        Arrays.fill(dp, 1); // Each number alone is a subsequence of length 1

        int highest = 1; // Overall longest increasing subsequence length

        // Calculate LIS using dynamic programming
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            highest = Math.max(highest, dp[i]);
        }

        // Display the result nicely
        System.out.println("The length of the longest increasing subsequence is: " + highest);
    }
}
