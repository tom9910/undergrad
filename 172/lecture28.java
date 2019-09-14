//lecture 28 review for final
//recursion
//write a boolean recursive method which indicates whether the array is a palindrome or not
class lecture28{

   public static void main(String[] args){
   
   int z[] = {1,3,3,1};
   System.out.println(IsPAl(z));
   
   }// of main
   
   public static boolean IsPAl(int[] a){
   
      return(check(0, a.length - 1, a));
   
   }

   private static boolean check(int l, int r, int[] a){
   
      //error case
      
      //base case
      if(l >= r) return true;
      //recursive step
      if(a[l] == a[r]){
      
         return(check(l + 1, r - 1, a));
      
      }// of if equal
      else return false;
      
   }// of check



}// of class