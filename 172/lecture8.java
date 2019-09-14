
import java.util.Scanner;
class lecture8{
   public static void main(String[] args){
   
      int space;
      String s;
      Scanner scan = new Scanner(System.in);
   
      System.out.println("Enter a line of input");
      s = scan.nextLine();
   
      System.out.println("You inputted " + s);
      s = s.trim();
   
      space = s.indexOf(' ');
   
      if(space == -1){ // there is no spaces
         System.out.println("You printed " + s + " first");
         }//if space
      
      else // there is atleast one space
         System.out.println("You inputted " + s.substring(0, space) + " first");
   
   }// of main


}// of class