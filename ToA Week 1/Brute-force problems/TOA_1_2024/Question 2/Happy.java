import java.util.Scanner;
import java.util.ArrayList;

//Moegamat Samsodien
//6 October 2025

public class Happy {
/*
Problem: Largest Left-Truncatable Happy Number Below N 
A positive integer is called happy if the following process eventually reaches 1: 
• Replace the number by the sum of the squares of its digits. 
• Repeat the process until either the number becomes 1 (happy) or it cycles endlessly without reaching 1 
(unhappy). 
For example: 
 19 is happy because 12 + 92 = 82, then 82  + 22    = 68, then 62 + 82   =100, 
then 12  + 02  + 02 = 1. 
 4 is unhappy because it cycles through 4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4 and never reaches 1.
*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      //Collecting information of the matirix
        System.out.println("===  Largest Left-Truncatable Happy Number ===");
        System.out.print("Enter the integer:\n");
        int N = sc.nextInt();
       
       


        
        //Reverse the loop so we can check for largest number first and breaks if it found
        System.out.print("The Largest Left-Truncatable Happy Number:\n");
        for (int i = N-1 ; i >= 0 ; i--)
        {
        if (happy_number(i)){
        System.out.println(i);
        break;
        }
         }      
        sc.close();
    }
    
  /*
  add(element): Adds an element to the end of the list.
add(index, element): Inserts an element at a specific index.
remove(element): Removes the first occurrence of a specified element.
remove(index): Removes the element at a specific index.
get(index): Retrieves the element at a specific index.
set(index, element): Replaces the element at a specific index.
size(): Returns the number of elements in the list.
  */
   public static boolean happy_number(int Num)
   {
      ArrayList<Integer> values = new ArrayList<>();
      boolean flag = true;
      String num = Integer.toString(Num);
      for (int i =0; i < num.length(); i++)
      {
         String sub = num.substring(i, num.length()); 
         
         
         while (true)
         {  
         
            int add = 0;
           for (char c : sub.toCharArray()) {
                int n = Character.getNumericValue(c);
                add += n * n;
                     }
            if (add == 1)
            {
             break;
            }
            if (values.contains(add))
            {
             return false;
           
            }
            values.add(add);
            sub = Integer.toString(add);
         }
         values.clear();
       
      
      }
      return true;
   }
}
