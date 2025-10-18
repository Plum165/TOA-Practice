import java.util.Scanner;
public class Cycling{
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      System.out.println("The numnber of signs(N):");
      int N = sc.nextInt();
      int[] signs = new int[N];
      System.out.println("Enter the signs:");
      for (int i = 0; i < N ; i++){
         signs[i] = sc.nextInt();
         //System.out.println(signs[i]);
      }
      
      
      System.out.println("The maximum point score that can be achieved: " + point_values(signs, N));
   }
   
   public static int point_values(int[] signs,int N){
      int max = 0;
  
         
         for (int i = 0; i < N ; i++){
         int sum = 0;
            for (int j = i; j < N; j++){
            // System.out.println(signs[i] + " " + sum);
            sum += signs[j];
            //System.out.println(sum);
            if (sum > max)
            {
             max = sum;
            }
           }
         }
        return max; 
   
      
   
   }
}