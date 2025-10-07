import java.util.*;

public class Ascending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = sc.nextInt();
        }

        int[] dp = new int[length];
        Arrays.fill(dp, 1); // each number alone is an increasing subsequence of length 1
        int highest = 1;

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            highest = Math.max(highest, dp[i]);
        }

        System.out.println(highest);
    }
}
