# Problem 1

Negative weight edges cannot be allowed in Dijkstra. Dijkstra relies on the principle that if all weights are non-negative
relaxing an edge will only shorten the path if the new edge results in a shorter path than the previous edge. 
A negative edge however will __always__ create a shorter path. If a set of positive paths is investigated 
