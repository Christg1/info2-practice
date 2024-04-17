import java.util.Random;

public class MCSSResult {
    public int sum;
    public int start;
    public int end;

    public String toString() {
        return "sum: " + sum + " start: " + start + " end: " + end;
    }

    static MCSSResult mcss1(int[] a) {
        int sum = 0;
        int start = -1;
        int end = -1;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += a[k];
                    if (thisSum > sum) {
                        sum = thisSum;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        MCSSResult res = new MCSSResult();
        res.sum = sum;
        res.start = start;
        res.end = end;
        return res;
    }

    static MCSSResult mcss2(int[] a) {
        int sum = 0;
        int start = -1;
        int end = -1;

        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > sum) {
                    sum = thisSum;
                    start = i;
                    end = j;
                }
            }
        }

        MCSSResult res = new MCSSResult();
        res.sum = sum;
        res.start = start;
        res.end = end;
        return res;
    }

    static MCSSResult mcss3(int[] a) {
        int sum = 0;
        int thisSum = 0;
        int start = -1;
        int end = -1;
        int i = 0;

        for (int j = 0; j < a.length; j++) {
            thisSum += a[j];
            if (thisSum > sum) {
                sum = thisSum;
                start = i;
                end = j;
            } else if (thisSum < 0) {
                i = j + 1;
                thisSum = 0;
            }
        }

        MCSSResult res = new MCSSResult();
        res.sum = sum;
        res.start = start;
        res.end = end;
        return res;
    }

    public static void main(String[] args) {
        testMethods(10);
        testMethods(100);
        testMethods(500);
        testMethods(1000);
        testMethods(10000);
        testMethods(100000);
    }

    public static void testMethods(int size) {
        int[] array = generateNumbers(size);

        long startTime, endTime;

        // Measure the time for mcss1
        startTime = System.currentTimeMillis();
        mcss1(array);
        endTime = System.currentTimeMillis();
        System.out.println("Time for mcss1 with " + size + " numbers: " + (endTime - startTime) + " milliseconds");

        // Measure the time for mcss2
        startTime = System.currentTimeMillis();
        mcss2(array);
        endTime = System.currentTimeMillis();
        System.out.println("Time for mcss2 with " + size + " numbers: " + (endTime - startTime) + " milliseconds");

        // Measure the time for mcss3
        startTime = System.currentTimeMillis();
        mcss3(array);
        endTime = System.currentTimeMillis();
        System.out.println("Time for mcss3 with " + size + " numbers: " + (endTime - startTime) + " milliseconds");

        System.out.println(); // Add a newline for better readability
    }

    public static int[] generateNumbers(int n) {
        int[] numbers = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            numbers[i] = rand.nextInt(2001) - 1000; // Generates random integer between -1000 and 1000
        }

        return numbers;
    }
}
