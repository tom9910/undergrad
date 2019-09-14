//Lab 7 test
//CS172
//written by Thomas Sanchez
//Oct 22, 2018
//This program does a test of methods in lab7.java
//Input: 
//Output:

class testlab7{

   public static void main(String args[]){
   
      int[] array1 = new int[25];
      int[] array2 = new int[50];
      int[] array3 = new int[25];
   
      for(int i = 0; i < array1.length; i++){
   
         array1[i] = (int)(Math.random() * 100 + 1);  //fill array randomly 1 - 100
   
   }// of for i less the array length
   
      for(int i = 0; i < array2.length; i++){
   
         array2[i] = (int)(Math.random() * 1000 + 1);  //fill array randomly 1 - 1000
   
   }// of for i less the array length
   
      for(int j = 0; j < array3.length; j++){
         array3[j] = array1[j];
      }
   
      System.out.println("Here is array 1 printed:");
 	   lab7.printIntArray(array1);
      
      System.out.println();
      
      System.out.println("Here is array 1 printed five numbers at a time:");
      lab7.printIntArray2(array1, 5);
      
      System.out.println();
      
      System.out.println("Here is array two with 10 numbers per line:");
      lab7.printIntArray2(array2, 10);
      
      System.out.println();
      
      System.out.println("Here are all the even parts of array 1 and then array 2");
 	   lab7.evenElements(array1);
      System.out.println();
      lab7.evenElements(array2);
      
      System.out.println();
      
      System.out.println("Here are arrays 1 and 3 compared");
      System.out.println(lab7.compareArrays(array1, array3));
      
      array3[24] = array3[24] + 1; //change value of number at index 24
      
      System.out.println();
      
      System.out.println("Here are arrays 1 and 3 compared with 24 changed on array3");
      System.out.println(lab7.compareArrays(array1, array3)); 
      
      System.out.println();
      
      System.out.println("Here are arrays 2 and 3 compared");
      System.out.println(lab7.compareArrays(array2, array3));
      
      System.out.println();
      
      System.out.println("Here is the max of array1");
      System.out.println(lab7.findMax(array1));
      
      System.out.println("Here is the max of array2");
      System.out.println(lab7.findMax(array2));
   }// of main
}
