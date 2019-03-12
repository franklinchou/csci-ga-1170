# Problem 1

```
hash-insert(T, k):
  // Let m be the upper bound of hashes, i.e., m = 10,
  // means that hash can be performed 10 times
  i = 0
  do:
    j = hash(k, i)
    // Let D be an array of booleans of size m all initially
    // mapped to false. If an item is deleted in T[j], D[j] 
    // will be flipped to true flagging the item as deleted 
    // for the purpose of insertion.
    if T[j] == Nil or D[j]:
      T[j] = k
      // Make sure the item is not flagged as deleted
      D[j] = false
      return j
    i += 1
   while (j < T.size and i < m)
   // there are no spaces left for which to insert
   throw OverflowException
```

When deleting an occupied item, we must add the deleted item to the list of items flagged for deletion:

```
hash-delete(T, k):
  i = 0
  do:
    j = hash(k, i)
    if T[j] == k:
      assert D[j] == false
      D[j] = true
      return 
    i += 1
  while (j < T.size and i < m and T[j] != Nil)
  throw ItemNotFoundException
```

