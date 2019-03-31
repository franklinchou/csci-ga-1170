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
  // Assumes a data structure that includes:
  // boolean rightThread
  if (root == null):
    return;
  // left-most will navigate to the left-most 
  // child from a given root node
  current = left-most(root);
  while (current != null):
    if (current.rightThread):
      current = current.right;
    else:
      current = left-most(current.right);
```

