# max

if __name__ == "__main__": 
    a = [9000, 3, 564, 65, 235, 7]
    m = a[0]
    for i in range(1, len(a)):
        if a[i] > m:
            m = a[i]
        
    print(m)
