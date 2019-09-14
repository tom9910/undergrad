
import java.util.Scanner;
class stringsStudy{
   public static void main(String[] args){
   String S;
   Scanner scan = new Scanner(System.in);
   
   
   System.out.println("Enter a string:");
   S = scan.nextLine();
   
   System.out.println(S.replace('b', 'e'));
   System.out.println(S.charAt(S.length()/2));
   System.out.println(S.length());
   
   }

}