// Moegamat Rashaad Samsodien
// SMSMOE006
// 14 October

import java.util.Scanner;

public class Repayment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long C = sc.nextLong();
        System.out.println(findMinimumRepayment(C));
    }

    // Calculate digit sum efficiently
    public static long digitSum(long n) {
        long sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // Calculate total repayment for given N
    public static long repayment(long N) {
        long total = 0;
        for (long i = 1; i <= N; i++) {
            total += i * digitSum(N - i);
        }
        return total;
    }

    public static long findMinimumRepayment(long C) {
        long low = 1, high = 1_000_000; // Constraint limit
        long best = -1;

        while (low <= high) {
            long mid = (low + high) / 2;
            long pay = repayment(mid);

            if (pay >= C) {
                best = pay;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return best;
    }
}
