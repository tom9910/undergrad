//Thomas Sanchez
//Sept 30, 2018
//Lab4
//Answer 7 questions

import java.util.Scanner;
class lab4{
   public static void main(String[] args){
   
   Scanner scan = new Scanner(System.in);
   
   //Question 1
   // Print all odd numbers from 1 - 99
   
   int odd;// declare odd variable
   System.out.println("***Question 1 print all odd numbers from 1 - 99:***");
   for(odd = 1; odd <= 99; odd++){  //determine if odd is less then or equal to 99
      if(odd % 2 !=0){  //determine if odd remadiner = 0
         System.out.println(odd); // print odd
     }// of if odd
   }// of for odd
   
   System.out.println("");
   
   //Question 2
   // print an asterik triangle
   
   int size;
   int length; //declare variables
   
   System.out.println("***Question 2 print a triangle of asteriks based on user input***");
   System.out.println("Enter a triangle size from 1-50");
   size = scan.nextInt(); //ask for triangle size
   scan.nextLine(); //clear input
   if(size >= 1 && size <= 50){    //check size inbetween 1 and 50
   
      for(size = size; size > 0; size = size - 1){ //make sure size < 0 and subtract 1
         
         for(length = size; length > 0; length = length - 1){ //length = size make sure less then zero subtract 1
         
         System.out.print("*"); //print *
         
         }// of for length
         
         System.out.print("\n"); //make newline
      
      }// of for size
   }//of if
   else
   System.out.println("invalid input");
   
   
   //question 3
   // print an inputted string backwords
   System.out.println("***Question 3 print an inputted string backwards***");
   String b;  //declare variable
   
   
   System.out.println("Enter a string:");
   b = scan.nextLine();    //ask for a string
   
   
      for(int r = b.length()-1; r >= 0; r--){     //start are at last index and go back one
      
         System.out.print(" " + b.charAt(r)); //print character
      
      }// for r
      
   System.out.print("\n");
   
   //question 4
   //get the highest of 10 int values
   System.out.println("***Question 4 get the highest value of 10 inputted numbers***");
   
   int num;
   int high; 
   
   high = 0;
   num = 0; //declare variables
   
   
   System.out.println("Enter ten numbers:");
   for(int i = 0; i < 10; i++){  //loop ten times
   
      num = scan.nextInt();  //ask for numbers
      
      if(high == 0)
         high = num; //so all negatives work
         
      
      if(num > high)
         high = num;  //save highest input
   
   }// of for i
   System.out.printf("The highest number you entered was %2d \n" , high); //print highest
   scan.nextLine();
   
   //question 5
   //ask for a string and count vowels
   System.out.println("*** Question 5 ask for a string and count the vowles***");
   
   String line;
   int countA = 0; 
   int countE = 0; 
   int countO = 0; 
   int countU = 0; 
   int countI = 0; //declare variables
   
   System.out.println("Enter a string:");
   line = scan.nextLine();
   
   for(int i = 0; i <= line.length() - 1; i++){
   
   switch(line.charAt(i)){
   
      case 'a': countA++; break;
      case 'A': countA++; break;
      
      case 'e': countE++; break;
      case 'E': countE++; break;
      
      case 'o': countO++; break;
      case 'O': countO++; break;
      
      case 'u': countU++; break;
      case 'U': countU++; break;
      
      case 'i': countI++; break;
      case 'I': countI++; break;
      
      default:
   }// of switch char at i
   
   }// of for i
   
   System.out.printf("The string contained: \n %3d A's \n %3d E's \n %3d O's \n %3d U's \n %3d I's \n", countA, countE, countO, countU, countI);
   
   //print out the vowels
   
   
   //question 6
   //make a table of numbers 1-80 and thier squares
   
   System.out.println("***Question 6 make a table of numbers 1-80 and their squares***");
   
  System.out.println(" num  square num  square num  square num  square");//print labels
   for(int e = 1; e <= 20; e++){//add by twenty to make each row
      for(int i = 0; i <= 3; i = i + 1){ //go four times to make each row
      System.out.printf("%4d", e);   //print out the numbers
      System.out.printf("%8d", e * e); //print out squares
      e = e + 20;      
      
      
      }// of e
   System.out.println("");
   e = e - 20 * 4; 
   }//of i <= 80
      
   System.out.println("");
   
   //question 7
   //print the factors of numbers 1-50
   
   System.out.println("***Question 7 print the factors of numbers 1-50***");
   
   
System.out.println("Number     Factors");
   System.out.println("------    -------"); //print labels

   for(int i = 1; i <= 50; i++){ //go 50 times for all numbers
      System.out.printf("%4d     ", i);
      for(int x=1; x <= i; x++){ //text all numbers from 0-to original number
      
         if(i % x == 0)    //check if a factor
            System.out.printf("%4d", x); //print factor
             
      }
      System.out.println("");
   }// for i <= 50

    
      
    
   
   
   
   }// of main
}// of lab4