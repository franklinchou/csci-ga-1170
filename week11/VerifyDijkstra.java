import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

class Graph {

    Set<Node> verticesExSource;
    HashMap<Pair<Node, Node>, Integer> edges;
    Node source;

    /**
     * Construct a graph given edges and a defined "source" or entry node.
     *
     * @param source
     * @param edges
     */
    public Graph(Node source,
                 HashMap<Pair<Node, Node>, Integer> edges) {

        this.source = source;
        this.edges = edges;

        this.verticesExSource = new HashSet<>();

        // Initialize vertices ex source (all the vertices, minus the source vertex)
        for (Map.Entry<Pair<Node, Node>, Integer> e : edges.entrySet()) {
            Node u = e.getKey().getLeft();
            Node v = e.getKey().getRight();
            if (u != source) {
                verticesExSource.add(u);
            }
            if (v != source) {
                verticesExSource.add(v);
            }
        }
    }

    private Integer weight(Node u, Node v) {
        return edges.get(Pair.of(u, v));
    }


    /**
     * Modified Bellman Ford algorithm that verifies all edges have been
     * properly relaxed.
     *
     * @return
     */
    private boolean bellmanFord() {
        for (Map.Entry<Pair<Node, Node>, Integer> e : edges.entrySet()) {
            Node u = e.getKey().getLeft();
            Node v = e.getKey().getRight();
            // In order to be properly relaxed, the distance from the source
            // node must be minimized, i.e., v.d < u.d + weight(u, v).
            // If that condition is NOT satisfied, the edges have not been
            // properly relaxed.
            if (v.d > u.d + weight(u, v)) {
                return false;
            }
        }
        return true;
    }


    boolean validateAll() {
        boolean v = validateSourceNode() && validateDistances() && validateOutliers();
        if (v) {
            return bellmanFord();
        }
        return false;
    }

    boolean validateSourceNode() {
        return this.source.d == 0 && this.source.p == null;
    }

    
    // Excluding the source node, the shortest distance between each node and the 
    // source node is equivalent to the distance between that node's predecessor
    // and the edge connecting that node and its predecessor.
    boolean validateDistances() {
        for (Node u : this.verticesExSource) {
            if (u.d != u.p.d + weight(u.p, u)) {
                return false;
            }
        }
        return true;
    }


    // Excluding the source node, any unreachable node (node without a predecessor) 
    // must have a distance to the source of infinity.
    boolean validateOutliers() {
        for (Node u : this.verticesExSource) {
            if (u.p == null && u.d != Integer.MAX_VALUE) {
                return false;
            }
        }
        return true;
    }

}

class Node {
    Integer d;
    Node p;
    String key;

    public Node(String key, Integer d, Node p) {
        this.key = key;
        this.d = d;
        this.p = p;
    }

}


class VerifyDijkstra {

    public static void main(String[] args) {

        Node s = new Node("s", 0, null);
        Node y = new Node("y", 5, s);
        Node t = new Node("t", 8, y);
        Node z = new Node("z", 7, y);
        Node x = new Node("x", 9, t);

        HashMap<Pair<Node, Node>, Integer> edges = new HashMap<>();

        edges.put(Pair.of(s, t), 10);
        edges.put(Pair.of(s, y), 5);
        edges.put(Pair.of(t, y), 2);
        edges.put(Pair.of(t, x), 1);
        edges.put(Pair.of(y, x), 9);
        edges.put(Pair.of(y, z), 2);
        edges.put(Pair.of(y, t), 3);
        edges.put(Pair.of(x, z), 4);
        edges.put(Pair.of(z, x), 6);
        edges.put(Pair.of(z, s), 7);

        Graph g = new Graph(s, edges);
        System.out.print(g.validateAll());
    }
}
