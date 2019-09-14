import java.util.Scanner;
class studty2{
   public static void main(String[] args){
   
   Scanner scan = new Scanner(System.in);
   double volume, height, radius, diameter;
   
   System.out.println("Enter the volume of the cylinder.");
   volume = scan.nextDouble();
   
   System.out.println("Enter the height of the cylinder");
   height = scan.nextDouble();
   
   radius = Math.sqrt(volume/(height * Math.PI));
   diameter = radius + radius;
   
   System.out.printf("The diameter of the cylinder is: %5.3f", diameter);
   
   
   }// of main


}