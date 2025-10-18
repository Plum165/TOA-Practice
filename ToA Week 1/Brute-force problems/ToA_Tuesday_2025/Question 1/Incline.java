import java.util.Scanner;
import java.util.ArrayList;
//SMSMOE006
//Moegamat Samsodien
public class Incline
{
   public static void main(String[] args)
   {

      Scanner sc = new Scanner(System.in);

      int length = sc.nextInt();

      int[] numbers = new int[length];
      for (int i = 0 ; i < length; i++)
        {
           numbers[i] = sc.nextInt();
   
        }
      int count = 0;
      int highest = 0;
      for (int j = 0 ; j < length-1; j++)
      {

         if (numbers[j] < numbers[j+1])
         {
            count++;
          
         }
         else{


         if (highest < count) 
         {highest = count ;
     
         }
         
          count = 0;
          
         }
      }
      if (highest < count) 
         {highest = count +1 ;
      
         }
         else{

      highest++;}
      System.out.println(highest);
      
   }
}