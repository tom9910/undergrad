//reurn a string that is n * the string

class lecture20{

   public static void main(String args[]){
   
      System.out.println(doit("hello ", 5));
   
   
   }// of main
   
   public static String doit(String S, int N){
   String R = "";
   for(int i = 1; i <= N; i++){
      R = R + S;
   }
   return R;
}// of doit
}// of class