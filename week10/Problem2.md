# Problem 2

In order to detect cycles in an undirected graph, use DFS as a template.
From CLRS, p. 606, DFS has traversal time of `Theta(V + E)`: it must explore 
(visit) each vertex once regardless of whether there are edges connecting
that vertex to other vertices and it must explore each outgoing edge once. 
Using DFS alone would not suffice since we are looking for running time of
`Theta(V)`. In order to be acyclic, an undirected graph must contain only 
TREE edges (no BACK edges). A BACK edge between `(u, v)` would only occur 
when: (A) `v` has been visited; and (B) `u`'s predecessor is not `v`.

```
DETECT-CYCLE(G):
  Init-Graph() // Set all vertex colors = white, predecessor = null
  for-each v in G.V:
    if v.color is WHITE:
      // This will run in Theta(V)
      VISIT(G, v)

VISIT(G, v):
  u.color = GRAY;
  // Here, an edge is considered only if the vertex at the 
  // destination is WHITE. All other cases break prematurely.
  // If an undirected graph has no cycles, the number of edges
  // should be LESS than the number of vertices (less by 
  // exactly one in a fully connected graph). Therefore the most
  // number of times this should run is Theta(E - 1) which is
  // equivalent to Theta(V).
  // Aggregate analysis produces Theta(V) + Theta(V) = Theta(2V).
  // Which is equivalent to Theta(V).
  for-each v in G.V:
    if v.color is BLACK:
      break
    if v.color is WHITE:
      v.predecessor = u
      VISIT(G, v)
    if v.color is GRAY && u.predecessor != v:
      print "Cycle deteted"
      break
  u.color = BLACK;
```
