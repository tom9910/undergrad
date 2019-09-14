//Thomas Sanchez
//09-6-2019
//employee object
//lab 2 cs272

package cs272;

public class Employee {			//start of class employee
    
	//create variable
    String name;
    
    int num;
    
    int age;
    
    String state;
    
    int zipCode;
    
    Integer[] advisors = new Integer[3];  //create array of non primative type intger

    public Employee() {  //default constructor (set primititavie types to 0 and non to null;
   	 name = null;
   	 num = 0;
   	 age = 0;
   	 state = null;
   	 zipCode=0;
   	 for(int i = 0; i < 3; i++) {		//loop to set array values
   		 advisors[i] = null;
   	 }// for loop
   		 
    }// of employee constructor

    public Employee(Object obj) {			//copy constructor, requires values from parameter to be set to values that are not null
   	 if(obj == null) return;				//check that object parameter is not null.
   	 else if(obj instanceof Employee) {		//if not null and is an object of type employee
   		 
   		 Employee T = (Employee) obj;		//type cast
   		 name = new String(T.name);			//create a new string object and set to same value as parameter string
   		 num = T.num;						//set num to parameter num
   		 age = T.age;						//set age to parameter age
   		 state = new String(T.state);		//set state to parameter state 
   		 zipCode = T.zipCode;				//set zip to parameter zip
   		 
   		 advisors = new Integer[3];			//for loop to copy advisors
   		 for(int i = 0; i < 3; i++) {
   			 advisors[i] = T.advisors[i];
   		 }// for loop
   		 
   		 
   	 }// if not null
    }// of copy constructor
    
    //get methods below
    //use get to access varibales if private
   	 public String getName() {
   		 return name;
   	 }
   	 
   	 public String getState() {
   		 return state;
   	 }
   	 
   	 public int getEmpNum() {
   		 return num;
   	 }
   	 
   	 public int getAge() {
   		 return age;
   	 }
   	 
   	 public int getZipCode() {
   		 return zipCode;
   	 }
   	 
   	 public Integer[] getAdvisors() {
   		 return advisors;
   	 }
    //end of get methods
    
    //set methods below
    //use set methods to chnage variables if private
   	 //parameter will be value variable is chnaged too
   	 public void setName(String newName) {
   		 name = newName;
   	 }
   	 
   	 public void setState(String newState) {
   		 state = newState;
   	 }
   	 
   	 public void setNum(int newNum) {
   		 num = newNum;
   	 }
   	 
   	 public void setAge(int newAge) {
   		 age = newAge;
   	 }
   	 
   	 public void setZipCode(int newZipCode) {
   		 zipCode = newZipCode;
   	 }
   	 
   	 public void setAdvisors(Integer num1,Integer num2, Integer num3) {
   		 advisors[0] = num1;
   		 advisors[1] = num2;
   		 advisors[2] = num3;
   	 }
    //end of set methods
   	 
   	 
   	 //create a formatted print of employee objects
   	 public String toString() {
   		 
   		 return String.format("Employee Name: %s, Employee Num: %d, Age: %d, State: %s, zip code: %d, advisors: %d; %d; %d", name, num, age, state, zipCode, advisors[0], advisors[1], advisors[2]);
   	 }// of to string
   	 
   	 
   	 public boolean equals(Object obj) {   //check if employee number is equal. object cannont be null or have null values
   		 if(obj instanceof Employee) {		//if and employee object
   			 Employee E = (Employee) obj;	//typecast
   			 if(E.num == num) {						//if equal num
   				 return true;
   			 }// if employee numbers are equal
   			 else return false;
   		 }// if instance of
   		 else return false;
   	 }// of equals method
   	 
   	 public static int[] getAllAdvisors(Employee e1, Employee e2) { //combine advisors of two employees
   		 int[] combined = new int[6];					//make a new array
   		 
   		 for(int j = 0; j < combined.length; j++) {		//loop through new array
   			 if(j <= 2)
   				 combined[j] = e1.advisors[j];// set e1		set first parameter values
   			 else
   			 combined[j] = e2.advisors[j-3];				//set second parameter values
   		 }// of for
   		 return combined;
   	 }// of getallAdvisors
   	 
    //start of main
    public static void main(String[] args) {
   	 Employee E = new Employee();		//create E with deafult values
   	 
   	 System.out.println("Employee E after defualt constructor: ");
   	 System.out.println(E.toString());			//test of toString with default values
   	System.out.println();
   	System.out.println();
   	 
   	 //use set functions to set all values of E
   	 E.setName("bill");
   	 E.setNum(10034);
   	 E.setAge(32);
   	 E.setState("NM");
   	 E.setZipCode(88001);
   	 E.setAdvisors(1234, 4777, 12);
   	 
   	 //use get functions to get and print all values set above
   	System.out.println("Test of get functions");
   	 System.out.println(E.getName());
   	System.out.println(E.getEmpNum());
   	System.out.println(E.getAge());
   	System.out.println(E.getState());
   	System.out.println(E.getZipCode());
   	System.out.println("Array tag: " + E.getAdvisors());		//will  not print array values
    System.out.print("advisor array values: ");
   	for(int i = 0; i < 3; i++) {
  		 System.out.print(E.getAdvisors()[i]+ " ");			//print array values
  	 }
   	System.out.println();
   	System.out.println();
   	//copy constructor test
   	 Employee E2 = new Employee(E);				//E must contain no null values like in the default constructor
   	 
   	 //print both objects after copy constructor to show result
   	System.out.println("to string method tests");
   	 System.out.println("Object E (original) " + E.toString());
   	 System.out.println("Object E2 (made with copy constructor) " + E2.toString());
   	 System.out.println();
   	 System.out.println();
   	 
   	System.out.println("test both cases of equal method");
   	 //test of equals method should result in true if employee numbers equal true
   	 System.out.println(E2.equals(E));
   	 E2.setNum(22067);		//change employee number to check both cases
   	 System.out.println(E2.equals(E));			//should be false
   	 System.out.println();
   	System.out.println();
   	 //chnage advisors of e2 with set
   	 E2.setAdvisors(1, 1, 1);
   	 
   	 //test get all advisors and print 
   	 System.out.println("Test get all advisors:");
   	 System.out.println();
   	 for(int i = 0; i < 6; i++)
   	 System.out.print(getAllAdvisors(E, E2)[i] + " ");
   	 
    }// of main
}// class



