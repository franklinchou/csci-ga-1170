# Red Black Trees

- Know the difference between search trees and balanced search trees
- Balanced search trees have a gauranteed height of `O(log N)` for `N` items
- In a red black tree (a type of balanced tree):
  - the root & leaves (NIL) are always black
  - if a node is red, then its children are black
  - all paths from a node to its NIL descendants contain the same # of black nodes (black height of the red-black tree = # of nodes from the root to the NIL nodes excluding the root itself)
- The longest path in a r/b tree (root to the farthest NIL) is no more than twice the length of the shortest path (root to the nearest NIL); the shortest path has all black nodes while the longest path alternates between red & black
- Use of "sentinel node" to represent ALL NIL nodes (see, CLRS, p. 309).

## Insertion into a r/b tree

- When a node is inserted, the tree must re-balance by recoloring and rotating nodes to fix violations
- A node, Z, is inserted by starting with the color red.
  - if Z is the root, color it black
  - if Z has a red uncle, re-color Z's parent, grandparent and uncle
  - if Z's uncle is black and there is a "triangle situation", rotate Z's parent
  - if Z's uncle is black and there is a "line situation" rotate Z's grandparent & recolor

## Performance
Most binary search tree operations take `O(h)` time where `h` is the height of the BST.
The cost of these operations may become `O(n)` for a skewed or "primitive" binary tree.
If we ensure that the height of the tree remains `O(Log(n))` after insertion and deletion, 
then we can gaurantee the upper bound of `O(Log(n))` since the height of the red/black
tree is always `O(Log(n))`.
