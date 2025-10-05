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

        System.out.print("Enter Number of items in the list:\n");
        int N = sc.nextInt();
        
        int[] numbers = new int[N];
        System.out.print("Enter Elements:\n");
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        
        System.out.print("Enter (T)arget Number:\n");
        int T = sc.nextInt();

        // Recursive version call
        int recursiveResult = recursiveMax(numbers, T, 0, 1);  // start with score = 1
        System.out.println("Sample output (Recursion):\n" + recursiveResult);

        // Iterative version call
        int loopResult = Loop(numbers, T);
        System.out.println("Sample output (Loop):\n" + loopResult);

        sc.close();
    }


    // RECURSIVE VERSION

    /*
     * recursiveMax():
     * This recursive function explores all combinations of + and * operations
     * which is applied to the list, keeping track of the current score.
     * It returns the highest score achieved that is still less than T.

     */
    public static int recursiveMax(int[] numbers, int T, int index, int currentScore) {
        // Base case
                if (index == numbers.length) {
            return (currentScore < T) ? currentScore : 0;
        }

        // Option 1: Add the next number
        int addResult = recursiveMax(numbers, T, index + 1, currentScore + numbers[index]);

        // Option 2: Multiply by the next number
        int multResult = recursiveMax(numbers, T, index + 1, currentScore * numbers[index]);

        // Return the better of the two (closest to T but still < T)
        int best = 0;
        if (addResult < T && addResult > best) best = addResult;
        if (multResult < T && multResult > best) best = multResult;

        return best;
    }


    // ITERATIVE VERSION
    /*
     * Loop():
     * Iteratively explores additions and multiplications
     * to approximate the highest achievable score under T.
     * (This version is less exhaustive but shows iterative logic.)
     */
    public static int Loop(int[] N, int T) {
        int highest = 0;
        int score = 1;
        int total = 0;
        int add = score;
        int multiply = score;

        for (int i = 0; i < N.length; i++) {
            add += N[i];
            multiply *=  N[i];
            int had = add_multiply(N, add, T, i);
            int hmu = add_multiply(N, multiply, T, i);
            total = Math.max(had, hmu);
            
            if (had >= T)
            {
             total = hmu;
            }
            if (hmu >= T)
            { total = had;}
            
             
            

            if (total >= T) {
               continue;
            }

            if (total > highest) {
                highest = total;
            }
        }
        return highest;
    }

    /*
     * add_multiply():
     * Simulates a sequence of additions and multiplications,
     * checking that no intermediate result exceeds T.
     */
    public static int add_multiply(int[] N, int value, int T, int j) {
        for (int i = j; i < N.length; i++) {
            if ((value * N[i]) < T) {
                value *= N[i];
            } else if (((value + N[i]) > T) && ((j + 1) >= N.length)) {
                return 0;
            } else {
                value += N[i];
            }
        }
        return value;
    }
}
