# Problem 2

```
final static char SPECIAL = '♢';

static boolean findOccurrence(String T, String P, int t, int p) {
    if (p == P.length()) {
        return true;
    }
    if (t == T.length()) {
        return false;
    }

    if (P.charAt(p) == SPECIAL) {
        return findOccurrence(T, P, t + 1, p) || 
            findOccurrence(T, P, t, p + 1);
    } else if (T.charAt(t) == P.charAt(p)) {
        return findOccurrence(T, P, t + 1, p + 1);
    } else if (p == 0) {
        return findOccurrence(T, P, t + 1, p);
    }
    return false;
}
```

