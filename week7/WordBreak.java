import java.util.List;
import java.util.Arrays;
import java.util.HashSet;

public class WordBreak {
    
    final static String dict[] = {
        "this",
        "th",
        "is",
        "famous",
        "Word",
        "break",
        "b",
        "r", 
        "e", 
        "a",
        "k",
        "br", 
        "bre",
        "brea", 
        "ak",
        "problem"
    };

    final static String sought = "Wordbreakproblem";
    
    public static void naive(List<String> dict, String in, String out) {
        if (in.length() == 0) {
            System.out.println(out);
            return;
        }
        for (int i = 1; i <= in.length() ; i++) {
            String prefix = in.substring(0, i);
            if (dict.contains(prefix)) {
                naive(dict, in.substring(i), out + " " + prefix);
            }
        }
    }
    
    // dp using the memoization method
    public static void dp(List<String> dict, String in) {
        HashSet<String> h = new HashSet<>();
        int i = 1;
        String out = "";
        while (i <= in.length()) {
            String prefix = in.substring(0, i);
            // System.out.println("prefix = " + prefix);
            String lookup = in.substring(0, i - 1);
            // System.out.println("lookup = " + lookup);
            if (!h.contains(lookup) && dict.contains(prefix)) {
                h.add(lookup + prefix);
            }
            out = prefix;
            i += 1;
        }
        System.out.println(out);
    }
    
    
    

    public static void main(String []args){
        long s = System.nanoTime();
        naive(Arrays.asList(dict), sought, ""); // 5905075ns
        // dp(Arrays.asList(dict), sought);  // 676156ns
        long e = System.nanoTime();
        long duration = e - s;
        System.out.printf("time = %dns", duration);
    }
}
