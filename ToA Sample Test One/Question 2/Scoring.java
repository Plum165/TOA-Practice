import java.util.Scanner;

//Moegamat Samsodien
//5 October 2025

public class Scoring {
/*
Problem:
Given a list of positive numbers and a target score T,
starting with score = 1, we can either add or multiply
each number in the list in sequence. The goal is to find
the maximum score achievable that is less than T.

Input structure:
- Number of elements in the list
- List of elements
- Target score T
*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Scoring Problem ===");
        System.out.print("Enter number of items in the list: ");
        int N = sc.nextInt();

        int[] numbers = new int[N];
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < N; i++) {
            System.out.print("Element " + (i+1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.print("Enter the target number (T): ");
        int T = sc.nextInt();

        // ------------------------
        // Recursive version
        // ------------------------
        int recursiveResult = recursiveMax(numbers, T, 0, 1); // start with score = 1
        System.out.println("\nSample output (Recursion): " + recursiveResult);

        // ------------------------
        // Iterative version
        // ------------------------
        int loopResult = Loop(numbers, T);
        System.out.println("Sample output (Loop): " + loopResult);

        sc.close();
    }

    // -------------------------------------------------------------------
    // RECURSIVE VERSION
    // -------------------------------------------------------------------
    /*
     * recursiveMax():
     * Recursively explores all possible + and * operations on the list,
     * keeping track of the current score. Returns the highest valid score
     * < T.
     */
    public static int recursiveMax(int[] numbers, int T, int index, int currentScore) {
        // Stop if current score exceeds target
        if (currentScore >= T) return 0;

        // Base case: all numbers processed
        if (index == numbers.length) return currentScore;

        // Option 1: Add next number
        int addResult = recursiveMax(numbers, T, index + 1, currentScore + numbers[index]);

        // Option 2: Multiply by next number
        int multResult = recursiveMax(numbers, T, index + 1, currentScore * numbers[index]);

        // Return the higher of the two
        return Math.max(addResult, multResult);
    }

    // -------------------------------------------------------------------
    // ITERATIVE VERSION
    // -------------------------------------------------------------------
    /*
     * Loop():
     * Iteratively finds maximum achievable score under T using
     * additions and multiplications. Fully exhaustive via DP array.
     */
    public static int Loop(int[] numbers, int T) {
        boolean[] reachable = new boolean[T]; // reachable[s] = true if score s is achievable
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

        return 0; // fallback
    }
}
