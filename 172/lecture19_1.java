//array adding
class lecture19_2{

   public static void main(String[] args){
   
      int A[] = {4,5,2,0,1};
      boolean found = false;
      int value = 2;
      
   for(int i = 0; i < A.length; i++){
   
      if(A[i] == value){
      
         found = true;
      
      }// of if A
     
      
   }// for i
   
   System.out.println(found);
   
   }// of main 


}// of class