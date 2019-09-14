import java.util.Scanner;
class arrayreverse{

   public static void main(String[] args){
   
   int[] dValues = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
   
   int len;
   
   for(int i = 0; i < dValues.length; i++){
      int tempVal = dValues[i];
      dValues[i] = dValues[dValues.length - i - 1];
      dValues[dValues.length - i - 1] = tempVal;
      
      System.out.println(dValues[tempVal - 1]);
   
   }// for i
  
   
   
   }// main

}//of class