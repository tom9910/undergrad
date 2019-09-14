class lecture19bytes{
public static void main(String[] args){

short val = 'a';
   System.out.println("the val is " + val);

   val = 'z';
   System.out.println("the val is " + val);

   val = 'A';
   System.out.println("the val is " + val);
   
   if(val >= 'A' && val <= 'Z')
      System.out.println(val + " is an uppercase letter");
   else
   System.out.println(val + " is not uppercase");

}

}