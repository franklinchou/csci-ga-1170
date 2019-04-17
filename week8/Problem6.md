# Problem 6

```
static boolean isRotation(String a, String b) {
	if (a.length() != b.length()) {
		return false;
	}

	int SIZE = b.length();
	String s = a + b;
	// One for-loop so running time is linear
	for (int i = 1; i < s.length() - 1; i++) {
		if (s.substring(i, i + SIZE).equals(b)) {
			return true;
		}
	}
	return false;
}
```
