//output last first and numbers

import java.util.Scanner;
class parsing{
   public static void main(String[] args){
   
      String S = "Cooper, Shaun 34 56 78";
      String lName, fName;
      int N1, N2, N3, holdindex, nextindex;
      double average;
      
      // pull out components
      
      holdindex = S.indexOf(' ') + 1;
      nextindex = S.indexOf(' ', holdindex);
      
      lName = S.substring(0, S.indexOf(','));
      
      fName = S.substring(holdindex, nextindex); 
      
      holdindex = nextindex + 1;
      nextindex = S.indexOf(' ', holdindex);
      
      N1 = Integer.parseInt(S.substring(holdindex, nextindex));
      
      holdindex = nextindex + 1;
      nextindex = S.indexOf(' ', holdindex);
      
      N2 = Integer.parseInt(S.substring(holdindex, nextindex));
      
      holdindex = nextindex + 1;
      
      
      N3 = Integer.parseInt(S.substring(holdindex));
      
      average = (N1 + N2 + N3) / 3.0;
      
      System.out.printf("%-20s %-20s %30.2f\n", lName, fName, average);
   //minus sign equals left justify 
   
     
   
   }// of main

}