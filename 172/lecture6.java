
import java.util.Scanner;

class lecture6{

   public static void main(String[] args){
   
   double result;
   int iresult;
   
   int range, offset;
   
   Scanner scnr = new Scanner(System.in);
   
   System.out.println("give me the range");
   range = scnr.nextInt();
   System.out.println("give me the offset");
   offset = scnr.nextInt();
   
   result = Math.random() * range + offset; //multiply for range then add or sub for offset
   
   iresult = (int) result;

   System.out.println(iresult + " " + result);
   }// of main

}// of class