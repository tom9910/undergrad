
import java.util.Scanner;
class three{
   public static void main(String[] args){
   
   Scanner scan = new Scanner(System.in); 
          System.out.println("Enter the number of lines"); 
          int n = scan.nextInt(), i; 
          String spaces = ""; 
          String stars = "**************************************************";

   for(i = n; i>0; i--){
      System.out.print(spaces);
      System.out.println(stars.substring(0,i));
      spaces = spaces + " ";
      
      
   
   }// of for
   
   
   }// of main

}