//output last first and numbers

import java.util.Scanner;
class parsing_1{
   public static void main(String[] args){
   
      Scanner scan = new Scanner(System.in);
      String S = "Cooper, Shaun 34 56 78";
      
      
      while(true){
      
      System.out.println("enter a line, blank to quit");
      S = scan.nextLine();
      
      if(S.length() == 0) break;
      
      PrintIt(S);
      
     }// of while
   
   }// of main
   
   public static void PrintIt(String A){
   
      String lName, fName;
      int N1, N2, N3, holdindex, nextindex;
      double average;
   
      // pull out components
      
      holdindex = A.indexOf(' ') + 1;
      nextindex = A.indexOf(' ', holdindex);
      
      lName = A.substring(0, A.indexOf(','));
      
      fName = A.substring(holdindex, nextindex); 
      
      holdindex = nextindex + 1;
      nextindex = A.indexOf(' ', holdindex);
      
      N1 = Integer.parseInt(A.substring(holdindex, nextindex));
      
      holdindex = nextindex + 1;
      nextindex = A.indexOf(' ', holdindex);
      
      N2 = Integer.parseInt(A.substring(holdindex, nextindex));
      
      holdindex = nextindex + 1;
      
      
      N3 = Integer.parseInt(A.substring(holdindex));
      
      average = (N1 + N2 + N3) / 3.0;
      
      System.out.printf("%-20s %-20s %30.2f\n", lName, fName, average);
   //minus sign equals left justify 
   
   
   }// of printit

}