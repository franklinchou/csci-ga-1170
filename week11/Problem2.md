# Problem 2

The application of Dijkstra's algorithm can be verified in four steps:

1. Validate Source Node. Ensure that the source node has no predecessor and the distance to the source is 0.
2. Validate Outliers. Ensure that any node whose predecessor is NIL is unreachable, i.e., it's distance to source is infinity.
3. Validate Distances. Ensure that for any node (excluding the source node), `v`, that node's distance to source (`v.d`) is
equal to it's predecessor's distance from the source (`v.predecessor.d`) plus the edge between `v` and `v.predecessor`. This is
because the shortest distance to `v` must be comprised of the sum of all previous shortest routes (represented by
`v.predecessor.d`) PLUS the shortest distance from `u` to `v` (which, after Dijkstra's algorithm is applied
is equivalent to the distance between `v` and `v.predecessor` given by weight between those nodes).
4. Validate relaxed edges. In order to be properly relaxed, the distance from the source node must be minimized. 
To do this run a modified version of the Bellman Ford algorithm. For each pair of
nodes `(u, v)` in the edge set, the destination node's _shortest distance from source_, `v.d`, must be _less than or equal to_
the source node's shortest distance from the source, `u.d`, and some arbitrary edge connecting `u.d` to `v.d`. In other words,
`v.d <= u.d + weight(u, v)`. If `v.d > u.d + weight(u, v)`, return false.
