public class IntegerSquareRoot {
    
    public static void main(String[] args) {
        // find the integer portion of the square root of an
        // integer. i.e., find p = floor(sqrt(n))
        int n = 8;
        int lo = 0;
        int hi = n + 1; 
        assert(n >= 0);
        while (lo < hi) {
            int m = (lo + hi) / 2;
            // System.out.println("m = " + m);
            int sq = m * m;
            if (sq == n) {
                System.out.println(m);
                break;
            } else if (sq < n) {
                lo = m + 1;
            } else if (sq > n) {
                hi = m;
            }
        }
        System.out.println(lo - 1);
    }
    
}
