import com.google.common.collect.Ordering;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class BucketSort {

    final static int SIZE = 100;

    final static int BUCKETS = 10;

    LinkedList<Integer>[] buckets;

    Integer[] sortable;

    Integer[] sorted;

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
