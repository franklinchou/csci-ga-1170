# Problem 2

```
final static char SPECIAL = '♢';

// Find an occurrence of pattern P in T, where
// P contains a special wildcard character
static boolean find(String T, String P, int t, int p) {
    if (p == P.length()) {
        return true;
    }
    if (t == T.length()) {
        return false;
    }

    if (P.charAt(p) == SPECIAL) {
        return find(T, P, t + 1, p) || 
            find(T, P, t, p + 1);
    } else if (T.charAt(t) == P.charAt(p)) {
        return find(T, P, t + 1, p + 1);
    } else if (p == 0) {
        return find(T, P, t + 1, p);
    }
    return false;
}
```

