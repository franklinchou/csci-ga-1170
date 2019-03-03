import java.util.Arrays;

class Partition {

    static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
	int i = p - 1; // i denotes the boundary of the partition where all values are less than x

        for (int j = p; j <= r - 1 ; j ++) {
            if (arr[j] <= pivot) {
                i += 1;
                // swap A[i] & A[j] such that the value at j is in the "less than or equal" portion of the array
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        // swap A[i + 1] with A[r]
        int t = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = t;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] a = {19, 2, 11, 14, 7, 17, 4, 3, 5, 15};
	System.out.println("pre-partition: " + Arrays.toString(a));
        int p = partition(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
	System.out.println("pivot = " + p);
    }
}
