// CLRS 32.1-2
// HW 8, problem #1
public class DistinctPatternMatcher {
    
    static void matcher(String T, String P) {
        if (P.length() > T.length()) {
            System.out.println("No matches found!");
            return;
        }
        // Match in O(N) time on N-character text T
        int j = 0;
        while (j <= T.length() - P.length()) {
            int i = 0;
            // Go to the first matching item of P in T
            while (i < P.length() && P.charAt(i) == T.charAt(j + i)) {
                i += 1;
                if (i == P.length()) {
                    System.out.println("Found");
                    break;
                }
            }
            j = Math.max(j + 1, j + i - 1);
        }
        return;
    }
    

    public static void main(String []args){
        String T = "allcharactersdifferent";
        String P = "lchar";
        matcher(T, P);
    }
}
