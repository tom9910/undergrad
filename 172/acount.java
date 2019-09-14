import java.util.Scanner;
class acount{

public static void main(String[] args){
  
   Scanner scan = new Scanner(System.in);
   String str;

   int acount = 0;
  
   System.out.println("Enter a string");
   str = scan.nextLine();
  
   for(int i = 0; i < str.length(); i++){
  
      switch(str.charAt(i)){
      
     
      case 'a': acount++;
      break;
        
      }//of switch
     
   }
   
   System.out.println("number of a chars are " + acount);

}// of main

}
