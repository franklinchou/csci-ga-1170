def insertion_sort(b):
    for i in range(1, len(b)):
        up = b[i]
        j = i - 1
        while j >= 0 and b[j] > up:
            b[j + 1] = b[j]
            j -= 1
        b[j + 1] = up
    return b

def bucket_sort(x):
    arr = []
    slot_num = 10 # 10 means 10 slots, each slot is size = 0.1
    
    for i in range(slot_num):
        arr.append([])

    for j in x:
        # bucket index
        b_i = int(slot_num * j)
        arr[b_i].append(j)

    # sort individual buckets
    for i in range(slot_num):
        arr[i] = insertion_sort(arr[i])

    for i in range(slot_num):
        print(arr[i])

    # concatenate the result
    k = 0
    for i in range(slot_num):
        for j in range(len(arr[i])):
            x[k] = arr[i][j]
            k += 1
    return x

if __name__ == "__main__":
    x = [0.88, 0.23, 0.25, 0.74, 0.18, 0.02, 0.69, 0.56, 0.57, 0.49]
    # print(bucket_sort(x))
    bucket_sort(x)
