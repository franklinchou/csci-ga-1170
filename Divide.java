// Implement integer division using repeated subtraction
public class Divide {
    
    static class R {
        public int q;
        public int r;
        
        public R (int q, int r) {
            this.q = q;
            this.r = r;
        }
    }
    
    static R divide(int n, int d) {
        int q = 0;
        int r = 0;
        // INVARIANT: At the start of iteration i of the loop:
        // - q will hold the number of times n has been subtracted by d
        // - r will be 0 (if r > 0, the loop has already exited)
        // - n will hold the remainder of n - di subractions
        // INITIALIZATION: At the start of iteration i = 0, q will hold
        // the number of times n has been subtracted by d, in this case 0;
        // r = 0; and n = n - d*0 subractions or n.
        while (n >= 0) {
            // MAINTENANCE: Assume that the loop invariant is true, then it 
            // must be true that q holds the number of times n has been
            // subracted by d. In the body of the loop, n is subtracted by 
            // the ith time, resulting in n - d*i and r = 0. The loop invariant 
            // is maintained for subsequent iterations of i.
            if (n - d >= 0) {
                q += 1;
            } else {
                r = n;
                // TERMINATION: There are two termination conditions:
                // (a) the value of n is completely depleted by d*i subtractions,
                // in that case, n represents n-d*i subtractions and r = 0, the 
                // loop invariant holds and the loop terminates; or (b) the value 
                // of the (n - d*i)th subraction is negative indicating there
                // is a remainder. In that case n still represents n-d*i "full"
                // subtractions, r is set to the overflow and loop is terminated.
                // Since the loop is never reinitialized with a non-zero value, 
                // the loop invariant on r holds.
                break;
            }
            n -= d;
        }
        return new R(q, r);
    }
    
    public static void main(String args[]) {
        R r = divide(12, 4);
        System.out.println("q = " + r.q);
        System.out.println("r = " + r.r);
    }
    
}
