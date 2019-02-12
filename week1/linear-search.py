# linear search

if __name__ == "__main__":
    # given an array and a value, return the index
    # where the value is found or "nil"
    a = [1, 2, 3, 4, 5, 6]
    v = 125
    
    key = None
    # Invariant: At the start of the iteration i of the loop,
    # the variable key should contain Nil or the index where
    # the item is found in the given array. (Initialization) At the 
    # start of the first loop, the search has not started and key contains
    # Nil which fulfills the loop invariant (which states that key must
    # contain either Nil or the solution).
    for i in range(0, len(a)):
        # Maintenance: if the loop invariant holds at the start of
        # iteration i, then it must be that key contains either Nil
        # or the index where the item is found in the given array.
        if a[i] == v: # and key is not None:
            key = i
            # break

    # when the loop terminates, i = the size of the array
    # and key contains either the index of the value, v, 
    # or Nil. 

    if key == None:
        print("nil")
    else:
        print(key)
