# insertion sort

if __name__ == "__main__":
    # a is the array to be sorted
    a = [5, 2, 4, 6, 1, 3]

    # "split" the array into two sections, the section
    # to be sorted, which begins from the second item in 
    # the array, and the section that has been sorted 
    # which begins from the first item of the array and grows
    # as the list is sorted
    print("iteration = 0, a = {}".format(a))
    for j in range(1, len(a)):
        key = a[j]
        # insert the sorted item into the "sorted" portion of the array
        i = j - 1
        while i >= 0 and a[i] > key:
            a[i + 1] = a[i]
            i = i - 1
        a[i + 1] = key
        print("iteration = {}, a = {}".format(j, a))
    
    print(a)
