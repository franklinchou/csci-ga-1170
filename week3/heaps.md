# Heaps

In a min-heap, the parent elements are each smaller than the children. The root is always the minimum.

## Insertion

A heap is a "complete binary tree," i.e., each level (except possibly the last) is completely filled with all nodes as far left as possible. In order to accomplish insertion, an item is placed in the first empty position and "bubbled up" until it is in the correct position (heapify).

## Removal of min

The minimum element is always the root. When the root is removed, we swap the root with the last element added, then the new "root" (which may violate the heap condition) is then "bubbled down" until the heap condition is satisifed.
