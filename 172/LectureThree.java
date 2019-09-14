/* lecture 3
Thomas Sanchez
Aug 23, 2018
calc are of a rectangle with input length and width
*/
import java.util.Scanner;
class LectureThree{
   
   public static void main(String[] args){
      
      Scanner scnr = new Scanner(System.in);
      
      double length, height;
      double width;
      double area, volume;
      
      System.out.printf("Please input length:");
      length = scnr.nextDouble();
      System.out.printf("You put %f as length \n", length);
      
      System.out.printf("Please input width:");
      width = scnr.nextDouble();
      System.out.printf("You put %f as width \n", width);
      
      System.out.printf("Please input height:");
      height = scnr.nextDouble();
      System.out.printf("You put %f as height \n", height);
      
      // calc area and vol
      area = length * width;
      volume = area * height;
      
      System.out.printf("The area is %6.2f\n", area);
      System.out.printf("The volume is %6.2f\n", volume);
   // not in lecture
   while(area < 20){
   System.out.println(area);
   area = area + 1; 
   }// of while area
   
   }// of main

}// of class lecture3