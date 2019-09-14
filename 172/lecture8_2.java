
import java.util.Scanner;
class lecture8_2{
   public static void main(String[] args){
   
   int num;
   Scanner scan = new Scanner(System.in);
   
   System.out.println("enter a number");
   num = scan.nextInt();
   
   System.out.println("you entered: " + num);
   
   switch(num){
   
   case 1: System.out.println("red");
      break;
   case 2: System.out.println("yellow");
      break;
   case 3: System.out.println("green");
      break;
   case 4: System.out.println("purple");
      break;
   
   default: System.out.println("num needs to be between 1 and 3");
   
   }// switch
   
   
   }// of main
}// of class
