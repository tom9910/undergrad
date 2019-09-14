//array adding
class lecture19_2{

   public static void main(String[] args){
   
      int A[] = {4,5,2,0,1};
      int total = 0; //if multiplying make 1
         
      for(int i = 0; i < A.length; i++){
         
         total = A[i] + total;
         System.out.printf("i: %5d   total: %5d\n", i, total);
      }
   
   System.out.println();
   System.out.println("The final total of the array is " + total);
   
   System.out.println("The final average of the array is " + (double)total/A.length);
   }// of main 


}// of class