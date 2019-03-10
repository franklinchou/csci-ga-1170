import java.util.Arrays;

class HeapArray {
    
    int heap[];
    int heapSize = 0;

    public HeapArray(int size) {
        heap = new int[size];
    }
    
    int left(int i) {
        return 2 * i + 1;
    }
    
    int right(int i) {
        return 2 * i + 2;
    }
    
    int parent(int i) {
        if (i % 2 == 0) {
            return (i - 1) / 2;
        } else {
            return  i / 2;
        }
    }
    
    // in order to sort in ascending order (natural order)
    // a MIN heap must be used
    void minHeapify(int i) {
        int leftIndex = left(i);
        int rightIndex = right(i);
        int minIndex;
        if (leftIndex < heapSize && heap[leftIndex] < heap[i]) {
            minIndex = leftIndex;
        } else {
            minIndex = i;
        }
        if (rightIndex < heapSize && heap[rightIndex] < heap[minIndex]) {
            minIndex = rightIndex;
        }
        // if the root is not the minimum index, swap the item
        // at the minimum index with the root
        if (minIndex != i) {
            int t = heap[i];
            heap[i] = heap[minIndex];
            heap[minIndex] = t;
            // perform heapify on the new minimum
            minHeapify(minIndex);
        }
    }
    
    // add a subarray to the heap and enforce the heap condition
    void add2Heap(int[] subA) {
        for (int j = 0; j < subA.length; j++) {
            heap[heapSize + j] = subA[j];
        }
        heapSize += subA.length;
        minHeapify((heapSize - 2) / 2);
    }
    
    int removeMin() {
        int min = heap[0];
        heap[0] = heap[heapSize - 1];
        heapSize -= 1;
        minHeapify(0);
        return min;
    }
    
}

public class HeapCombine {
    
    public static void main(String args[]) {
        // arrays must contain counting numbers only
        int arr1[] = {3, 7, 8, 9, 12, 19};
        int arr2[] = {4, 9, 15, 16, 26, 27};
        int arr3[] = {1, 1, 8, 19, 20, 22}; 
        int total = arr1.length + arr2.length + arr3.length;
        assert(arr1.length == arr2.length && arr2.length == arr3.length);
        HeapArray h = new HeapArray(total); 
        for (int i = 0; i < arr1.length; i++) {
            int t[] = {arr1[i], arr2[i], arr3[i]};
            h.add2Heap(t);
        }
        // System.out.println(Arrays.toString(h.heap));
        
        while(h.heapSize > 0) {
            System.out.println(h.removeMin());
        }
    }
    
}
