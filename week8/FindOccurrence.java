public class FindOccurrence {
    
    final static char SPECIAL = '♢';
    
    // T = Text, P = Pattern
    static boolean findOccurrence(String T, String P, int t, int p) {
        if (p == P.length()) {
            return true;
        }
        
        if (t == T.length()) {
            return false;
        }
        
        if (P.charAt(p) == SPECIAL) {
            return findOccurrence(T, P, t + 1, p) || 
                findOccurrence(T, P, t, p + 1);
        } else if (T.charAt(t) == P.charAt(p)) {
            return findOccurrence(T, P, t + 1, p + 1);
        } else if (p == 0) {
            // on first iteration, if pattern is not matched, increment
            // text only
            return findOccurrence(T, P, t + 1, p);
        }
        return false;
    }

    public static void main(String []args){
        String T = "aabdc";
        String P = "ab♢c";
        // TODO Fix. This won't work in the above circumstance.
        // Possibly due to greedy matching?
        System.out.println(findOccurrence(T, P, 0, 0));
    }
}
