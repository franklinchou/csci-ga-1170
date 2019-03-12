import java.util.Arrays;

// Given n integers in [0, k] how many of them fall into
// range [a, b] for some a & b? 
public class ModifiedCount {
    
    // Accepts an array of n integers in range [0, k] and spends
    // Theta(n + k) time, returning preprocessed output P
    private static int[] preprocess(int[] arr, int n, int k) {
        int p[] = new int[k + 1];
        // This loop will count the number of items appearing
        // for each value, i.e., there will be 3, 3s & 1, 0.
        for (int i = 0; i < n; i++) {
            p[arr[i]] = p[arr[i]] + 1;
        }
        // This loop aggregates each value against the number
        // prior, if there is 1, 0 and 3, 1s, then the number
        // of items less than or equal to 1 = 4, p[1] => 4.
        for (int j = 1; j < p.length; j++) {
            p[j] = p[j] + p[j - 1];
        }
        return p;
    }
    
    // Take preprocessed array and range [a, b] and returns
    // the number of original integers in the supplied array that
    // fall into [a, b] in Theta(1) time
    private static int query(int[] p, int a, int b) {
        return p[b] - p[a];
    }
    
    public static void main(String args[]) {
        int arr[] = {0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5};
        int p[] = preprocess(arr, arr.length, 5);
        // System.out.println(Arrays.toString(p));
        System.out.println(query(p, 0, 1));
    }
    
}
