//thomas sanchez
//volume of a cylinder
import java.util.Scanner;
class cylinder{
   public static void main(String[] args){
   
   double volume, height, diameter, radius;
   Scanner scan = new Scanner(System.in);
   
   System.out.println("enter a volume");
   volume = scan.nextDouble();
   
   System.out.println("enter a height");
   height = scan.nextDouble();
   
   radius = Math.sqrt(((volume/height)/Math.PI));
   diameter = 2.0 * radius;
   
   System.out.printf("the diameter is %5.3f\n", diameter);   
   
   }//of main

} 