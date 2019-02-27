import java.util.Arrays;

// Run with:
// javac RadixSort.java
// java RadixSort
class RadixSort {

    static void stableSort(int[] a, int exp) {
        int[] sorted = new int[a.length];
        int[] c = new int[10];

        Arrays.fill(c, 0);

        // count
        for (int value : a) {
            int i = (value / exp) % 10;
            c[i]++;
        }

        // keep a running sum of, at i, how many items are to the left of i
        for (int i = 1; i < 10; i++) {
            c[i] = c[i] + c[i - 1];
        }

        for (int i = a.length - 1; i >= 0; i--) {
            int j = (a[i] / exp) % 10;
            sorted[c[j] - 1] = a[i];
            c[j] = c[j] - 1;
        }

        for (int i = 0; i < sorted.length; i++) {
            a[i] = sorted[i];
        }
    }


    // d = number of places, 100 = 3, 1000 = 4
    static void radixSort(int[] a, int d) {
        int end = 1;
        for (int i = 0; i < d; i++) {
            end *= 10;
        }

        for (int exp = 1; exp < end; exp *= 10) {
            stableSort(a, exp);
            System.out.println(Arrays.toString(a));
        }
    }


    public static void main(String[] args) {
        // int[] a = {1267, 6399, 8097, 6391, 4606};
        int[] a = {392, 517, 364, 931, 726, 912, 299, 250, 600, 185};
        radixSort(a, 3);
        // radixSort(a, 4);
    }
}
