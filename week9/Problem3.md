# Problem 3

## Part A (BFS of an undirected graph)

In BFS of an undirected graph...

1. There are no back edges and no forward edges in an undirected graph. (A) No back edges. In order to be a BACK edge `(u, v)`, `u` 
must connect to an ancestor `v`. However, if the tree is being explored breadth first, any ancestor to `u` will already have been
explored, therefore it would be a TREE edge and not a BACK edge. (B) No forward edges. In order to be a FORWARD edge `(u, v)`, `u`
must connect to a descendent. Since the tree is explored hierarchically, each tier is exhaustively explored before moving to the next
tier. Any descendent edge will always be a TREE edge. (See also (2).)

2. For any tree edge `(u, v)`, `v.d  = u.d + 1`. Since BFS, by definition, searches each tier (or level) of the tree hierarchically,
each parent (each `u`) will be at most _one unit_ away from each child. Only when all children on that level are searched will the 
algorithm move on to the next level therefore the distance between parent/child will never exceed 1.

3. For any cross edge `(u, v)`, `u.d = v.d` or `v.d = u.d + 1`. (A) In a "triangular" strongly connected graph with vertices `<a, b, c>`
it is easy to see that a cross edge can be formed by `b -> c` at the same level therefore `u.d = v.d`. (B) To show that `u.d` is always 
within 1 of `v.d`, consider the following graph:

```
      a
     /  \
    b    c
   /     |
  d      |
 /       |
e -------+
```
  Since there is an edge
  between `c -> e`, `c -> e` is classified as a TREE edge because the algorithm will always pick up `e` as within the adjacency list of
  `c`. Vertices `<b, c, e>` will all have distance from `a` of 1. By the time the algorithm encounters `d`, `e` will have been traversed, 
  therefore `d -> e` will be classified as a CROSS edge with distance `v.d = u.d + 1`.
