public class NaiveStringMatcher {
    static void naiveMatcher(String T, String P) {
		if (P.length() > T.length()) {
		    System.out.println("No matches found!");
        }
        for (int i = 0; i <= T.length() - P.length(); i++) {
            int term = i + P.length();
            // Substring doesn't include the last index, i.e.,
            // "LIST" from (0, 3) = "LIS"
            if (T.substring(i, term).equals(P)) {
                System.out.println("Pattern matched at idnex = " + i);
            }
        }
        return;
    }

    public static void main(String[] args) {
        String T = "AABAACAADAABAABA";
        String P = "AABA";
        naiveMatcher(T, P);
    }
}
            
