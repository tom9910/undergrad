//Thomas Sanchez
//09-23-19
//lab4
//intNode.java


package cs272;



public class intNodetest {			//intnode test

    public static void main(String[] args) {
      	 // TODO Auto-generated method stub
      	 
    	//create a head node which points to another and another node
      	 intNode num1 = new intNode(7, null);
      	intNode head = new intNode(5, num1);
      	 
      	 //add a node with 6 after head
      	 head.addNodeAfterThis(6);
      	 //add a node with 100 after num1
      	 num1.addNodeAfterThis(100);
      	 
      	 System.out.println("The current length of the list starting at head:");
      	 System.out.println(intNode.listLength(head));
      	 System.out.println("Using to string print from head and then num1");
      	 System.out.println(head);
      	 System.out.println(num1);
      	 System.out.println("Print after a node is added after num1.getlink");
      	 num1.getLink().addNodeAfterThis(700);
      	 System.out.println(head);
      	 
      	 System.out.println("search for 700");
      	 System.out.println(intNode.search(head, 700));
      	 System.out.println("print after 700 has been removed");
      	 num1.getLink().removeNodeAfterThis();
      	 
      	 System.out.println(head);
      	 
      	 //search for 700 again
      	System.out.println("search for 700");
      	System.out.println(intNode.search(head, 700));
      	 	
      	 
       }

}
