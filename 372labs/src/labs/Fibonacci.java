package labs;
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			test1();
			test2();
	}
	
	public static long FIB1(long n) {
		if(n == 0) return n;
		if(n == 1) return n;
		
		return(FIB1(n-1)+FIB1(n-2));
	}// of fibonacci exponential
	
	public static long FIB2(long n) {
		if(n==0) return 0;
		
		long a[] = new long[(int) n + 1];
		
		a[0] = 0;
		a[1] = 1;
		
		
		for(int i = 2; i <= n; i++) {
			a[i] = a[i -1] + a[i-2];
		}// of for
			return a[(int) n];
	}// fibonacci polynomial

	
	public static void test1() {
		int[] Answer = {0,1,1,2,3,5,8,13,21,34,55};
		
		for(int i = 0; i <= 10; i++) {
			if(Answer[i] != FIB1(i)) {System.out.println("Error, FIB1 Failed ");
			return;}
		}// of for
		System.out.println("FIB1 Passed");
	}// of test 1
	
	public static void test2() {
		int[] Answer = {0,1,1,2,3,5,8,13,21,34,55};
		
		for(int i = 0; i <= 10; i++) {
			if(Answer[i] != FIB2(i)) {System.out.println("Error, FIB2 Failed ");
			return;}
		}// of for
		System.out.println("FIB2 Passed");
	}// of test 1
	
	
	
}// of class
