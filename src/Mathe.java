import java.util.Arrays;

public class Mathe {
	
	public static void main(String[] args) {
        int n = 1000000;
        long startTime = System.nanoTime();
        int primeCount = countPrimes(n);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Anzahl der Primzahlen (countPrimes): " + primeCount);
        System.out.println("Zeit (countPrimes): " + duration + " ns");

        startTime = System.nanoTime();
        boolean[] primes = eratosthenes(n);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        int sieveCount = 0;
        for (boolean prime : primes) {
            if (prime) {
                sieveCount++;
            }
        }
        System.out.println("Anzahl der Primzahlen (eratosthenes): " + sieveCount);
        System.out.println("Zeit (eratosthenes): " + duration + " ns");
        sieveOfEratosthenes2(1000000);
    
	}

	
	    public static boolean isPrime(int p) {
	        if (p <= 1) {
	            return false;
	        }
	        for (int i = 2; i <= Math.sqrt(p); i++) {
	            if (p % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public static int countPrimes(int n) {
	        int count = 0;
	        for (int i = 2; i <= n; i++) {
	            if (isPrime(i)) {
	                count++;
	            }
	        }
	        return count;
	    }

	    public static boolean[] eratosthenes(int n) {
	        boolean[] P = new boolean[n + 1];
	        Arrays.fill(P, true);

	        P[0] = P[1] = false; // 0 und 1 sind keine Primzahlen

	        for (int i = 2; i * i <= n; i++) {
	            if (P[i]) {
	                for (int j = i * i; j <= n; j += i) {
	                    P[j] = false;
	                }
	            }
	        }

	        return P;
	    }

	    public static void sieveOfEratosthenes2(int n) {
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


