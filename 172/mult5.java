//study multiple of 5 recursive

class mult5{

   public static void main(String[] args){
   
      System.out.println(checkFor("hello"));
   
   }// of main

      

   public static boolean checkFor(String a){
   
      boolean found = false;
      
      //base case
      if(a.charAt(0) == 'a' || a.charAt(0) == 'A'){
         return true;
         }
         
      else if(a.length() != 0)
         return false;
      
      //recusive steps
      else if(a.charAt(0) != 'a' || a.charAt(0) !=- 'A'){
      
      a = a.substring(1);
      return checkFor(a);
      
      
      }// if not a
      
      else
         return false;
         
   }// of check for

}// of class