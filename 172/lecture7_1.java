// Thomas Sanchez
//lecture7_1 program
//sept 6 2018

import java.util.Scanner;

class lecture7_1{
   public static void main(String[] args){
   
   String info; 
   Scanner scnr = new Scanner(System.in);
   
   System.out.println("Enter a line of info \n");
   info = scnr.nextLine();
   
   if (info.indexOf('M') == -1){
      System.out.println("You need to have an M");
   }// of if info
   else{System.out.println("Good job info is good");}// of else info
   
   
   }// of main


}