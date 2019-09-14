//lecture 11
import java.util.Scanner;
class lecture11_1{

public static void main(String[] args){
   
   Scanner scan = new Scanner(System.in);
   String s;
   int scount = 0;
   int aecount = 0;
   
   System.out.println("Enter a string");
   s = scan.nextLine();
   
   for(int i = 0; i < s.length(); i++){
   
      switch(s.charAt(i)){
      case ' ': scount++;
      break;
      
      case 'a': aecount++;
      break;
      
      case 'e': aecount++;
      break;
      
      }//of switch
      
   }
   
   for(int i = s.length() - 1; i >= 0; i--){
   System.out.print(s.charAt(i));
   }
   System.out.println("");
   System.out.println("number of spaces are " + scount);
   System.out.println("number of a and e chars are " + aecount);

}// of main

}