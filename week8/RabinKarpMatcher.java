import java.util.ArrayList;

public class RabinKarpMatcher {

    static final int MOD = 11;

    // Suprious hit occurs when the hash matches, but the 
    // underlying value does not match
    static boolean match(String s, String p) {
        int patternHash = hash(p, MOD);

        boolean match = false;
        ArrayList < Integer > matches = new ArrayList < Integer > ();
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (hash(s.substring(i, i + p.length()), MOD) == patternHash) {
                matches.add(i);
            }
        }

        for (Integer j: matches) {
            String c = s.substring(j, j + p.length());
            if (c == p) {
                match = true;
            } else {
                System.out.printf("Spurious match at j=%s, %s\n", j, c);
            }
        }

        return match;
    }

    private static Integer hash(String s, int mod) {
        Integer result = null;
        try {
            Integer stringAsInt = Integer.valueOf(s);
            return stringAsInt % mod;
        } catch (NumberFormatException e) {
            System.out.printf("Could not parse %s as integer");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Uncaught exception: " + e);
            System.exit(1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "3141592653589793";
        match(s, "26");
    }
}
