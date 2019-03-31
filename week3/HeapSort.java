import java.util.Arrays;

class HeapArray {

    int heapSize;

    // the array in which to store the heap
    int[] arr;

    // Create a heap array from an array
    public HeapArray(int[] n) {
        arr = n;
        heapSize = 0;
    }

    // Given a node, get the index of the left child
    Integer getLeft(int i) {
        int l = 2 * i + 1;
        if (l > arr.length - 1) {
            return null;
        }
        return l;
    }

    // Given a node, get the index of the right child
    Integer getRight(int i) {
        int r = 2 * i + 2;
        if (r > arr.length - 1) {
            return null;
        }
        return r;
    }

    // `size` represents the internal capacity of the array
    // `heapSize` represents the elements that satisfy the heap condition
    // 0 <= heapSize <= size
    int getHeapSize() {
        return heapSize;
    }

    // propagate the max heap condition down the tree
    void maxHeapify(int i) {
        Integer l = getLeft(i);
        Integer r = getRight(i);

        // the position at i should be the largest
        int largestIndex;
        if (l != null && arr[l] > arr[i] && l <= heapSize - 1) {
            largestIndex = l;
        } else {
            largestIndex = i;
        }

        if (r != null && arr[r] > arr[largestIndex] && r <= heapSize - 1) {
            largestIndex = r;
        }

        if (arr[i] != arr[largestIndex]) {
            int temp = arr[i];
            arr[i] = arr[largestIndex];
            arr[largestIndex] = temp;
            maxHeapify(largestIndex);
        }

    }

    void buildMaxHeap() {
        heapSize = arr.length;

        // Heapify by applying the max heap condition to all non-leaf elements.
        // Leaves (nodes with no children) for an n-element heap stored in a 0-indexed array will start at
        // floor((n - 1) / 2) + 1, so the lowest level node that is NOT a leaf will start at:
        // floor((n - 1) / 2
        for (int i = ((arr.length - 1)/ 2); i > 0; i--) {
            maxHeapify(i);
        }
    }


    void heapSort() {
        // first, enforce the heap condition
        buildMaxHeap();
        heapSize = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];

            // since the array is already a max heap, the root node is the largest element
            arr[i] = arr[0];
            arr[0] = temp;

            // enforce the max heap condition on the subarray
            heapSize--;
            maxHeapify(0);
        }
    }

}


// Run with:
// javac HeapSort.java
// java HeapSort
class HeapSort {

    public static void main(String[] args) {

	// [17, 15, 11, 14, 7, 2, 4, 3, 5, 19]
	// [15, 14, 11, 5, 7, 2, 4, 3, 17, 19]
	// [14, 7, 11, 5, 3, 2, 4, 15, 17, 19]
	// [11, 7, 4, 5, 3, 2, 14, 15, 17, 19]
	// [7, 5, 4, 2, 3, 11, 14, 15, 17, 19]
	// [5, 3, 4, 2, 7, 11, 14, 15, 17, 19]
	// [4, 3, 2, 5, 7, 11, 14, 15, 17, 19]
	// [3, 2, 4, 5, 7, 11, 14, 15, 17, 19]
	// [2, 3, 4, 5, 7, 11, 14, 15, 17, 19]
        int[] a = {19, 2, 11, 14, 7, 17, 4, 3, 5, 15};
        HeapArray h = new HeapArray(a);

        h.heapSort();
        System.out.println(Arrays.toString(a));

    }
}
