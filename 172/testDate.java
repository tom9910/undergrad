public class testDate{

   public static void main(String[] args){
      Date D1, D2;
      D1 = new Date(12,3,2018);
      D2 = new Date(12,3,2018);
      System.out.println(D1.curYear());
      System.out.println(D1);  //looks for too string method
      if(D1.eqYear(D2)) System.out.println("The same");
      else System.out.println("Not the same");
   }// of main

}// of class