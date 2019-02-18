import java.util.Arrays;

// Priority Queue implemented with heap data structure
// Each element > 0
class PriorityQueue {

    private class Heap {
        int[] s;

        int heapSize;

        Integer leftChild(int e) {
            int l = 2 * e + 1;
            if (l > s.length - 1) {
                return null;
            }
            return l;
        }

        Integer rightChild(int e) {
            int r = 2 * e + 2;
            if (r > s.length - 1) {
                return null;
            }
            return r;
        }


        Integer parent(int e) {
            if (e < s.length) {
                return e / 2;
            }
            return null;
        }


        Heap(int[] n) {
            s = n;

            // When the heap is created, enforce the max-heapify condition, then
            // we can set the heap size to the array size.
            buildMaxHeap();

            heapSize = n.length;
        }

        void maxHeapify(int e) {
            Integer left = leftChild(e); // index of left child
            Integer right = rightChild(e); // index of right child

            int largestIndex;
            if (left != null && s[left] > s[e] && left <= heapSize - 1) {
                largestIndex = left;
            } else {
                largestIndex = e;
            }
            if (right != null && s[right] > s[largestIndex] && right <= heapSize - 1) {
                largestIndex = right;
            }

            if (s[largestIndex] != s[e]) {
                int largest = s[largestIndex];
                s[largestIndex] = s[e]; // swap the largest index with the current element
                s[e] = largest;
                maxHeapify(largestIndex);
            }
        }

        void buildMaxHeap() {
            heapSize = s.length;

            // start is the lowest node that still has children
            int start = ((s.length - 1) / 2);
            for (int i = start; i != 0; i--) {
                maxHeapify(i);
            }
        }

        void inspectHeap() {
            System.out.println(Arrays.toString(s));
        }

    }

    private Heap h;

    // Create a priority queue from an array
    public PriorityQueue(int[] n) {
        h = new Heap(n);
//        h.inspectHeap();
    }


    private int findFirstOpen() {
        int open = -1;
        for (int i = 0; i < h.s.length; i++) {
            if (h.s[i] == 0) {
                open = i;
                break;
            }
        }
        assert open > -1;
        return open;
    }


    void insert(int e) {
        if (h.heapSize < h.s.length) {
            int open = findFirstOpen();
            h.heapSize++;
            increaseKey(open, e);
        } else {
            throw new StackOverflowError();
        }
        h.inspectHeap();
    }

    int max() {
        return h.s[0];
    }

    int extractMax() {
        int max = max();

        int last = h.heapSize - 1;

        // swap the element in last place with the root
        h.s[0] = h.s[last];

        // fill the removed value with 0
        h.s[last] = 0;
        h.heapSize--;
        h.maxHeapify(0);
        // h.inspectHeap();
        return max;
    }

    // raise the element at i to key
    void increaseKey(int i, int key) {
        if (i < h.s.length && h.s[i] < key) {
            h.s[i] = key;
            while (h.s[h.parent(i)] < h.s[i] && i != 0) {
                int parent = h.parent(i);
                int t = h.s[parent];
                h.s[parent] = key;
                h.s[i] = t;
                i = h.parent(i);
            }
        } else {
            throw new RuntimeException("New priority must be greater than existing priority!");
        }
    }

}


class PriorityQueue {

    public static void main(String[] args) {

        int[] a = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        PriorityQueue q = new PriorityQueue(a);

        q.extractMax();
        q.insert(53);
    }
}
