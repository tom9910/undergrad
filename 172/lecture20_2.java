//randomly put numbers between 103 3 in array use INSERTION SORT

class lecture20_2{

   public static void main(String args[]){
   
      final int MAX = 10;
      int A[] = new int[MAX];
      int num;
      int position;
      //creat value and put in correct place*
      for(int i = 0; i < A.length; i++){
         
         num = (int)(Math.random() * 100 + 3); //>= 3 < 103
         //find where num goes
         position = 0; 
         while(position < i && A[position] < num){
         position++;
         
         //move one over
           
           for(int j = i; j > position; j--){
           
           A[j] = A[j - 1];
           
           }// of for j
           
           A[position] = num;
         
         }// of while 
           
           
              
         
         
      }// of for i
      
      //print
      
      for(int i = 0; i < A.length; i++){
      
        System.out.printf("%7d ", A[i]);
         if((i + 1) % 5 == 0) System.out.println(); 
         
      }// for print
   
   }// mof main

}// of class