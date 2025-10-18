import java.util.Scanner;

public class Path {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The N grid size value:");
        int N = sc.nextInt();       // Grid size
        System.out.println("The number of obstacles(K):");
        int K = sc.nextInt();       // Number of obstacles

        boolean[][] obstacle = new boolean[N][N];
        System.out.println("Enter the obstacles coordinates:");
        // Map obstacles correctly: input (1,1) = bottom-left
        for (int k = 0; k < K; k++) {
            int r = sc.nextInt() - 1; // row from bottom
            int c = sc.nextInt() - 1; // column from left
            obstacle[N - 1 - r][c] = true; // map to 0-based array
        }

        System.out.println("The number of paths:\n" + countPaths(N, obstacle));
    }

    public static int countPaths(int N, boolean[][] obstacle) {
        long MOD = 1_000_000_007;
        long[][] dp = new long[N][N];

        // Start at bottom-left
        if (obstacle[N - 1][0]) return 0;
        dp[N - 1][0] = 1;

        // Fill DP table from bottom-left to top-right
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (obstacle[i][j]) {
                    dp[i][j] = 0; // blocked
                } else {
                    if (i + 1 < N) dp[i][j] = (dp[i][j] + dp[i + 1][j]) % MOD; // going right
                    if (j - 1 >= 0) dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;// going left
                }
            }
        }

        return (int) dp[0][N - 1]; // top-right
    }
}
