import java.util.Scanner;

public class Dividing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // number of planks
        int[] planks = new int[N];
        int maxLen = 0;

        for (int i = 0; i < N; i++) {
            planks[i] = sc.nextInt();
            if (planks[i] > maxLen) {
                maxLen = planks[i];
            }
        }

        int K = sc.nextInt(); // minimum number of planks required

        System.out.println(findMaxLength(planks, K, maxLen));
    }

    // Binary search to find the maximum M that works
    public static int findMaxLength(int[] planks, int K, int maxLen) {
        int low = 1;       // smallest possible length
        int high = maxLen; // largest possible length
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2; // candidate length
            long count = 0;

            // count how many planks of 'mid' length can be cut
            for (int plank : planks) {
                count += plank / mid;
            }

            if (count >= K) {
                // can make enough planks, try for longer
                result = mid;
                low = mid + 1;
            } else {
                // too few planks, need shorter length
                high = mid - 1;
            }
        }

        return result;
    }
}
