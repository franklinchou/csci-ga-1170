import java.util.HashMap;
import java.util.Arrays;

// Length of longest common subsequence using "bottom up" memoziation
public class LCSBottomUp {
    
    static String X = "XMJYAUZ";
    
    static String Y = "MZJAWXU";
    
    // m is an index of a; n is an index of b
    private static void lcs(String a, String b) {
        // stop condition
        int m = a.length() + 1; // Row
        int n = b.length() + 1; // Column
        
        // The lookup actually stores the number of shared
        // values between two substrings. E.g., in ABBA and PBCA
        // ABB[A] => 0,1,1,2
        // The second A in ABBA matches:
        // - B in PBCA
        // - A in PBCA
        // Even though the continuous substring is separated by C
        int[][] lookup = new int[m][n];
        
        // initialize the lookup table
        // the first row and the first column must be 0
        // such that the "previous" value for the first
        // character in the string = 0
        for (int i = 0; i < m; i++) {
            lookup[i][0] = 0;
        }
        
        for (int j = 0; j < n; j++) {
            lookup[0][j] = 0;
        }
        
        // I feel like this is the least intuitive way...
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // see lookup table initialization
                int previous = lookup[i][j - 1];
                if (a.substring(i - 1, i).equals(b.substring(j - 1, j))) {
                    // If there is a match, the diagonal serves as
                    // the memoized maximum number of shared characters
                    // prior to a match being discovered.
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                } else {
                    // If there is no match, look up the largest number of
                    // characters that were matching up until that character
                    // was discovered (since we are looking for the longest
                    // common subsequence).
                    lookup[i][j] = Math.max(lookup[i - 1][j], lookup[i][j - 1]);
                }
            }
        }
        
        for (int k = 0; k < m; k++) {
            int[] row = lookup[k];
            System.out.println(Arrays.toString(row));
        }
        
        // TODO Backtrace
    }

    public static void main(String []args){
        lcs(X, Y);
    }
}
