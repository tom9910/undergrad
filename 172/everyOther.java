import java.util.Scanner;
class everyOther{
   public static void main(String[] args){
   
   Scanner scan = new Scanner(System.in);
   String str;
   
   System.out.println("Enter a string:");
   str = scan.nextLine();
   
   for(int i = 0; i < str.length(); i = i+2){ 
   
      System.out.print(str.charAt(i));
   
   }// of for
   
   }// of main

}