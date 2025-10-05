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
        for (int i =0; i < N ; i++)
        {
        numbers[i] = sc.nextInt();
        
        }
        
        System.out.print("Enter (T)arget Number:\n");
        int T = sc.nextInt();
        

       // int countRecursive = countRecursive(N, Z, 1, 1);
       //System.out.println("Sample output(Recursion):\n " + countRecursive);

        int highLoop = Loop(numbers, T);
        System.out.println("Sample output(Loop):\n" + highLoop);

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
    public static int Loop(int[] N, int T) {
        int highest = 0;
        int score = 1;
        int add = score + 0;
        int multiply = score*1;
        int total = 0;

        for (int i = 0 ; i < N.length ; i++) {
           add  +=  N[i];
           multiply *= N[i]; 
           for (int j = i ; j < N.length ; j++)   
           {       
           int had = add_multiply(N ,add, T, j);
           int hmu = add_multiply(N ,multiply, T, j);
           if (had > hmu)
           {
             total = had;
            
           }
           else  total = hmu;

             if (total > T)
            {
             break;
            }
           }
            if (total > highest) 
            {
             highest = total;
            }
           

        }
        return highest;
    }
    
  public static int add_multiply(int[] N , int value,int T,int j)
{
   for (int i = j ; i < N.length ; i++)
   {
    if ((value*N[j]) < T)
    {
      value *= N[j];
    }
    else if (((value + N[j]) > T) && ((j + 1 ) >= N.length)){
    return 0;
    }
    else value += N[j];
   }
   
   return value;
}
}
