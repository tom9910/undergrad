class arrayFillStudy{

   public static void arrayCreate(int[] a){
   
   for(int i = 0; i < a.length; i++){
   
      a[i] = (int)(Math.random() * 20 + 1);
      System.out.println(a[i]);
   
   }// for i
   
   }// of array create
   
   
   public static void arrayReverse(int [] a){
   
      for(int i = 0; i < a.length / 2; i++){
   
         int temp = a[i];
         a[i] = a[a.length - i - 1];
         a[a.length - i -1] = temp;
         
         
         
   
   }// of for i
   
   for(int j = 0; j < a.length; j++){
      
         System.out.println(" " + a[j] + " ");
      
      }
      
   
   }// of array reverse

   public static void main(String[] args){
      int[] a = new int[10];
      
      arrayCreate(a);
      System.out.println();
      arrayReverse(a);
   
   }// of main

}// of class