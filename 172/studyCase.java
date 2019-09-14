
import java.util.Scanner;
class studyCase{
   public static void main(String[] args){
   
   Scanner scan = new Scanner(System.in);
   int num;
   
   System.out.println("Type 1 for easy, 2 for medium, and 3 for hard.");
   num = scan.nextInt();
   
   switch(num){
   
   case 1: 
      System.out.println("you chose easy");
   break;
   case 2:
      System.out.println("you chose medium");
   break;
   case 3:
      System.out.println("you chose hard");
   break;
   
   default: System.out.println("this is not a difficulty");
    }  



}// of main

}//of class