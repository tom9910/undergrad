import java.util.Scanner;
class lecture8_1{
   public static void main(String[] args){
   
   int num;
   Scanner scan = new Scanner(System.in);
   
   System.out.println("enter a number");
   num = scan.nextInt();
   
   System.out.println("you entered: " + num);
   
   if(num == 1){
   System.out.println("red");
   }
   
   else if(num == 2){
   System.out.println("yellow");
   }
   
   else if(num == 3){
   System.out.println("green");
   }
   
   else
   System.out.println("num needs to be between 1 and 3");
   
   
   
   }// of main
}// of class