# Problem 4

```
search-random(T):
  do: 
    // Let random be a function that uniformly generates an
    // integer between a, b, inclusive
    i = random(1, m) 
    if T(i) != Nil:
      // Let k be the number of elements for the list li 
      // associated with T(i). This number is known as 
      // per the problem description
      target = random(1, k)
      // Traverse li to get target
      // In a linked list, this is upperbounded by the time to
      // traverse L, so O(L)
      return l(target)
  while (T(i) != Nil)
```

Since there are `L` items distributed across `m` buckets, there are `Lm` total open entries. There are `n` items spread across those entries. Assume that `n = 50` and `mL = 50`, the number of attempts required to retrieve a value on the first attempt is `50/50 = 1`. Now assume that `n = 25`, the number of attempts required to retrieve a valid entry on the first attempt is `50/25 = 2`. So the number of attempts to retrieve a bucket on the first attempt is `mL / n = 1 / a`. Coupled with the time required to traverse L, `O(L)`, this function will return a key uniformly from among an `mL` set with `n` filled elements in `O(L(1 + m / n)` time.
