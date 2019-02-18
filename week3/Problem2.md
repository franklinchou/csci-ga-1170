# Problem 2

Sort the array A = [4, 6, 3, 5, 0, 5, 1, 3, 5, 5] using counting sort.

1. After the first loop, the index, `i`, corresponds to the number of times `i` occurs in `A`.

Index | Value
--- | ---
0 | 1
1 | 1
2 | 0
3 | 2
4 | 1
5 | 4
6 | 1

2. After the second loop, the array `C` represents, at each index, `i`, the number of items that are greater than or equal to the value of `C[i]`. Since all the items in the list must be less than or equal to the maximum of the list, `C[last] = A.length`.

Index | Value
--- | ---
0 | 1
1 | 2
2 | 2
3 | 4
4 | 5
5 | 9
6 | 10

3. After the third loop, `C` = [0, 1, 2, 2, 4, 5, 9]

4. Sorted array = [0, 1, 3, 3, 4, 5, 5, 5, 5, 6]

