import com.google.common.collect.Ordering;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


/**
 * Bucket sort is mainly useful when input is uniformly distributed over a range.
 * When the input contains several keys that are close to each other (clustering),
 * those elements are likely to be placed in the same bucket, which results in some
 * buckets containing more elements than average. The worst-case scenario occurs when
 * all the elements are placed in a single bucket.
 *
 * This implementation of bucket sort sorts numbers in the range (0-99) by placing them
 * into ten buckets and using the built in TimSort. The worst case performance is
 * when all items are in one bucket and the performance becomes equal to the performance
 * of the internal sort algorithm, in the case, n * Log(n).
 */
class BucketSort {

    final static int SIZE = 100;

    final static int BUCKETS = 10;

    LinkedList<Integer>[] buckets;

    Integer[] sortable;

    Integer[] sorted;

    /**
     * 1. bucketize the list (scatter)
     * 2. sort each individual bucket using a sorting algorithm (in this case TimSort)
     * 3. flatten the buckets into a single list (merge/gather)
     */
    @SuppressWarnings("unchecked")
    void sort() {
        buckets = new LinkedList[BUCKETS];

        // Initialize the buckets
        int i = 0;
        while(i != BUCKETS) {
            if (buckets[i] == null) {
                buckets[i] = new LinkedList<>();
            }
            i += 1;
        }

        this.bucketize();

        for (LinkedList<Integer> l : this.buckets) {
            Object[] arr = l.toArray();  // Unchecked
            Arrays.sort(arr);
            l.clear();
            l.addAll(new LinkedList(Arrays.asList(arr)));
        }

        this.flatten();
    }

    Integer[] flatten() {
        sorted = new Integer[SIZE];
        int i = 0;
        for (LinkedList<Integer> b : this.buckets) {
            for (Integer e : b) {
                sorted[i] = e;
                i += 1;
            }
        }
        return sorted;
    }

    private void bucketize() {
        for (Integer i : sortable) {
            buckets[i / 10].add(i);
        }
    }

    public BucketSort(Integer[] sortable) {
        this.sortable = sortable;
    }

    public static void main(String[] args) {

        // Generate random numbers (0-99) to sort
        Random r = new Random();
        Integer[] sortable = new Integer[SIZE];
        for (int i = 0; i < SIZE; i++) {
            sortable[i] = r.nextInt(100);
        }

        BucketSort bs = new BucketSort(sortable);
        bs.sort();

        List<Integer> l = Arrays.asList(bs.flatten());

        System.out.printf("sorted = %s", Ordering.natural().isOrdered(l));
    }

}
