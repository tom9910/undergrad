//palindrome

class palindrome{

public static void main(String[] args){

   int z[] = {1, 4, 5, 3, 1};
   
   
   System.out.println(checkIFpal(z, 0, z.length - 1));


}// pf main


public static boolean checkIFpal(int a[], int l, int r){

   if(l >= r)
      return true;
      
   if(a[l] == a[r]){
   
      return(checkIFpal(a, l+1, r-1));
   }
   
   else 
   return false;
 

}// check if pal 

}