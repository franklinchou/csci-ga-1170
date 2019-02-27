import java.util.Arrays;

// Run with:
// javac CountingSort.java
// java CountingSort
// Counting sort assumes that the input consists of integers over
// a small range.
class CountingSort {

    // used to find the upper range of an array to be sorted
    static int upper(int[] arr) {
        int max = 0;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max + 1;
    }

    static int[] sort(int[] a) {
        int upper = upper(a);
        int[] sorted = new int[a.length];
        int[] c = new int[upper];

        // count
        for (int value : a) {
            c[value]++;
        }
	System.out.println(String.format("Count = %s", Arrays.toString(c)));

        // keep a running sum of, at i, how many items are to the left of i
        for (int i = 1; i < upper; i++) {
          c[i] = c[i] + c[i - 1];
        }
	System.out.println(String.format("Items >= index, %s", Arrays.toString(c)));

        for (int i = a.length - 1; i >= 0; i--) {
            sorted[c[a[i]] - 1] = a[i];
            c[a[i]] = c[a[i]] - 1;
        }
	System.out.println(String.format("C = %s", Arrays.toString(c)));

        return sorted;
    }


    public static void main(String[] args) {
        int[] a = {4, 6, 3, 5, 0, 5, 1, 3, 5, 5};
        // int[] a = {2, 5, 3, 0, 2, 3, 0, 3};
        int[] sorted = sort(a);
        System.out.println(Arrays.toString(sorted));
    }
}
