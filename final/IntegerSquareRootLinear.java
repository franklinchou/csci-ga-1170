public class IntegerSquareRootLinear {
    
    public static int solve(int n) {
        int i = 1;
        assert(n > 1);
        while (i * i <= n) {
            i += 1;
        }
       return i - 1;
    }
    
    public static void main(String[] args) {
        System.out.println(solve(89));
    }
}
