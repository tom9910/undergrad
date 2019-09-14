//lecture26 traingle

class lecture26_triangle{

      public static void main(String[] args){
      
      
         printTriangle(-3);
         printTriangle(7);
         printTriangle(0);
      
      }// of main
      
      public static void printTriangle(int n){
      
      if(n < 0) return;
      
      if(n == 0) return;
      
      
      printTriangle(n - 1);
      for(int i = 1; i <= n; i++){
         System.out.print('*');}
      System.out.println();
      
      
      }// of print triangle
      

}// of class