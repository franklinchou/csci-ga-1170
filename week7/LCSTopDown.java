import java.util.HashMap;

// Length of longest common subsequence using "top-down" memoziation
// The problem is first broken up into sub-problems and values
// are then calculated and stored
public class LCSTopDown {
    
    static String X = "CART";
    
    static String Y = "CAR";
    
    static HashMap<String, Integer> lookup = new HashMap<>();
    
    // m is an index of a; n is an index of b
    private static int lcs(String a, String b, int m, int n) {
        // stop condition
        if (m == 0 || n == 0) {
            return 0; 
        }
        
        String key = a.substring(0, m) + "|" + b.substring(0, n);
        
        if (!lookup.containsKey(key)) {
            if (a.charAt(m - 1) == b.charAt(n - 1)) {
                lookup.put(key, lcs(a, b, m - 1, n - 1) + 1);
            } else {
                lookup.put(key, Math.max(lcs(a, b, m - 1, n), lcs(a, b, m, n - 1)));
            }
        }
        
        return lookup.get(key);
    }

    public static void main(String []args){
        System.out.println(lcs(X, Y, X.length(), Y.length()));
        
        System.out.println();
        
        // Print out memoized table
        for (String k: lookup.keySet()) {
            String v = lookup.get(k).toString();  
            System.out.println(k + "=>" + v);  
        } 
        
    }
}
