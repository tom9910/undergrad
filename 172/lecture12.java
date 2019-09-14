//lecture 12
//thomas sanchez
//oct 16, 2018
class lecture12{

   public static void main(String[] args){
   
      int A[] = new int[10];
      int B[] = {4,3,7,8};
      int mymax;
      
      for(int i = 0; i < B.length; i++)
         System.out.println(B[i]);
      //System.out.println(B);    //print memory location
      
      //fill array with random numbers
      for(int i = 0; i < A.length; i++)
         A[i] = (int) (Math.random()*10000);
      //print the array elements
      for(int i = 0; i < A.length; i++)
         System.out.printf("%5d %5d\n",i, A[i]);
      System.out.println();
      
      mymax = A[0];  //first so far
      
      for(int i = 1; i < A.length; i++){
         if(A[i] > mymax)
            mymax = A[i];
      
      }// for finding max
      
      System.out.println(mymax);
     
   
   }// of main
}// of class