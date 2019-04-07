 public class RodCuttingR {
    
    // solve the rod cutting problem recursively
    // return the maximum obtainable value
    static int cutRod(int[] price, int n) {
        if (n <= 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int p = price[i] + cutRod(price, n - i - 1);
            max = Math.max(max, p);
        }
        return max;
    }
    
    public static void main(String[] args) {
        int t[] = {1, 5, 8 , 9, 10, 17, 17, 20, 21, 22, 23, 20, 25};
        int size = t.length;
        long start = System.nanoTime();
        int max = cutRod(t, size);
        long end = System.nanoTime();
        // Averages about 2M nanoseconds
        System.out.println("Runtime = " + (end - start) + "ns");
    }
}
