# Problem 4

```
// Perform recursive binary search for the value target on some pre-sorted 
// array A, returning the index of the element if found. If not, return nothing.
BinarySearchR(A, left, right, target):
  m = left + floor((right - left) / 2)
  if right - left <= 1 and A[m] != target:
    return
  else:
    if A[m] > target:
      BinarySearchR(A, left, m, target)
    if A[m] < target:
      BinarySearchR(A, m + 1, right, target)
    else:
      return m
```
