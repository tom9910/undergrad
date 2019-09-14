/*Thomas Sanchez
Aug 30, 2018
lecture5
*/

class lecture5{
   public static void main(String[] args){
   
   int x1;
   int range = 52;
   int offset = 1;
   double x;
   
   for (int i = 0; i < 10; ++i ){
      x = Math.random();
      x1 = (int) (x * range) + offset;
      System.out.println(x1 + " " + x);
   }// of for
   
   }// of main
}// of class