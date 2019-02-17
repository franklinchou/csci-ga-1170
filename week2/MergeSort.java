import java.util.Arrays;

// Run with:
// javac MergeSort.java
// java MergeSort
class MergeSort {

    static void sort(int[] arr, int left, int right) {
        if (right > left) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int leftSize = (mid - left) + 1;
        int rightSize = right - mid;

        // split the array into two based on the position of mid
        int[] arrL = new int[leftSize];
        int[] arrR = new int[rightSize];

        // the subarrays should only ever differ in size by 1 (odd # of elements)
        assert(arrL.length == arrR.length || arrL.length == arrR.length + 1 || arrL.length + 1 == arrR.length);

        for (int i = 0; i < leftSize; i++) {
            arrL[i] = arr[left + i];
        }
        for (int i = 0; i < rightSize; i++) {
            arrR[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;
        // left should always contain a smaller number
        while (i < leftSize && j < rightSize) {
            if (arrL[i] > arrR[j]) {
                arr[k] = arrR[j];
                j++;
            } else {
                arr[k] = arrL[i];
                i++;
            }
            k++;
        }

        while (i < leftSize) {
            arr[k] = arrL[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            arr[k] = arrR[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 2, 1, 4};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
