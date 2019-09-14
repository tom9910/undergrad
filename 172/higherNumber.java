import java.util.Scanner;
import java.util.Random;
public class higherNumber {
	
	public static void main(String[] args) {
		
		System.out.println("Type the integer one higher than the given. ");
		
		Random rand = new Random();
		Scanner scnr = new Scanner(System.in);
		
      boolean play = true;
		String again;
      
		int count = 0;
		
      while(play){
		 
		boolean right = true;
      
      while(right){
         int num = rand.nextInt(301);
         int answer;
         System.out.printf("The number is %2d", num);
         answer = scnr.nextInt();
         
         if(answer == num + 1){
         System.out.println("Youre right");
         count = count + 1;
      
      }// of if answer
         else{
         System.out.printf("Wrong, you got %d right in a row \n", count);
         count = 0;
         right = false;
         }// of else answer
      
      }// of while right
		
      System.out.println("if you want to play again type y if not n:");
      again = scnr.next();
      if(again.equalsIgnoreCase("y")){play = true;}// of if play
      else{
      play = false;
      System.out.println("Thanks for playing!");
      System.out.print("Xenorbit production.");
      }// of else play
      
    }// of while play  
		
	}// of main
}