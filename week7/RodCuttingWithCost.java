import java.util.Arrays;

public class RodCuttingWithCost {
    
    static final int c = 1;
    
    // solve the rod cutting problem with DP
    // return the maximum obtainable value
    static int cutRod(int[] price, int n) {
        // set up the memoization table
        int m[] = new int[n + 1];
        m[0] = 0;
        
        // build bottom up
        for (int i = 1; i <= n; i++) {
            // deal with the case of no cuts
            int max = price[i - 1];
            for (int j = 0; j < i - 1; j++) {
                max = Math.max(max, price[j] + m[i - j - 1] - c);
            }
            m[i] = max;
        }
        // System.out.println(Arrays.toString(m));
        return m[n];
    }
    
    public static void main(String[] args) {
        int t[] = {1, 5, 8 , 9, 10, 17, 17, 90, 21, 22, 23, 20, 25};
        int size = t.length;
        long start = System.nanoTime();
        int max = cutRod(t, size);
        long end = System.nanoTime();
        // Averages about 38K nanoseconds
        System.out.println("Max = " + max);
        System.out.println("Runtime = " + (end - start) + "ns");
    }
}
