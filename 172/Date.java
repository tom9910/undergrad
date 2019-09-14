//classes
//
public class Date {
   private int day,month,year;
   
   //constructer
   Date(int myday, int mymonth, int myyear){
      setYear(myyear);
      month = mymonth;
      day = myday;
      
   
   }// of date constructor
   
   public void setYear(int myyear){
      year = myyear;
   }
   public int curYear(){
      return year;
   }
   public int curMonth(){
      return month;
   }
public int curDay(){
      return day;
   }

   public String toString(){
      String S;
      S = String.format("%02d/%02d/%04d", month,day,year);
   return(S);
   }
   
   public boolean eqYear(Date myDate){
      
      boolean result;
      result = (this.year == myDate.year); //comapre years to get true or false
   //this = my year D1
   
      return result;
   
   }// opf eqYear

}// of class