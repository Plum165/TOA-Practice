// Moegamat Rashaad Samsodien
// SMSMOE006
// 14 October

import java.util.*;

public class Fruit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();   // number of boxes
        long M = sc.nextLong();   // flies per box
        int D = sc.nextInt();     // number of days

        // difference map to record changes efficiently
        TreeMap<Long, Long> diff = new TreeMap<>();

        for (int i = 0; i < D; i++) {
            long A = sc.nextLong();
            long B = sc.nextLong();
            long L = sc.nextLong();

            diff.put(A, diff.getOrDefault(A, 0L) - L);
            diff.put(B + 1, diff.getOrDefault(B + 1, 0L) + L);
        }

        long P = sc.nextLong();  // required flies

        long total = 0;
        long current = M;  // current number of flies per box
        long prevIndex = 1;

        // Traverse through change points
        for (Map.Entry<Long, Long> e : diff.entrySet()) {
            long index = e.getKey();
            long count = index - prevIndex;  // boxes with same fly count
            long segmentFlies = count * current;
            total += segmentFlies;

            if (total >= P) {
                // compute minimal W precisely
                long excess = total - P;
                long usedBoxes = count - (excess + current - 1) / current;
                System.out.println(prevIndex + usedBoxes - 1);
                return;
            }

            current += e.getValue(); // update flies per box
            prevIndex = index;
        }

        // If we reach here, it means we use all boxes
        System.out.println(N);
    }
}
