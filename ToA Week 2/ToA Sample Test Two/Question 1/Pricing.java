import java.util.Scanner;

public class Pricing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong(); // total amount of money

        long low = 1;
        long high = N; // reasonable upper bound for K
        long best = 0;

        while (low <= high) {
            long mid = low + (high - low) / 4;
            long cost = f(mid);

            if (cost <= N) {
                best = mid;       // mid is affordable
                low = mid + 1;    // try to buy more gems
            } else {
                high = mid - 1;   // too expensive
            }
        }

        System.out.println(best);
    }

    // Compute f(K) = sum of j * (K / j) for j = 1 to K - 1
    public static long f(long K) {
    long sum = 0;
    long j = 1;

    while (j < K) {
        long q = K / j;            // current integer quotient
        long next = K / q + 1;     // next j where quotient changes
        long end = Math.min(next, K); // ensure not to exceed K
        
        // sum of integers from j to end-1
        long count = end - j;
        long rangeSum = (j + (end - 1)) * count / 2;

        sum += rangeSum * q;
        if (sum < 0) return Long.MAX_VALUE; // overflow guard

        j = end; // jump directly to the next segment
    }

    return sum;
}

}
