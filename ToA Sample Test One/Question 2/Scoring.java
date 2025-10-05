import java.util.Scanner;

public class Scoring {
/*
Problem
List N (Positive numbers)
target score (T)
Score = 1 (start)
List can + or *
Target is to find maximum score that achieved less than T

Input structure
 Number in the list 
    *
    *
    *
 Target
*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();              // number of elements
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {      // input numbers
            numbers[i] = sc.nextInt();
        }

        int T = sc.nextInt();              // input target

        // Recursive version call
        //int recursiveResult = recursiveMax(numbers, T, 0, 1);  // start with score = 1
        //System.out.println(recursiveResult);
        
        int Result = Loop(numbers, T);
        System.out.println(Result);

        sc.close();
    }

    // -------------------------------------------------------------------
    // RECURSIVE VERSION
    // -------------------------------------------------------------------
    /*
     * recursiveMax():
     * This recursive function explores all combinations of + and * operations
     * applied to the list, keeping track of the current score.
     * It returns the highest score achieved that is still less than T.
     *
     * Parameters:
     *  - numbers: input array
     *  - T: target score
     *  - index: current position in list
     *  - currentScore: current cumulative score
     */
    public static int recursiveMax(int[] numbers, int T, int index, int currentScore) {
        // Stop if score already >= T (pruning)
        if (currentScore >= T) {
            return 0;
        }

        // Base case: if we've processed all numbers
        if (index == numbers.length) {
            return currentScore;
        }

        // Option 1: Add the next number
        int addResult = recursiveMax(numbers, T, index + 1, currentScore + numbers[index]);

        // Option 2: Multiply by the next number
        int multResult = recursiveMax(numbers, T, index + 1, currentScore * numbers[index]);

        // Return the best valid result
        return Math.max(addResult, multResult);
    }

    // -------------------------------------------------------------------
    // ITERATIVE VERSION (kept for comparison, not used in grading)
    // -------------------------------------------------------------------
    /*
     * Loop():
     * Iteratively explores additions and multiplications
     * to approximate the highest achievable score under T.
     * (This version is less exhaustive but shows iterative logic.)
     */
    public static int Loop(int[] numbers, int T) {
    //it goes from 0 - T and check if sum or total of the numbers is capable of reaching the value
    boolean[] reachable = new boolean[T];  // reachable[s] = true if score s is achievable
    reachable[1] = true; // starting score

    for (int num : numbers) {
        boolean[] next = new boolean[T];
        for (int s = 0; s < T; s++) {
            if (reachable[s]) {
                if (s + num < T) next[s + num] = true;
                if (s * num < T) next[s * num] = true;
            }
        }
        reachable = next;
    }

    // Find the maximum achievable score < T
    for (int i = T - 1; i >= 0; i--) {
        if (reachable[i]) return i;
    }

    return 0; // fallback (should not happen)
}
}
