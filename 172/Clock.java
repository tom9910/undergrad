public class Clock{

   private int hour = 0;
   private int minute = 0;
   private int second = 0;
   


   public Clock(int myhour, int myminute, int mysecond){
     setHour(myhour);
     setMinute(myminute);
     setSecond(mysecond);
}// of clock()

   public void setHour(int myhour){
      if(myhour < 1 || myhour > 13)
      myhour = 12;
      else
         hour = myhour;
   }
   
   public void setMinute(int myminute){
      if(myminute < 0 || myminute > 59){
      minute = 0;
      }
      else
         minute = myminute;
   }
   
   public void setSecond(int mysecond){
   if(mysecond < 0 || mysecond > 59)
      second = 0;
   else
      second = mysecond;
   }
   public int curHour(){
      return hour;
   }
   
   public int curMinute(){
      return minute;
   }
   
   public int curSecond(){
      return second;
   }

   public String toString(){
   String S;
   S = String.format("%2d:%02d:%02d",hour, minute, second);
   return S;
   }
   
   public void tick(Clock T1){
   
   second +=1;
   if(second == 60){
   
   minute += 1;
   second = 0;
      if(minute == 60){
         hour += 1;
         minute = 0;
         if(hour == 13) hour = 1;
         
      }// if minute = 60
   
   }// of if second = 60
   
   }// of tick()
   
   public boolean equals(Clock myClock){
   
      boolean result;
      
      result = (this.hour == myClock.hour && this.minute == myClock.minute && this.second == myClock.second);
   
         return result;
   }// of eqauls
   
   
}// of class clock