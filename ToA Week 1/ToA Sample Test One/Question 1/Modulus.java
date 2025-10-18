import java.util.Scanner;

//Moegamat Samsodien
//5 October 2025

public class Modulus {
// (N,Z)
//loop through N then through Z
//if X > 0  and Y < N
    // if (X*Y) modulus N == Z
        // count ++
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N (positive integer): ");
        int N = sc.nextInt();
        System.out.print("Enter Z (non-negative integer): ");
        int Z = sc.nextInt();

        int countRecursive = countRecursive(N, Z, 1, 1);
        System.out.println("Number of valid pairs (Recursive): " + countRecursive);

        int countLoop = countLoop(N, Z);
        System.out.println("Number of valid pairs (Loop): " + countLoop);

        sc.close();
    }

    // Recursive version
    public static int countRecursive(int N, int Z, int X, int Y) {
        if (X >= N) {
            return 0; // stop when X exceeds N-1
        }

        // move to next row when Y reaches N
        if (Y >= N) {
            return countRecursive(N, Z, X + 1, 1);
        }

        // count if (X * Y) % N == Z
        int add = ((X * Y) % N == Z) ? 1 : 0;

        // move to next Y
        return add + countRecursive(N, Z, X, Y + 1);
    }

    // Iterative version
    public static int countLoop(int N, int Z) {
        int count = 0;

        for (int X = 1; X < N; X++) {
            for (int Y = 1; Y < N; Y++) {
                if ((X * Y) % N == Z) {
                    count++;
                }
            }
        }
        return count;
    }
}
