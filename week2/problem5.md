# Problem 5

```
// Count the number of inversions, i.e., count the number of occurrences where
// A[i] > A[j] and a swap must be performed to maintain ascending order
CountInversions(A, left, right) -> (Array, Int):
  inversions = 0
  // An array of length 1 is trivially sorted and has no inversions
  if A.length == 1:
    return A, inversions
  else:
    m = floor((left + right) / 2)
    ALeft = A[left:m]
    ARight = A[m+1:right]
    ALeft, leftInversions = CountInversions(A, left, m)
    ARight, rightInversions = CountInversions(A, m + 1, right)
    
    // B = ALeft merged with ARight
    B, mergedInversions = MergeCount(A, left, m, right)
    inversions = rightInversions + leftIversions + mergedInversions 
    return B, inversions

// An input array is comprised of two sorted sub arrays, A[left:m] and A[m+1:right]
MergeCount(A, left, m, right): 
  inversions = 0
  // Separate A into two subarrays based on index:
  ALeft = A[left:m]
  ARight = A[m+1:right]
  // Initialize pointers to the beginning of each list
  // i for ALeft, j for ARight, k for the array sorted in place
  i = j = k = 0
  while i < ALeft.length and j < ARight.length:
    if ALeft[i] > ARight[j]:
      // Since each sub array is sorted, any element at position ALeft[i] > ARight[j]
      // will guarantee that ALeft[i+1:ALeft.length] > ARight[j], therefore when 
      // we encounter an inversion, at i, we will actually need to invert all the items
      // in ALeft between i and ALeft.length.
      inversions += (mid - i)
      A[k] = ARight[j]
      j += 1
    else:
      A[k] = ALeft[i]
      i += 1
    k += 1
  // Copy any remaining elements:
  while i < ALeft.length:
    A[k] = A[i]
    i += 1; k += 1
  while j < ARight.length:
    A[k] = A[j]
    j += 1; k += 1
  return A, inversions
```
