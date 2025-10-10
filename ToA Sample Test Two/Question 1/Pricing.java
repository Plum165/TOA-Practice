import java.util.Scanner;

public class Pricing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Optional user prompt — comment this out if submitting to automarker
        System.out.print("Enter the amount of currency (N): ");

        long N = sc.nextLong(); // total amount of money

        // We’ll use binary search to find the largest K such that f(K) <= N
        long low = 1;
        long high = N; // upper bound, since f(K) grows faster than K
        long best = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2; // use /2, not /4

            long cost = f(mid);

            if (cost <= N) {
                best = mid;       // mid is affordable
                low = mid + 1;    // try a higher K
            } else {
                high = mid - 1;   // too expensive
            }
        }

        // Final output (required exact format)
        //System.out.println(best);

        // Optional user-friendly message
         System.out.println("Maximum number of gems that can be purchased: " + best);
    }

    /**
     * Efficient O(SqaureRoot(K)) calculation of f(K)
     * f(K) = Sum [ j * (K / j) ] for j = 1 to K - 1
     */
    public static long f(long K) {
        long sum = 0;
        long j = 1;

        while (j < K) {
            long q = K / j;            // current integer quotient
            long next = K / q + 1;     // next j where quotient changes
            long end = Math.min(next, K);

            // sum of integers from j to end-1: arithmetic progression
            long count = end - j;
            long rangeSum = (j + (end - 1)) * count / 2;

            sum += rangeSum * q;
            if (sum < 0) return Long.MAX_VALUE; // overflow guard

            j = end; // jump directly to the next range
        }

        return sum;
    }
}
