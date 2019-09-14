// fills an aary with the sqaure of the index of th array
// then go thourgh the array and negate all even elements
// then print the array size 10 in a field of 5 with its index

class exam3Array{

   public static void main(String[] args)
   {
   
      int A[] = new int[10];
   
      for(int i = 0; i < A.length; i++){
         A[i] = i * i;
      }// of for
      
      for(int i = 0; i < A.length; i++){
         if(A[i] % 2 == 0)
            A[i] = -A[i];
      
      }
      
      for(int j = 0; j < A.length; j++){
      
         System.out.printf("%5d %5d\n", j, A[j]);
      
      }// of for
   
   }// of main


}// of class