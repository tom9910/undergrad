//Thomas Sanchez
//09-23-19
//lab4
//intNode linked list class

package cs272;


public class intNode {  //class 
    
    private int value;
    
    private intNode link;
    
    public intNode() {   	 //default constructor
   	 value = 0;
   	 link =  null;
    }// end of constructor

    
    public intNode(int data, intNode node) {   	 //constructor
   	 value = data;
   	 link = node;
    }// of constructor
    
    //set methods
    public void setValue(int data) {		//set data
   	 value = data;
    }// of set value
    
    public void setLink(intNode node) {		//set link 
   	 link = node;
    }// of set link
    
    public int getVal() {					//return the value or data
   	 return value;
    }// of get val
    
    public intNode getLink() {				//return the link
   	 return link;
    }// of get link
    
    public String toString() {				//to print from node function is called from
   	 String result = "";
   	 intNode current = new intNode(this.getVal(), this.getLink());
   	 while(current != null) {
   		 result += current.getVal() + "->";
   		 
   		 current = current.getLink();
   	 }// of while
   	 
   	 return result;
   	 
    }// of to string
    
    public void addNodeAfterThis(int newData) {		//adds a node with data in parameter to 
   	 	this.link = new intNode(newData, link);		//location directly after node called from
    }//
    
    public void removeNodeAfterThis() {				//removes node directly 
   	 link = this.getLink().getLink();
    }// remove after this
    
    public static int listLength(intNode head) { //returns length starting from parameter value
    	int cnt = 0;
    	intNode cursor = head;
    	while(cursor != null) {				//while not null increment count and move up
    		cnt++;
    		cursor = cursor.getLink();
    	}// of while loop
    	return cnt;				//return length
    }// of get length
    
    public static boolean search(intNode head, int data) {		//looks for data starting at first parameter and look for second parameter
    	
    	if(head == null) return false;	//precondition cannot search if head is null
    	
    	intNode cursor = head;
    	
    	while(cursor != null) {
    		if(cursor.getVal() == data) {		//check if data has been found
    			return true;		//if found return true
    		}// of if found
    		
    		cursor = cursor.getLink();		//if not found increment
    	}// of while
    	return false;					//if loop exits return false;
    }// of search
    
   	 

}// of class



