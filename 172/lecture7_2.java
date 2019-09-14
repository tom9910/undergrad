import java.util.Scanner;

class lecture7_2{

   public static void main(String[] args){
   
   Scanner userInput = new Scanner(System.in);
   int i; 
   
   System.out.println("Enter a number");
   i = userInput.nextInt();
   
   while(i > 0){
      if (i < 10)
         System.out.println("Too close");
      else if (i < 20)
         System.out.println("just right");
      else
         System.out.println("Too far");
         
    System.out.println("Enter a new number");
    i = userInput.nextInt();
         
   }// of while
   System.out.println("your number is invaild");
   
   }// of main
   }