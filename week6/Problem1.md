# Problem 1

## (a) Non-recursive algorithm with stack data-structure
```
InOrder(root):
  s = Stack(); // Create a new empty stack
  
  current = root; // Create a pointer to the root
  while (current != null || !s.empty()):
    while (current != null):
      s.push(current);
      current = current.left;
    current = s.pop();
    // Perform in place operation, in this case, 
    // simply print the node to console
    print(current.value);
    current = current.right;
```


## (b) Non-recursive algorithm with threading
```
InOrder(root):
  current = root;
  while (current != null):
    if (current.left == null):
      print(current.value);
      current = current.right;
      if (current != null):
        current.left = null;
    else:
      // Assume a function predecessor which finds the 
      // in order predecessor by going to the right most
      // element of the left subtree of the current
      // or null
      p = Predecessor(current);
      if (p.right == null):
        p.right = current;
        current = current.left;
      else:
        p.right = null;
        print(current.value);
        current = current.right;
```

