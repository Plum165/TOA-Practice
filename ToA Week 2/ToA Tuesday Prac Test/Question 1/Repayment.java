// Moegamat Rashaad Samsodien
// SMSMOE006
// 14 October
// Repayment.java - User-friendly version

import java.util.Scanner;

public class Repayment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Loan Repayment Calculator ===");
        System.out.print("Enter the amount borrowed (C): ");
        long C = sc.nextLong();

        System.out.println("\nCalculating minimum repayment period...");
        long result = findMinimumRepayment(C);

        System.out.println("------------------------------------------");
        System.out.println("Minimum total repayment amount (K): " + result);
        System.out.println("That’s the smallest amount >= " + C + " you must repay.");
        System.out.println("==========================================");
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

    // Calculate total repayment for a given N
    public static long repayment(long N) {
        long total = 0;
        for (long i = 1; i <= N; i++) {
            total += i * digitSum(N - i);
        }
        return total;
    }

    // Binary search to find the minimum N such that repayment(N) >= C
    public static long findMinimumRepayment(long C) {
        long low = 1, high = 1_000_000; // Constraint limit
        long bestK = -1;

        while (low <= high) {
            long mid = (low + high) / 2;
            long pay = repayment(mid);

            System.out.println("Checking " + mid + " days -> total repayment = " + pay);

            if (pay >= C) {
                bestK = pay;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return bestK;
    }
}
