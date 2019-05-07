import java.util.HashMap;
import java.util.LinkedList;

class Vertex {

    String color;
    String key;
    Vertex predecessor = null;

    public Vertex(String key) {
        this.key = key;
    }

}

class Graph {

    // Hash map  of lists for Adjacency List Representation
    HashMap<Vertex, LinkedList<Vertex>> adj;

    public Graph() {
        this.adj = new HashMap<>();
    }

    /**
     * Add an edge between the given nodes
     *
     * @param v
     * @param w
     */
    void addUndirectedEdge(Vertex v, Vertex w) {
        this.addEdge(v, w);
        this.addEdge(w, v);
    }

    private void addEdge(Vertex v, Vertex w) {
        if (this.adj.get(v) == null) {
            LinkedList<Vertex> vAdj = new LinkedList<>();
            vAdj.add(w);
            this.adj.put(v, vAdj);
        } else {
            LinkedList<Vertex> vAdj = this.adj.get(v);
            vAdj.add(w);
            this.adj.put(v, vAdj);
        }
    }

}

// Give algorithm to determine whether an undirected graph contains a
// cycle. Algorithm should run in Theta(V) time independent of number
// of edges.
class DetectCycleUndirected {

    static void detectCycle(Graph g) {
        for (Vertex v : g.adj.keySet()) {
            v.color = "WHITE";
            v.predecessor = null;
        }

        for (Vertex v : g.adj.keySet()) {
            if (v.color.equals("WHITE")) {
                visit(g, v);
            }
        }
    }

    static void visit(Graph g, Vertex u) {
        u.color = "GRAY";
        for (Vertex v : g.adj.get(u)) {
            if (v.color.equals("BLACK")) {
                break;
            }
            if (v.color.equals("WHITE")) {
                v.predecessor = u;
                visit(g, v);
            }
            // if (!v.color.equals(WHITE) && u.predecessor != v) {
            if (v.color.equals("GRAY") && u.predecessor != v) {
                System.out.println("Cycle detected");
                break;
            }
        }
        u.color = "BLACK";
    }


    public static void main(String[] args) {
        Vertex s = new Vertex("s");
        Vertex v = new Vertex("v");
        Vertex w = new Vertex("w");
        Vertex x = new Vertex("x");

        Graph g = new Graph();

        g.addUndirectedEdge(s, v);
        g.addUndirectedEdge(v, x);
        g.addUndirectedEdge(x, w);
        g.addUndirectedEdge(s, w);

        detectCycle(g);
        System.out.println();
    }
}
