import java.util.Scanner;

class quadraticformula{
public static void main(String[] args){
  
   Scanner scnr = new Scanner(System.in);
   double a;
   double b;
   double c;
   double factorPos; 
   double factorNeg;
   
   System.out.println("enter a");
   a = scnr.nextDouble();
   
   System.out.println("enter b");
   b = scnr.nextDouble();
   
   System.out.println("enter c");
   c = scnr.nextDouble();
   
   factorPos = ((b - b*2) + (Math.sqrt((b * b)+ (4.0 * a * c)))) / 2.0 * a; 
   factorNeg = ((b - b*2) - (Math.sqrt((b * b)+ (4.0 * a * c)))) / 2.0 * a;
   
   System.out.printf("Your first factor is %5.5f and your second is %5.5f", factorPos, factorNeg);

}// of main

}