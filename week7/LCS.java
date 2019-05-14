// Longest common subsequence
public class LCS {
    
    static String X = "CART";
    
    static String Y = "CAR";
    
    // m is an index of a; n is an index of b
    private static int lcs(String a, String b, int m, int n) {
        // stop condition
        if (m == 0 || n == 0) {
            return 0; 
        }
        
        if (a.charAt(m - 1) == b.charAt(n - 1)) {
            System.out.format("m=%d, n=%d\n", m, n);
            return lcs(a, b, m - 1, n - 1) + 1;
        }
        
        return Math.max(lcs(a, b, m - 1, n), lcs(a, b, m, n - 1));
    }

    public static void main(String []args){
        System.out.println(lcs(X, Y, X.length(), Y.length()));
    }
}
