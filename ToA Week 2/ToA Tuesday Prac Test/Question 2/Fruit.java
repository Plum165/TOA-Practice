// Moegamat Rashaad Samsodien
// SMSMOE006
// 14 October
// Fruit.java - User-friendly version

import java.util.*;

public class Fruit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Fruit Fly Shipment Calculator ===");
        System.out.print("Enter the number of boxes (N): ");
        long N = sc.nextLong();

        System.out.print("Enter the number of flies per box (M): ");
        long M = sc.nextLong();

        System.out.print("Enter the number of days before shipping (D): ");
        int D = sc.nextInt();

        TreeMap<Long, Long> diff = new TreeMap<>();

        System.out.println("\nNow enter the daily expiration data:");
        System.out.println("(Format: A B L)  — boxes A to B lose L flies each day");
        for (int i = 1; i <= D; i++) {
            System.out.print("Day " + i + ": ");
            long A = sc.nextLong();
            long B = sc.nextLong();
            long L = sc.nextLong();

            diff.put(A, diff.getOrDefault(A, 0L) - L);
            diff.put(B + 1, diff.getOrDefault(B + 1, 0L) + L);
        }

        System.out.print("\nEnter the number of flies to ship (P): ");
        long P = sc.nextLong();

        System.out.println("\nCalculating remaining flies and minimum boxes needed...");
        long total = 0;
        long current = M;
        long prevIndex = 1;

        for (Map.Entry<Long, Long> e : diff.entrySet()) {
            long index = e.getKey();
            long count = index - prevIndex;
            long segmentFlies = count * current;

            System.out.println("Boxes " + prevIndex + " to " + (index - 1) +
                               " each have " + current + " flies -> +" + segmentFlies + " total");

            total += segmentFlies;

            if (total >= P) {
                long excess = total - P;
                long usedBoxes = count - (excess + current - 1) / current;
                long result = prevIndex + usedBoxes - 1;

                System.out.println("------------------------------------------");
                System.out.println("Total flies reached: " + total);
                System.out.println("Minimum boxes required (W): " + result);
                System.out.println("==========================================");
                return;
            }

            current += e.getValue();
            prevIndex = index;
        }

        System.out.println("All boxes needed -> W = " + N);
    }
}
