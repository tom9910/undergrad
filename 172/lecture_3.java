//lecture 26_3
//numbers backwards

class lecture_3{

   public static void main(String[] args){
   
   reverse(123);
   
   }// of main
   
   
   public static void reverse(int n){
   //error
   if(n < 0)return;
   //base
   if(n < 10) {
      System.out.println(n);
   return;
   }//of if n < 10
   //recursive
   int r, d;
   
   r = n % 10;
   d = n /10;
   
   System.out.print(r);
   
   reverse(d);
   
   }// of reverse

}// of class