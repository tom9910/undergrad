import java.util.Scanner;
class temp{
   public static void main(String[] args){
   Scanner scan = new Scanner(System.in);
   double temp;
   double steam = 100;
   double ice = 0;
   
   System.out.println("Enter the H20 temperature in celcius");
   temp = scan.nextDouble();
   
   if(temp > steam){
      System.out.println("The H20 is steam");
   }
   else if(temp <= steam && temp >= ice)
      System.out.println("The h20 is liquid");
   
   else if(temp < ice)
      System.out.println("the h20 is ice");
   
   
   
   }
}