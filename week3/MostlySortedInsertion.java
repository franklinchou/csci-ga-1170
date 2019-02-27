import java.util.Arrays;

// Run with:
// javac MostlySortedInsertion.java
// java MostlySortedInsertion
class MostlySortedInsertion {

    static void sort(int[] arr) {
        int unsorted = arr.length - 1; // only the last item is unsorted
        int j = 0;
        while (j < arr.length - 1) {
            if (arr[unsorted] <= arr[j]) {
                break;
            }
            j++;
        }
        int t = arr[j];
        arr[j] = arr[unsorted];
        for (int i = j + 1; i < arr.length; i++) {
            int q = arr[i];
            arr[i] = t;
            t = q;
        }
        arr[j] = t;

    }

    public static void main(String[] args) {
        int[] arr = {8, 9, 10, 11, 12, 13, 14, 1}; // Mostly sorted array (only last item unsorted)
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
