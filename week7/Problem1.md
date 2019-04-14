# Problem 1

```
// price is an array mapping the length (index) -> price
// n is the size of the rod
// Arrays are java arrays (start at index = 0)
Cut-Rod-With-Fixed-Cost(price, n):
  final cost = c;
  // Create a memoization table of the given size 
  // with each index initialized to 0	
  m = memoization-table(n + 1);
  for (i = 1; i <= n; i++):
    max = price[i - 1];
    for (j = 0; j < i - 1; j++):
      max = Math.max(max, price[j] + m[i - j - 1] - c);
    // memoize the new max
    m[i] = max;
  return m[n];
```
