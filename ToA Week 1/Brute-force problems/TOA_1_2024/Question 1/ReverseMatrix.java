import java.util.Scanner;

//Moegamat Samsodien
//6 October 2025

public class ReverseMatrix {
/*
Problem:
Given an n x m matrix of integers
The program that rotates the matrix by 180 degrees. 
*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      //Collecting information of the matirix

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
           
            matrix[i][j] = sc.nextInt();}
          
        }
        
        //Reversing the matrix


        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--){
           if (j != 0){
            System.out.print(matrix[i][j]+ " ") ;
            }
            else System.out.print(matrix[i][j]);
            }
          System.out.println();
        }
        
        sc.close();
    }
}
