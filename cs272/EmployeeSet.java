



package cs272;

//imports for file reading
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class EmployeeSet {	//class
    
    int numberOfE = 0;			//counter for list length different then array length, keeps track of how many elements fill and not null
    
    Employee[] Elist;			// declare an array
    
    public EmployeeSet() {   		 //constructor
   	  Elist = new Employee[10];			//make an array of length ten
    }// of constructor employe set
    
    public EmployeeSet(Object obj) {		//copy constructor
   	 if(obj == null) return;
   	 
   	 else if(obj instanceof Employee) {
   		 Elist = new Employee[10];			//create a new array 
   		 EmployeeSet S = (EmployeeSet) obj;
   		 
   		 //copy everything from old array to new
   		 
   		 for(int i = 0; i < S.Elist.length; i++) {
   			 Elist[i] = S.Elist[i];
   		 }// of for list length
   		 
   	 }// if not null
   	 
    }// of copy constructor employee set
    
    public int size() {							//return the size of the list(amount of filled values) not using number of e
   	 int count = 0;
   	 for(int j = 0; j < Elist.length; j++) {
   		 if(Elist[j] == null)					//if reached last element count is done
   			 return count;
   		 
   	   count++;
   	 }// of or loop
   	 return 0;
    }// of size
    
    public int capacity() {						//return the avilable space in the array
    	
   	 return Elist.length;
    }// of capacity
    
    
    public void add(Employee a) {   	//add an employee object
   	 if(a == null) return;				// if object has nothing
   	 int cnt = 1;						//counter one ahead looking for end of capacity
   	 for(int i = 0; i < Elist.length; i++) {		//loop through length
   		 if(Elist[i] == null) {						//when empty space found add object
   			 Elist[i] = a;		//add object at index
   			 numberOfE++;		//increment total object count
   			 return;
   		 }// if not full
   		 else {cnt++;
   			 if(cnt > Elist.length) {				//if end is reached with no empty space 
   				 ensureCapacity(Elist.length * 2);	//call ensure capacity
   				 Elist[i+1] = a;					//then add value 
   				 numberOfE++;						//increment total value counter
   				 return;							//exit function
   			 }// if need more space
   		 }// else
   	 } //for
    }// of add
    
    private void ensureCapacity(int minimumCapacity) {			//to be called if space has been filled during add or addOrdered
   	 if(minimumCapacity < 0) {}									//make sure minimum capcity is greater then zero
   	 else if(Elist.length < minimumCapacity) {					//make sure length is lower thenentered value
   		 //int l = Elist.length;
   		 Employee temp[] = new Employee[minimumCapacity];		//create new longer array
   		 for(int i = 0; i < Elist.length; i++) {				//loop through and copy values
   			 temp[i] = Elist[i];
   		 }// for loop
   		 
   		 Elist = temp;											//point Elist to temp
   		 
   	 }// if too small
    }// of ensure capacity
    
    public boolean contain(Employee a) {						//check if list contains an object a
   	 if(a == null)												// if a has nothing do nothing
   		 return false;
   	 else {
   		 for(int i = 0; i < numberOfE; i++) {					//loop through number of elements
   			 if(a.getEmpNum() == Elist[i].getEmpNum()) {		//check if a employee num is equal to object currently on
   				 return true;									//if found return true
   			 }
   		 }// of for loop
   		 return false;
   	 }// of else    
    }// of remove
    
    public boolean remove(int eno) {							//remove a specific object based on employee num
   	 	for(int i = 0; i < numberOfE; i++) {					// gop thourgh number of elements
   	 		if(eno == Elist[i].getEmpNum()) {					// if found
   	 			Elist[i] = Elist[numberOfE - 1];				// move values down and shorten elements length
   	 			numberOfE--;
   	 			return true;
   	 		}// if found
   	 	}// for loop
   	 	
   	 return false;
   	 
    }// of remove
    
    //add ordered 
    public void addOrdered(Employee a) {				//objects in array must already be in ascending order
    	
    	numberOfE++;
    	int cnt = 1;
    	int i;
    	for(i = 0; i < numberOfE - 1; i++) {				//loop through elemts
    		
    		if(Elist[i].getEmpNum() > a.getEmpNum()) {			//find location for new elements
    			//numberOfE++;
    			break;
    			
    		}// if right spot
    	
    	
    	}// for loop
    	if(numberOfE >= Elist.length) {
			ensureCapacity(Elist.length * 2);				//ensure capacity if needed
		}
    	for(int j = numberOfE; j >= i; j--) {
    		
			Elist[j+1] = Elist[j];							// move elements after old elements over
		}// for loop 2
    	Elist[i] = a;										//add new object
    	
    }// of add Ordered
    
    //to read file and add objects
    
    
	public static void readAndAdd(String pathToCsv, EmployeeSet newSet) {		//start of printInfo
		String row = "";								//declare row string
		String SplitBy = ",";							//declare splitby char
		int num = 0;									//declare num to indicate if on row one
		
		
		
	try {				//attempt to open file
		BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));		//open file reader
		while((row = csvReader.readLine()) != null) {									//loop until file is done.
			if(row.charAt(0) == ',') {break;}				//if row starts with a comma exit loop.(so error is not created on last line)
			String[] employee = row.split(SplitBy);			//specify split by comma. 
		if(num == 0) {  //check if first row
			
			
			//print title row
			System.out.println(employee[0]+" " + employee[1] + " " + employee[2] +" "+employee[3]+" "+employee[5]+" "+employee[6]);
			
			
			
			num++;  //increment row number
		}// of if first row
		
		else {   // do if not first row
			
			

			
			if(row.charAt(0) != ',') {	
			String[] employeeData = row.split(SplitBy);
			//create object
			Employee temp = new Employee(); 
			
			//set each object instance
			temp.setName(employeeData[0] + ", " + employeeData[1]);
			temp.setNum(Integer.parseInt(employeeData[2]));
			temp.setAge(Integer.parseInt(employeeData[6]));
			temp.setState(employeeData[3]);
			temp.setZipCode(Integer.parseInt(employeeData[4]));
			temp.setAdvisors(0, 0, 0);
			
			//add object
			newSet.add(temp);
			
			//print out info normally here
			//System.out.println(employeeData[0]+"," + employeeData[1] + " #" + employeeData[2] +" "+employeeData[3]+" "+employeeData[4]+" "+employeeData[6]+" "+employeeData[7]);
			num++;
			}// if doesnt start with a comma
			else {}
		}// fo else
		}//for while loop
	}//of try
	//error catching if file given is not found
	catch (FileNotFoundException e){
		System.out.print("File not found");
	}//catch
	//error catching if info is wrong 
	catch (IOException e) {
        System.out.print("error");
	}//catch
	finally {
	}// finally
	}// of read and Add

    
    
    
    
    
