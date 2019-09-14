import java.util.Scanner;
class lecture9_1{
   public static void main(String[] args){
   
   Scanner scan = new Scanner(System.in);
   int num;
   int posCount;
   int negCount;
   int total;
   posCount = 0;
   negCount = 0;
   total = 0;
   
   num = -1;
   
   while(num != 0){
   System.out.println("enter a number (0 to end)");
   num = scan.nextInt();
   
   total++;
   
   //classify 
      if(num > 0){
         System.out.println(num + " is positive");
         posCount = posCount + 1;
      }
      else if(num == 0){}
      
      else{
         System.out.println(num + " is negative");
         negCount ++;
      }
   
   //and read again
   
   }// of while
   total = total -1;
   System.out.println(negCount + " " + posCount);
   System.out.printf("total \t%4d\n", total);
   
   if(total != 0){
      System.out.printf("Percent positive %7.2f%%\n",(100.0 * posCount/total));
      System.out.printf("Percent negative %7.2f%%\n",(100.0 * negCount/total));
   }// of if
   
   }// main
}// class