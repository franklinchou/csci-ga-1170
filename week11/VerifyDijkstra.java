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

        for (Map.Entry<Pair<Node, Node>, Integer> e : edges.entrySet()) {
            Node u = e.getKey().getLeft();
            Node v = e.getKey().getRight();
            if (u == source) {
                verticesExSource.add(u);
            }
            if (v == source) {
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
            if (v.d != u.p.d + weight(u, v)) {
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

    boolean validateDistances() {
        for (Map.Entry<Pair<Node, Node>, Integer> e : edges.entrySet()) {
            Node u = e.getKey().getLeft();
            Node v = e.getKey().getRight();
            if (v.d != u.d + weight(u, v)) {
                return false;
            }
        }
        return true;
    }

    boolean validateOutliers() {
        for (Node u : this.verticesExSource) {
            if (u.d == Integer.MAX_VALUE && u.p == null) {
                return false;
            }
        }
        return false;
    }

}

class Node {
    Integer d;
    Node p;

    String key;

    public Node(String key) {
        this.key = key;
    }

}


class VerifyDijkstra {

    

    public static void main(String[] args) {

    }
}
