//Thomas Sanchez
//08/28/19
//truthTables
//print all combinations of a t or false with 8 options(three variables)



package lab1;

public class truthTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String[] TorF = {"F", "T"};			//array with T or F to choose from
			int count = 1;						//counter for table label
			
			for(int loop1 = 0; loop1 < 2; loop1++){
		        for(int loop2 = 0; loop2 < 2; loop2++){
		            for(int loop3 = 0; loop3 < 2; loop3++){
		                for(int loop4 = 0; loop4 < 2; loop4++){
		                    for(int loop5 = 0; loop5 < 2; loop5++){
		                        for(int loop6 = 0; loop6 < 2; loop6++){
		                            for(int loop7 = 0; loop7 < 2; loop7++){
		                            	 for(int loop8 = 0; loop8 < 2; loop8++){
		                            		 //print tables labels
		                            		 System.out.println("Truth Table: " + count);
		                            		 System.out.println("p q r proposition");
		                            		 System.out.println("-----------------");
		                            		 
		                            		 System.out.print("F F F ");		//print variables before each prop
		                            		 System.out.println(TorF[loop1]);
		                            		 
		                            		 System.out.print("F F T ");
		                            		 System.out.println(TorF[loop2]);
		                            		 
		                            		 System.out.print("F T F ");
		                            		 System.out.println(TorF[loop3]);
		                            		 
		                            		 System.out.print("F T T ");
		                            		 System.out.println(TorF[loop4]);
		                            		 
		                            		 System.out.print("T F F ");
		                            		 System.out.println(TorF[loop5]);
		                            		 
		                            		 System.out.print("T F T ");
		                            		 System.out.println(TorF[loop6]);
		                            		 
		                            		 System.out.print("T T F ");
		                            		 System.out.println(TorF[loop7]);
		                            		 
		                            		 System.out.print("T T T ");
		                            		 System.out.println(TorF[loop8]);
		                            		 
		                            		 System.out.println("");
		                            		 
		                            		 count++;
		                            	
		                            	 
		                            	 
		                            	 
		                            	 }}}}}}}}//end of all for loops
										//System.out.println(count);
		                            	 
	}//end of main
		                            
		                            	
		                            }// end of class

			
	


