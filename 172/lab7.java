//Lab 7
//CS172
//written by Thomas Sanchez
//Oct 22, 2018
//This program does
//Input:
//Output:

class lab7{
   
   public static void printIntArray(int a[ ]){   //write method
   
   
  	for(int i = 0; i < a.length; i++){  	//go through all elemnts of the array
    	 
     	System.out.printf("%5d", a[i]); 	//print each element
     	
       	 
    }//of for print array
   
   }// of printIntArray
   
   
   public static void printIntArray2(int a[ ], int n){   //write method
   
   int count = 0;
   
  	for(int i = 0; i < a.length; i++){  	//go through all elemnts of the array
    	 
     	System.out.printf("%5d", a[i]); 	//print each element
     	count++;
     	if(n == count || count > n){
       	 
        	System.out.println();
        	count = 0;
       	 
     	}// of if n = count
 	 
  	}//of for i < length
   
   }// of printIntArray2

   public static boolean compareArrays(int a[ ], int b[ ]){
  	boolean match = false;
   
  	if(a.length == b.length){ 	//check if arrays are the same length before proceeding
 	 
     	for(int i = 0; i < a.length; i++){   //go through all elemnts of equal length arrys
       	 
        	if(a[i] == b[i]){  // check each element
           	match = true;	// set match true if they are equal
        	}// of if ai = bi
       	 
        	else {
           	match = false;   // set match true if they are false
           	break;       	// leave statement becuase one is not equal
        	}
     	}// for i = 0 if a = b
 	 
  	}// of if a = b
    	 
  	return match;
   }// of compareArrays
   
   public static void evenElements (int a[ ]){
   
  	for(int i = 0; i < a.length; i++){
 	 
     	if(a[i] % 2 == 0){      	//check if even
    	 
        	System.out.printf("%5d", a[i]);   //print i of a
        	System.out.println();
    	 
     	}// of if ai is even
 	 
  	}// of for i
   
   }// of evenElements
   
   public static int findMax (int a[ ]){
  	int max;
 	 
  	max = a[0]; //set max to largest number seen so far
 	 
  	for(int i = 0; i < a.length; i++){
 	 
     	if(a[i] > max)  //test other values for max
        	max = a[i];  //set max to highest value
 	 
  	}// for i max
 	 
  	return max;
   }// of find max

}// of class
