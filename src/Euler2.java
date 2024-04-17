
public class Euler2 {

	public static void main(String[] args) {
		
	//System.out.print(evenFib());
	//System.out.print(sd(4711));
	//System.out.print(sdd(4711,0));
triangle2(5);
triangle1(5);
	printSquare(5);
	}
	
	
	public static int evenFib() {
	    int limit = 4000000;
	    int sum = 0;
	    int one = 1;
	    int two = 2;

	    while (one < limit) {
	        if (one % 2 == 0) {
	            sum += one;
	        }

	        int nextFib = one + two;
	        one = two;
	        two = nextFib;
	    }

	    return sum;
	}


public static int sd(int n) {
	  if (n <10) {
	    return n;
	  }
	  return n % 10 + sd(n / 10);
	}

static int sdd(int n, int acc) {
    if (n == 0) {
        return acc;
    }
    return sdd(n / 10, acc + n % 10);
}
static void triangle2(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            System.out.print(" ");
        }
        for (int j = i; j < n; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
static void triangle1(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i + 1; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
static void printSquare(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 5; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}



}
