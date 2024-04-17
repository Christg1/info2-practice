import java.util.Iterator;

public class BigOPractice {

	private static int n;
	private static int sum=0;
	
	
	public static void main(String[] args) {
		System.out.print(isPrime(1019842));
	}
	
	// Fragment #1 
	// O(n)
	public static int Big1(int n) {
	for (int i = 0; i < n; i ++) { 
	    sum++;}
	return sum;
	}

	
	// Fragment #2 
	//O(n^2)
	public static int Big2(int n) {
	for ( int i = 0; i < n; i ++) { 
	    for ( int j = 0; j < n; j ++) 
	        sum++;}
	return sum;
	}
/*Outer loop (i = 0):
Inner loop runs from j = 0 to j = 2 (n - i).
Inner loop iterations: 3 times (j = 0, 1, 2).
sum is incremented by 3.
Outer loop (i = 1):
Inner loop runs from j = 1 to j = 2 (n - i).
Inner loop iterations: 2 times (j = 1, 2).
sum is incremented by 2.
Outer loop (i = 2):
Inner loop runs only once (j = 2).
sum is incremented by 1.
The final value of sum will be 3 + 2 + 1 = 6.*/
	// Fragment #3 
	//O(n^2)
	public static int Big3(int n) {
	for ( int i = 0; i < n; i ++) {
	    for ( int j = i; j < n; j ++) 
	        sum++;}
	return sum;
	}

	// Fragment #4 
	//0(n^2)
	public static int Big4(int n) {
	for ( int i = 0; i < n; i ++) {
	    sum ++; 
	    for ( int j = 0; j < n; j ++) 
	        sum ++;}
	return sum;
	}

	// Fragment #5 
	//0(n^3) n times through outter loop and n*n times through inner loop
	public static int Big5(int n) {
	for ( int i = 0; i < n; i ++) {
	    for ( int j = 0; j < n*n; j ++) 
	    sum++;}
	return sum;
	}

	// Fragment #6
	//O(n^2))- basically just 2 nested loops
	public static int Big6(int n) {
	for ( int i = 0; i < n; i ++) {
	    for ( int j = 0; j < i; j ++) 
	        sum++;}
	return sum;
	}

	// Fragment #7
	//O(n^5)
	/*The outer loop runs n - 1 times, as it starts from 1 and continues until i < n.
The middle loop runs n * n times, as it iterates from 0 to n * n - 1.
The innermost loop runs j times, which depends on the current value of j.
Let's analyze the number of iterations in each loop:

Outer loop: n - 1 iterations
Middle loop: n * n iterations
Innermost loop: j iterations
To determine the overall time complexity, we need to consider the worst-case scenario. In this case, we assume the maximum number of iterations for each loop.

The outer loop runs n - 1 times, which is in the order of O(n).
The middle loop runs n * n times, which is in the order of O(n^2).
The innermost loop runs a variable number of iterations depending on the value of j. Since j can range from 0 to n * n - 1, the number of iterations for each j value can be approximated as O(n^2). Therefore, the total number of iterations of the innermost loop is in the order of O(n^2).
Combining the time complexities of each loop, the overall time complexity of the Big7 method is the product of the time complexities of the nested loops: O(n) * O(n^2) * O(n^2) = O(n^5)
*/
	public static int Big7(int n) {
	for ( int i = 1; i < n; i ++) {
	    for ( int j = 0; j < n*n; j ++) 
	        if (j % i == 0) 
	           for (int k = 0; k < j; k++) 
	               sum++;}
	return sum;
	}

	// Fragment #8 
	//O(log n)
	public static int Big8(int n) {
	int i = n;
	while (i > 1) { 
	    i = i / 2; 
	    sum++; 
	}
	return sum;
	}
//O(sqqrt(n))
//The relationship between the number of bits B and the decimal 
	//value N can be determined using the formula B = ⌈log2(N)⌉
	public static boolean isPrime(int n) {
		
		if(n<=0) {
			
				return false;
			}
		
		for (int i=2; i<=Math.sqrt(n);i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
			}
	}
