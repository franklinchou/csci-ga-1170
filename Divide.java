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
    
    // INVARIANT: Before any iteration of the loop, q * d + r = n
    static R divide(int n, int d) {
        int q = 0;
        int r = n;
        // Initialization
        // Before the first iteration, q = 0; r = n
        // so q * d + r = n 
        while (r >= d) {
            q += 1;
            r = r - d;
        }
        return new R(q, r);
    }
    
    public static void main(String args[]) {
        R r = divide(15, 4);
        System.out.println("q = " + r.q);
        System.out.println("r = " + r.r);
    }
    
}
