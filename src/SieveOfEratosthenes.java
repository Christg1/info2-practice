import java.util.Arrays;

import javax.lang.model.util.Elements;


public class SieveOfEratosthenes {
	// O(N log(log(n))
	public static void main(String[] args) {
		sieveOfEratosthenes(100);
	}
	
	public static void sieveOfEratosthenes(int n) {
		boolean [] isPrime = new boolean [n+1]; //check numbers from 0 to n+1.n+1 because of array index 0
		Arrays.fill(isPrime, true); //initialize all Elements of the array to true
		
		for(int i = 2; i*i <=n;i++) { //iterate over all numbers fron 2 to i^2.
			if(isPrime[i]) { //if isPrime[i] is a prime, then 
				for(int j = i*i; j<=n; j+=i) { //all multiples of i are marked as false.
					isPrime[j] = false; //start marking multipled from i*i and increment by i each iteration.
				}
			}
		}
		for (int i = 2; i <=n; i++) {
			if (isPrime[i]) { //dont need to write if(isPrime[i]==true),
				//it is automatically assumes that this equates to true.
				System.out.print(i + " ");
			}
		}
	}

}
