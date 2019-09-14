//ask the user if a number is in a list
//linear search
import java.util.Scanner;
class lectrue20_1{

   public static void main(String args[]){
   
   Scanner scan = new Scanner(System.in);
   int num;
   int A[] = {8, 9, 5, 7, 6};
   boolean found = false;
   
   
   System.out.println("Enter a number, 0 to end");
   num = scan.nextInt();
   
   while(num != 0){
   
   
   for(int i = 0; i < A.length; i++)
      if(A[i] == num) found = true;       //change to .equals for strings
   
   if(found) System.out.println("Found it");
   
   else System.out.println("Not found");
   
   found = false;
   System.out.println("Enter a number, 0 to end");
   num = scan.nextInt();
   }
   
   }// of main

}// of class