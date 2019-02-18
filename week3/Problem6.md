# Problem 6


## Summary

|Implementation | insert | get-min | extract-min|
|:--- |:--- |:--- |:---|
|Unordered Array | `O(n)` | `O(n)` | `O(2n)`|
|Ordered Array | `O(n)` | `O(1)` | `O(n)` (could be `O(1)`, see note) |
|Unordered Linked List | `O(n)` | `O(n)` | `O(n)` |
|Ordered Linked List | `O(n)` | `O(1)` | `O(1)`|
|Heap (using array implicit data structure) | `O(log(n))` | `O(1)` | `O(log(n))` |




For all implementations, below, let `A` represent an input array and `k` represent the element to be inserted (where applicable). All arrays are 0-indexed. Let `last` be the index of the first non-null value in the array.

## 1. Unordered Array

```
insert(A, k) -> (): 
  // since the list is unordered, simply adding to the end will suffice
  A[last + 1] = k;
```

Inserting into the first empty element of an unordered array takes `O(n)` time.

```
get-min() -> int:
  // in an unordered array, the minimum value is obtained through linear search
  // linear search runs in O(n) time
  if A.length == 1:
    return A[0];
  else:
    min = Integer.MAX();
    for i in A:
      if i < min:
        min = i;
     return min;
```

Because `get-min()` uses linear search, it runs in `O(n)` time.

```
extract-min() -> int:
  if A.length == 1:
    return A[0];
  i = 0;
  j = 0; // Let j be the index where the minimum occurs
  min = Integer.MAX();
  for i = 0 to A.length:
    if A[i] < min:
      min = A[i];
      j = i;
    i += 1;
  
  A[j] = null; // extract the minimum

  // Close the "gap" created by removing an element
  for q = j to A.length:
    if A[q + 1] == null:
      break;
    A[q] = A[q + 1];
  last -= 1; // preserve the index of the last element of the array
  assert for all i = 0 to last, A[i] != null
  return min;
```

The worst case run time for this implementation of extract-min is `O(2n)`.


## 2. Ordered array

Assume that the array is a maximum ordered array, i.e., the largest value is in the right-most position in the array.

```
insert(A, k) -> ():
  // the array is ordered, so append the item, then call modified version of insertion sort
  // which starts at the last item in the array (the only unordered item) and inserts it into 
  // the correct position
  A[last + 1] = k; 
  last += 1; // preserve the index of the last item
  insertion-sort(k); // This will take Theta(n)
```

The worst case run time for inserting into an ordered array is `O(n)`.


```
get-min() -> int:
  // since the array is ordered, the min is the first item in the list
  return A[0];
```

The worst case run time for `get-min` is `O(1)`.


```
extract-min() -> int:
  min = get-min();
  // Unfortunately, that's not the end of the story, the array must then be shifted-left by one element
  // in order to extract the minimum element. shift-copy must loop through the entire array, so it takes n-time. 
  // A similar method is used in Unordered Array, extract-min
  shift-copy;
  last -= 1;
  return min;
  
```

The worst case run time for `extract-min()` is `O(n)`. Note that shifting the array is NOT required if this were a minimum ordered array, i.e., the minimum value is in the right most position. `extract-min()` would simply remove the last item in the array. 


## 3. Unordered Linked List

```
insert(L, k) -> (): 
  // since the list is unordered, simply adding to the end will suffice
  p1 = L.head;
  p2 = p1.next();
  while p2 is not null:
    p1 = p1.next();
    p2 = p2.next();
  n = Node(k);
  p1.set_next(n);
```

Inserting into the first empty element of an unordered linked list takes `O(n)` time (since the whole list must be traversed).

```
get-min() -> int:
  // in an unordered list, the minimum value is obtained through linear search
  // linear search runs in O(n) time
  min = Integer.MAX();
  l = L.head;
  while l is not null:
    if l.value < min:
      min = l.value;
    l.next();
```

`get-min` takes `O(n)` time.

```
extract-min() -> int:
  p1 = L.head;
  p2 = p1.next();
  p3 = null;
  min = Integer.MAX();
  while p2 is not null:
    if p1.value < min:
      p3 = p1;
      min = p1.value;
    p1 = p1.next();
    p2 = p2.next();
  
  n = p3.next().next();
  if (n != null):
    p3.set_next(n);
  return min;
```

The worst case run time for this implementation of extract-min in an unordered linked list is `O(n)`.


## 4. Ordered Linked List

```
insert(L, k) -> (): 
  p = L.head;
  while p.next() != null && p.next().value < k:
    p = p.next();
  n = Node(k);
  p.set_next(n);
```

Ordered insertion into a pre-ordered linked list takes `O(n)` time.

```
get-min() -> int:
  return L.head.value;
```

`get-min` takes `O(1)` time.

```
extract-min() -> int:
  // in an ordered list, the minimum value is simply the head
  p = L.head;
  L.head = p.next();
  return p.value;
```

Since the reference to head of the linked list is simply discarded, `extract-min` runs in `O(1)` time.



## 5. Min-heap

```
insert(H, k) -> (): 
  // Assume the heap grows dynamically and a new item can always be inserted
  // Let open represent the index of the first available position in the heap; 
  // if the heap is implemented using an array, open = last (the first non-null 
  // value of the array).
  increaseKey(open, k)
```

`insert` takes `O(log(n))` time because increase key takes `O(log(n))` time (the time to heapify the tree on the parent node of the inserted key, down to the root).

```
get-min() -> int:
  return H.root;
```

`get-min` takes `O(1)` time since the root of the heap is the minimum value.

```
extract-min() -> int:
  min = H.root;
  H.root = H.last; // exchange the root with the last element of the heap
  H.last = null; // Perform the extraction.
  H.heap_size -= 1; // since the min is extracted, the heap reduces in size by 1
  H.max_heapify(H.root);
  return min;
```

`extract-min` runs in `O(log(n))` time because `max_heapify` runs in `O(log(n))` time.








