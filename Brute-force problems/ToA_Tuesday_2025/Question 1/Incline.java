import java.util.Scanner;
import java.util.ArrayList;
//SMSMOE006
//Moegamat Samsodien
public class Incline
{
   public static void main(String[] args)
   {
     // ArrayList<Integer> temp = new ArrayList<>;
      Scanner sc = new Scanner(System.in);
     System.out.println("Enter the length of Array of numbers:");
      int length = sc.nextInt();
  System.out.println("Enter the elements:");
      int[] numbers = new int[length];
      for (int i = 0 ; i < length; i++)
        {
           numbers[i] = sc.nextInt();
   
        }
      int count = 0;
      int highest = 0;
      System.out.println("Longest chain found:");
      for (int j = 0 ; j < length-1; j++)
      {
    // System.out.println(numbers[j] + " " + numbers[j+1]);
     //System.out.println(numbers[j] < numbers[j+1]);
         if (numbers[j] < numbers[j+1])
         {
            count++;
           // System.out.println(count);
         }
         else{

//2 3 1 1 5 6 
         if (highest < count) 
         {highest = count ;
         //System.out.println("here! " + highest);
         }
         
          count = 0;
          
         }
      }
      if (highest < count) 
         {highest = count +1 ;
         //System.out.println("here! " + highest);
         }
         else{

      highest++;}
      System.out.println(highest);
      
   }
}