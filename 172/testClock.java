public class testClock{

   public static void main(String[] args){

      Clock T1, T2;
      
      T1 = new Clock(0,0,0);
      System.out.println(T1);
      T1 = new Clock(4,8,5);
      System.out.println(T1);
      
      System.out.println(T1.curHour());
      System.out.println(T1.curMinute());
      System.out.println(T1.curSecond());
      T1 = new Clock(11,59,59);
      System.out.println(T1);
      T1.tick(T1);
      System.out.println(T1);
      T2 = new Clock(12,0,0);
      if(T1.equals(T2)) System.out.println("Time is the same");
      else System.out.println("Time is not the same");
      
}// of main

}// of class