class lecture6_1{

   public static void main(String[] args){
   
   String first;
   String firstp, lastp;
   
   char c;
   
   first = " hello";
   c = first.charAt(1);
   System.out.println(first);
   System.out.println(first.length());
   System.out.println(c);
   System.out.println(first.replace("h", "H")); //does not permanently change
   System.out.println(first);
   }// of main
}