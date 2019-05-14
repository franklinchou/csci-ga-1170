# Problem 1

Observe the attached image. Negative edges cause the distance to the source node to be incorrect. Since the shortest path
to the source node (top node) from the child node can actually be -1, but in order to be "correct" Dijkstra's algorithm
must have `s.d = 0`.
