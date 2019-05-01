# Problem 1

```
static void naiveMatcher(String T, String P) {
    if (P.length() > T.length()) {
        System.out.println("No matches found!");
    }
    // Single for-loop, so this algorithm runs in O(N) time
    for (int i = 0; i <= T.length() - P.length(); i++) {
        int term = i + P.length();
        // Substring doesn't include the last index, i.e.,
        // "LIST" from (0, 3) = "LIS"
        if (T.substring(i, term).equals(P)) {
	    String out = "Pattern matched at index = " + i
            System.out.println(out);
        }
    }
    return;
}
```
