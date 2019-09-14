class bubblesorting{

   public static void main(String[] args){
   
   int[] array = new int[10];
   
   int element;
   
   for(int i = 0; i < array.length; i++){
   
      array[i] = (int)(Math.random()*50);
      System.out.printf("%6d", array[i]);
   }// of for print
   System.out.println();
   
   element = array[0];
   
   //sort
   
   for(int i = 0; i < array.length; i++){
      for(int j = 0; j < array.length - 1; j++){
         if(array[j] > array[j + 1]){
            int t = array[j];
            
            array[j] = array[j+1];
            array[j + 1] = t; 
         
         }// of if j > j + 1
      
      }// of for j
   
   }// of for i
   
   for(int i = 0; i < array.length; i++){
   
      
      System.out.printf("%6d", array[i]);
      
   }// of for print
      System.out.println();
   
   System.out.println(search.findit(array, element));   
   }// of main

}// of class