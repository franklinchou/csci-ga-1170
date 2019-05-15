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
                    // 
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                } else {
                    //
                    lookup[i][j] = Math.max(lookup[i - 1][j], lookup[i][j - 1]);
                }
            }
        }
        
        for (int k = 0; k < m; k++) {
            int[] row = lookup[k];
            System.out.println(Arrays.toString(row));
        }
        
    }

    public static void main(String []args){
        lcs(X, Y);
    }
}
