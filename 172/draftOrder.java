import java.util.Random;


class draftOrder{

public static void main(String[] args){

   String[] names = {"Aidan","Aidan","Aidan","Aidan","Aidan","Aidan","Aidan","Aidan",
   "Aidan","Aidan","Aidan","Aidan","Ryan", "Ryan","Ryan","Ryan","Ryan","Ryan","Ryan","Ryan","Ryan",
   "Ryan","Jack","Jack", "Jack", "Jack", "Jack", "Jack", "Jack", "Jack", "Jack", 
   "Matt", "Matt","Matt","Matt","Matt","Matt","Matt","Matt","Tom","Tom","Tom","Tom","Tom",
   "Tom","Tom","Greg","Greg","Greg","Greg","Greg","Greg","Sky","Sky","Sky","Sky","Sky",
   "Tommy", "Tommy","Tommy","Tommy","Dez","Dez","Dez","Jesse", "Jesse", "Spencer"  };

   Random r = new Random();
   
   int randomName = r.nextInt(names.length);
   
   String name = names[randomName];

   while(name.equals("Matt") || name.equals("Jesse")|| name.equals("Aidan")|| name.equals("Greg")|| name.equals("Dez")|| name.equals("Jack")|| name.equals("Tom")|| name.equals("Sky")|| name.equals("Tommy")|| name.equals("Ryan")){
      
      System.out.print("repeat ");
      
    r = new Random();
   
   randomName = r.nextInt(names.length);
   
   name = names[randomName];
      
   }
   
   System.out.print(name);


}// of main





}