//main
    public static void main(String[] args) {
   	 // TODO Auto-generated method stub
   		 Employee e1 = new Employee();
   		 e1.setAdvisors(1, 2, 3);
   		 e1.setAge(21);
   		 e1.setName("pegasus");
   		 e1.setNum(3);
   		 e1.setState("NM");
   		 e1.setZipCode(88003);
   		 
   		 Employee e2 = new Employee(e1);			//use copy constructor
   		 e2.setNum(4);
   		 System.out.println("two objects that are added to list Set:");
   		 System.out.println(e1.toString());
   		 System.out.println(e2.toString());
   		 
   		 EmployeeSet set = new EmployeeSet();
   		 set.add(e1);
   		 set.add(e2);								//add both object to employee set
   		 
   		//create ten objects not added to listb yet
   		Employee e3 = new Employee(e1);
   		e3.setNum(5);
   		Employee e4 = new Employee(e1);
   		e4.setNum(6);
   		Employee e5 = new Employee(e1);
   		e5.setNum(7);
   		Employee e6 = new Employee(e1);
   		e6.setNum(8);
   		Employee e7 = new Employee(e1);
   		e7.setNum(9);	
   		Employee e8 = new Employee(e1);
   		e8.setNum(11);
   		Employee e9 = new Employee(e1);
   		e9.setNum(12);
   		Employee e10 = new Employee(e1);
   		e10.setNum(13);
   		
   		
   		 System.out.println("Does e1 exsist in set: "+set.contain(e1));
   		 System.out.println("How much space is availble in set: " + set.capacity());
   		 System.out.println("How many elements are in set: " + set.size());
   		 System.out.println("Does e3 exsist in set" + set.contain(e3));
   		 
   		 //add more objects
   		 set.add(e3);
   		set.add(e4);
   		set.add(e5);
   		set.add(e6);
   		set.add(e7);
   		set.add(e8);
   		set.add(e9);
   		set.add(e10);
   		//System.out.println(set.Elist.length);
   		System.out.println(""); //for spacing
   		System.out.println("objects now in set: (set is already ordered)");
   		 for(int i = 0; i < set.numberOfE; i++) {
   			 System.out.println(set.Elist[i]);
   		 }// for loop
   		 
   		 
   		 Employee e11 = new Employee(e1);
   		 e11.setNum(10);
   		 Employee e12 = new Employee(e1);
   		 e12.setNum(14);
   		 
   		 
   		 set.addOrdered(e11);
   		
   		 set.addOrdered(e12);
   		 System.out.println("");
   		 System.out.println("set after e11 with num 10 and e12 with num 14 addOrdred");
   		for(int i = 0; i < set.numberOfE; i++) {
  			 System.out.println(set.Elist[i]);
  		 }// for loop
   		 
   		System.out.println("New set capacity " + set.capacity());
   		System.out.println("New set size" + set.size());
   		
   		
   		EmployeeSet newSet = new EmployeeSet();		//make new set
   		//print out read values
   		
   		String path = "/Users/tommysanchez/Documents/Sophmore NMSU-2019/Data Structures and Algorithms/core_dataset.csv"; //enter path to file here!!!!!!!
   		
   		System.out.println("");
   		System.out.println("newSet elements anfter read and add function");
   		
   		readAndAdd(path, newSet);		//call read and add  (prints labels)
   		
   		for(int i = 0; i < newSet.numberOfE; i++) {
 			 System.out.println(newSet.Elist[i]);
 		 }// for loop
   		
   		newSet.add(e1);
   		newSet.remove(1103024456);
   		
   		System.out.println(newSet.size());
   		System.out.println(newSet.capacity());
   		System.out.println("");
   		System.out.println("newSet after remove mia(1103024456) and add e1");

   		for(int i = 0; i < newSet.numberOfE; i++) {
 			 System.out.println(newSet.Elist[i]);
 		 }// for loop
    }// of main

}


