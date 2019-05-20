// This runs in logarithmic time (similar implementation
// to binary search)
public class IntegerSquareRoot {
    
    public static void main(String[] args) {
        // find the integer portion of the square root of an
        // integer. i.e., find p = floor(sqrt(n))
        int n = 8;
        int lo = 0;
        int hi = n + 1; 
        assert(n >= 0);

        // INVARIANT = 
        // At the start of each iteration of the while loop
        // lo - 1 < sqrt(n) <= hi
        while (lo < hi) {
            int m = (lo + hi) / 2;
            // System.out.println("m = " + m);
            int sq = m * m;
            
            // MAINTENANCE =
            // If m * m == n, => m = sqrt(n) and n is a perfect
            // square; lo, hi and m are unchanged and the loop
            // invariant is unchanged.
            if (sq == n) {
                System.out.println(m);
                break;
            // MAINTENANCE =
            // If m * m < n => m < sqrt(n); the estimate is LESS
            // THAN the correct answer, adjust the value of lo s.t.
            // m + 1 < sqrt(n) <= hi
            } else if (sq < n) {
                lo = m + 1;
            // MAINTENANCE =
            // If m * m > n => m > sqrt(n); the estimate is GREATER
            // THAN the correct answer, adjust the value of hi s.t.
            // lo - 1 < sqrt(n) <= m
            // This satisfies the entry condition, m > sqrt(n).
            } else if (sq > n) {
                hi = m;
            }
        }
        // TERMINATION =
        // At termination lo >= hi due to the loop entry condition.
        // Combined with the loop invariant, we have:
        // lo - 1 < sqrt(n) <= hi <= lo
        // lo - 1 < sqrt(n) <= lo
        // lo = Ceil(sqrt(n))
        // n is not a perfect square, otherwise the program
        // would have terminated in the first `if` condition.
        // Therefore, sqrt(n) is not an integer and
        // lo - 1 = Floor(sqrt(n)).
        System.out.println(lo - 1);
    }
    
}
