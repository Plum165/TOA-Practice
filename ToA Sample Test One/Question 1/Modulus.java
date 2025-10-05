import java.util.Scanner;
//Brute force question
public class Modulus {
// (N,Z)
//loop through N then through Z
//if X > 0  and Y < N
    // if (X*Y) modulus N == Z
        // count ++
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sample Input:");
        
//Sample input
        
        int N = sc.nextInt();
        if (!(N >= 1 && N <= 1000))
        {
        System.out.println("Error N not within bounds");
        }
        
        int Z = sc.nextInt();
        if (!(Z >= 0 && Z < N)){
        System.out.println("Error Z not within bounds");
        }
        
        
        //you can just comment one of the functions to test them for the automarker

        int count = countRecursive(N, Z, 1, 1); // Recursive function
        //int count = countLoop(N, Z); //Loop function
        System.out.println("Sample output:\n" + count);


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
