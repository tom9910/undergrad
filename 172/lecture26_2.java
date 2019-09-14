//lecture 26 2

class lecture26_2{

   public static void main(String[] args){
   
   System.out.println(length(0));
   System.out.println(length(45));
   System.out.println(length(-686));
   
   }// of main

   public static int length(int n){
   //base case
      if(n >= -9 && n <=9) return 1;
   //recursive case
      return 1 + length(n/10);
   
   }// of length

}//of class