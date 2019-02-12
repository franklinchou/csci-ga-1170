# Problem 1

Assume that the given array length > 0 and all arrays are 0-indexed.

```
max = A[0]
for i = 1 to A.length
  if A[i] > max
    max = A[i]
```

1. Loop invariant. At the start of iteration `i` of the loop, the variable `max` should
be the value of the maximum of the subarray `A[0:i]`.

2. Initialization. At the start of the first iteration, `i = 1`, the variable `max`
should contain the maximum value of the subarray from `A[0:1]`, which is the single value
`A[0]`. The maximum value of a collection with a single element is that element and
since that element is set to the maximum value the loop invariant is true at the time of
initialization.

3. Maintenance. Assume that the loop invariant holds at the start of iteration `i`, then
it must be true that variable `max` contains the maximum of the subarray `A[0:i]`. In
the body of the loop, `max` is unchanged unless the value of `A[i] > max`, thus at the
start of iteration `i + 1`, `max` will be the maximum value of `A[0:i]`, thus
the loop invariant is maintained on subsequent iterations of `i`.

4. Termination. When the loop terminates, `i = A.length` and the variable `max` should
contain the value of the maximum of the subarray `A[0:A.length] = A`. This is exactly
the value that is expected (the maximum of the subarray `A[0:i]`), therefore the algorithm
is correct.

5. Running time. Because the loop will only need to traverse the collection once, the
running time of this algorithm against an array of `N` items is `N`.