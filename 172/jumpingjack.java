//jumping jacks

import java.util.Scanner;
class jumpingjack{

   public static void main(String[] args){
   int rows, col;
   Scanner scan = new Scanner(System.in);
   
   System.out.println("Enter the number of rows ");
   rows = scan.nextInt();
   
   System.out.println("Ether the number of columns");
   col = scan.nextInt();
   
  for(int j = 1; j <= rows; j++){
  System.out.printf("%2d", j);
   for(int i = 2; i<= col; i++){
   
      System.out.printf(" %2d", i);
   
   }// of for i
   System.out.println("");
  }// of for j
   }// of main

}