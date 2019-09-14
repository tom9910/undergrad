class lecture18_2{
   public static void main(String[] args){
   
   String[] S =new String[10];
   
   //args
   System.out.println(args); // location
   System.out.println(args.length);
   System.out.println(S.length);
   
   S[0] = "Thomas";
   S[1] = "Sanchez";
   S[3] = "Dog";
   
   System.out.println(S[0].length());
   
   for(int i = 0; i < S.length; i++)
      System.out.println(S[i]);  
   }// fo mian

}//class