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
        while (n >= 0) {
            if (n - d >= 0) {
                q += 1;
            } else {
                r = n;
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
