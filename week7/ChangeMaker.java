import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;

// Given an unlimited # of coins with denominations starting at the penny
// And some amount of money, M, determine the least number of coins
// that can produce M
public class ChangeMaker {
    
    final static int denominations[] = {
        1, 5, 10, 25, 100
    };
    
    // bottom up approach
    public static void dp(int[] d, int M) {
        HashMap<Integer, List<Integer>> lookup = new HashMap<>();
        assert(M > 1);
        int m = 1;
        int current = 1; // The denomination currently being evaluated
        while (m <= M) {
            List<Integer> prior = lookup.get(m - 1);
            if (prior == null) {
                prior = new LinkedList<Integer>();
            }
            
            for (int i = denominations.length - 1; i >= 0; i--) {
                if (m / denominations[i] == 1) {
                    current = denominations[i];
                }
            }
            
            // case of simply adding 1 to the list:
            // prior.size() + 1
            if (prior.size() + 1 > m / current && m - current > 0) {
                int remaining = m - current;
                lookup.get(remaining);
                prior.add(current);
                lookup.put(m, prior);
                System.out.printf("m=%d\n", m);
            } else if (prior.size() + 1 > m / current) {
                Integer arr[] = { current };
                lookup.put(m, new LinkedList<>(Arrays.asList(arr)));
                System.out.printf("m=%d, M=%s\n", m, lookup.get(m));
            } else {
                prior.add(1);
                lookup.put(m, prior);
            }
            m += 1;
        }
        System.out.println(lookup.get(M).toString());
    }
    
    public static void main(String[] args) {
        dp(denominations, 26);
    }
}
