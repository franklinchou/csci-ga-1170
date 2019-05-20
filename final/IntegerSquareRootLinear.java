public class IntegerSquareRootLinear {
    
    public static int solve(int n) {
        int i = 1;
        assert(n > 1);
        while (i < n) {
            int sq = i * i;
            if (sq == n) {
                return i;
            }
            if (sq > n) {
                return i - 1;
            }
            i += 1;
        }
        return i - 1;
    }
    
    public static void main(String[] args) {
        System.out.println(solve(26));
    }
}
