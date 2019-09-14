//study class and objects

class employee{

   String name;
   int salary, year;


   public employee(String Myname, int Mysalary, int Myyear){
   
      setName(Myname);
      setSalary(Mysalary);
      setYear(Myyear);
   
   }// of employee
   
   
   public String setName(String Myname){
   
      name = Myname;
      return name;
   
   }
   
   public int setSalary(int Mysalary){
   
      if(Mysalary > 0)
      salary = Mysalary;
      else salary = 0;
      return salary;
   
   }
   
   public int setYear(int Myyear){
      if(Myyear > 0)
      year = Myyear;
      else year = 0;
      return year;
   
   }
   
   public void getName(){
   
      System.out.print(name);
   
   }
   
   public String toString(){
   
      return String.format(" %s has been with the company for %2d years and makes %2d a year.", name, year, salary);
   
   }// to string



}// of class