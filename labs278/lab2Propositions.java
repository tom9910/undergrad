//Thomas Sanchez
//09-12-19
//ba2 cs278
//propositon logic



package lab1;

public class lab2Propositions {
	
	public static char neg(char Tval) {					//negation method
		if(Tval == 'T')									// if true return the opposite
			return 'F';
		else if(Tval == 'F')							// iof false return the opposite
			return 'T';
		else {											
			System.out.println("invalid arg in neg");		//error handling
			return Tval;
		}// of not valid
	}// of neg
	
	
	public static char or(char Val1, char Val2) {	//or method
		if(Val1 == 'T' || Val2 == 'T' ) {			// if val1 or val2 is true return true
			return 'T';
		}// if true with or
		else if(Val1 == 'F' && Val2 == 'F')			// if both are false return false
			return 'F';
		else {
			System.out.println("invalid arg in or");		//error handling
			return Val1;
		}//of invalid
	}// of or
	
	
	
	public static char and(char Val1, char Val2) {			//and method
		if(Val1 == 'T' && Val2 == 'T') {					// if both are true return true
			return 'T';
		}// if true with and
		else if(Val1 == 'F' || Val2 == 'F')					// if one is false return false
			return 'F';
		else {
			System.out.println("invalid arg in and");		//error handling
			return Val1;
		}// if invalid
	}// of and
	
	public static char implies(char Val1, char Val2) {		//implies method
		if(neg(Val1) == 'T' || Val2 == 'T')					//use conditional identiy to determine implies neg(of val) is true or val2 is true return true
			return 'T';
		else if(neg(Val1) == 'F' && Val2 == 'F')			//if both neg of val and val2 is false return false
			return 'F';
		else {
			System.out.println("invalid in implies");		//error hanling character of then T or F
			return Val1;
		}// if invalid
			}// of implies
	
	
	

	public static void main(String[] args) {				//main
		// TODO Auto-generated method stub
			//should keep a counter
		
		//declare p q and r to T
		char p = 'T';
		char q = 'T';
		char r = 'T';
		
		//declare fcount and tcount and initialize
		int fcount = 0;
		int tcount = 0;
		
		
		//print header
		System.out.println("p q r proposition 1");
		System.out.println("____________________");
		
		for(int i = 0; i < 8; i++) {		//go through 8 combinations of truth values
			//use if statements to set value of p q and r based on row and i value
			if(i % 2 != 0) {
				r = 'F';
			}
			if(i < 4)
				p = 'F';
			if(i < 2 || i > 4 && i < 7)
				q = 'F';
			
		
			System.out.print(p+ " " + q + " " + r +" ");		//print the row
			

			
			if(and(implies(neg(p), q), implies(r, p)) == 'T') {			// if statement to count trues
				tcount++;
			}
			else if(and(implies(neg(p), q), implies(r, p)) == 'F') {	//if statement to count false
				fcount++;
			}
			
			System.out.println(and(implies(neg(p), q), implies(r, p)));   //prop 1    print out prop 1 result
			
			//reset pqr for next loop
			p = 'T';
			q = 'T';
			r = 'T';
			
		}// for loop
		
		//after loop print number of true and false
			System.out.println("Number of True: "+ tcount);
			System.out.println("Number of False: "+ fcount);
			//use if statements to check if tautology, contradiction, or neither
			if(tcount == 8)
				System.out.println("Tautology");
			else if(fcount == 8)
				System.out.println("Contradiction");
			else {System.out.println("neither");}
			System.out.println(""); //skip line
			
			//------------------------------------------------start of prop 2
			//reset
			fcount = 0;
			tcount = 0;
			
			//print header
			System.out.println("p q r proposition 2");
			System.out.println("____________________");
			//go through 8 combinations of truth values
			//use if statements to set value of p q and r based on row and i value
			for(int i = 0; i < 8; i++) {
				if(i % 2 != 0) {
					r = 'F';
				}
				if(i < 4)
					p = 'F';
				if(i < 2 || i > 4 && i < 7)
					q = 'F';
				
			
				System.out.print(p+ " " + q + " " + r +" ");		//printn the row
				
				
				if(and(or(p,neg(q)),or(r, neg(implies(p,q)))) == 'T') {	// if statement to count trues
					tcount++;
				}
				else if(and(or(p,neg(q)),or(r, neg(implies(p,q)))) == 'F') {	// if statement to count false
					fcount++;
				}
				
				System.out.println(and(or(p,neg(q)),or(r, neg(implies(p,q)))));   //prop 2
				
				p = 'T';
				q = 'T';
				r = 'T';
			}// for loop
			//after loop print number of true and false
				System.out.println("Number of True: "+ tcount);
				System.out.println("Number of False: "+ fcount);
				//use if statements to check if tautology, contradiction, or neither
				if(tcount == 8)
				if(tcount == 8)
					System.out.println("Tautology");
				else if(fcount == 8)
					System.out.println("Contradiction");
				else {System.out.println("neither");}
				System.out.println("");
			
				//------------------------------------------start of prop3,  repeat of one and two with different proposition
				
				fcount = 0;
				tcount = 0;
				
				System.out.println("p q r proposition 3");
				System.out.println("____________________");
				for(int i = 0; i < 8; i++) {
					if(i % 2 != 0) {
						r = 'F';
					}
					if(i < 4)
						p = 'F';
					if(i < 2 || i > 4 && i < 7)
						q = 'F';
					
				
					System.out.print(p+ " " + q + " " + r +" ");
					
					//implies(p, implies(neg(and(p, neg(q))), and(p, q)));
					
					
					if(implies(p, implies(neg(and(p, neg(q))), and(p, q))) == 'T') {
						tcount++;
					}
					else if(implies(p, implies(neg(and(p, neg(q))), and(p, q))) == 'F') {
						fcount++;
					}
					
					System.out.println(implies(p, implies(neg(and(p, neg(q))), and(p, q))));   //prop 3
					
					p = 'T';
					q = 'T';
					r = 'T';
				}// for loop
					System.out.println("Number of True: "+ tcount);
					System.out.println("Number of False: "+ fcount);
					if(tcount == 8)
						System.out.println("Tautology");
					else if(fcount == 8)
						System.out.println("Contradiction");
					else {System.out.println("neither");}
					System.out.println("");
					
					//------------------------------------start of prop 4,   repeat of one and two with different proposition
					
					
					fcount = 0;
					tcount = 0;
					
					System.out.println("p q r proposition 4");
					System.out.println("____________________");
					for(int i = 0; i < 8; i++) {
						if(i % 2 != 0) {
							r = 'F';
						}
						if(i < 4)
							p = 'F';
						if(i < 2 || i > 4 && i < 7)
							q = 'F';
						
					
						System.out.print(p+ " " + q + " " + r +" ");
						
						//and(and(p,implies(p, q)),neg(q));
						
						
						if(and(and(p,implies(p, q)),neg(q)) == 'T') {
							tcount++;
						}
						else if(and(and(p,implies(p, q)),neg(q)) == 'F') {
							fcount++;
						}
						
						System.out.println(and(and(p,implies(p, q)),neg(q)));   //prop 4
						
						p = 'T';
						q = 'T';
						r = 'T';
					}// for loop
						System.out.println("Number of True: "+ tcount);
						System.out.println("Number of False: "+ fcount);
						if(tcount == 8)
							System.out.println("Tautology");
						else if(fcount == 8)
							System.out.println("Contradiction");
						else {System.out.println("neither");}
						System.out.println("");
			
	   
	}// of main

}
