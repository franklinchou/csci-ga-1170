# Recursive bin search 

def bin_search_r(arr, left, right, target):
    m = left + (right - left) // 2

    if right - left <= 1 and arr[m] != target:
        return
    else:
        if arr[m] > target:
            bin_search_r(arr, left, m, target)
        elif arr[m] < target:
            bin_search_r(arr, m + 1, right, target)
        elif arr[m] == target:
            print(m)
            return
        

arr = [200, 300, 400, 500, 700, 900]
bin_search_r(arr, 0, len(arr) - 1, 100)

