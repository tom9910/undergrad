//write a method that takes a string 
//and prints out on each line the elements between commas
//should return the number of elemstne printed out

class StringItemPrint{
   
   public static void main(String[] args){
      
      System.out.println(printString("hello, yeah, jkhsjf, jksdjhf"));
   }// of main
   
   public static int printString(String S){
      int index = S.indexOf(',');
      int count = 0;
      while(index != -1){
      
         System.out.println(S.substring(0,index));// print it
         count++;
         S = S.substring(index + 1); //truncate
         index = S.indexOf(',');
      } 
      System.out.println(S);  
      count++;
      return count;
   }// of print string


}// of class
