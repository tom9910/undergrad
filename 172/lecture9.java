//lecture 9
import java.util.Scanner;
class lecture9{
   public static void main(String[] args){
   
   Scanner scan = new Scanner(System.in);
   String s;
   
   System.out.println("Enter your string: ");
   s = scan.nextLine();
   
   System.out.println(s.toUpperCase());
   System.out.println(s.replace('B', 'D'));
   System.out.println(s.charAt(s.length()-1));
   System.out.println(s.charAt(0));
   System.out.println(s.charAt(s.length() / 2));
   
   //not in lecture
   switch (s){
   case ("hello computer"):
   System.out.println("Hello tommy");
   break;
   case ("bye computer"):
   System.out.println("bye tommy");
   
   default:
   System.out.println("good string"); 
   
   }//switch
   
   }// of main
}// of class