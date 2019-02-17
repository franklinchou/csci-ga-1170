# Count inversions
# Runs with python2!!

def mergeSortInversions(arr):
    inversions = 0
    if len(arr) == 1:
        return arr, inversions
    else:
        a = arr[:len(arr)/2]
        b = arr[len(arr)/2:]

        a, ai = mergeSortInversions(a)
        b, bi = mergeSortInversions(b)
        c = []
        c, ci = merge(a, b)
        inversions = ci + ai + bi
        return c, inversions
    
def merge(a, b):
    i = j = inversions = 0
    c = []
    while i < len(a) and j < len(b):
        if a[i] <= b[j]:
            c.append(a[i])
            i += 1
        else:
            c.append(b[j])
            j += 1
            inversions += (len(a) - i)
            
    c += a[i:]
    c += b[j:]
    return c, inversions    
    
    
    
print(mergeSortInversions([2, 4, 1, 3, 5]))
