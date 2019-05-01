import java.util.HashMap;
import java.util.LinkedList;

class Vertex {

    String color;
    String key;
    int discovery;
    int finish;
    Vertex predecessor = null;

    public Vertex(String key) {
        this.key = key;
    }
}

class Graph {

    // Hash map  of lists for Adjacency List Representation
    HashMap<Vertex, LinkedList<Vertex>> adj;

    int time = 0;

    public Graph() {
        this.adj = new HashMap<>();
    }

    /**
     * Add an edge between the given nodes
     *
     * @param v
     * @param w
     */
    void addEdge(Vertex v, Vertex w) {
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

    void incrementTime() {
        this.time += 1;
    }

}


class DFS {

    private static void dfs(Graph g) {
        // Initialize the graph as unvisited:
        // All nodes white with no predecessor defined
        for (Vertex u : g.adj.keySet()) {
            u.color = "WHITE";
            u.predecessor = null;
        }

        // Consider in alphabetical order
        String[] order = {"q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        for (String s : order) {
            Vertex u = null;
            for (Vertex temp : g.adj.keySet()) {
                if (temp.key.equals(s)) {
                    u = temp;
                    break;
                }
            }
            if (u != null && u.color.equals("WHITE")) {
                visit(g, u);
            }
        }
    }


    private static void visit(Graph g, Vertex u) {
        g.incrementTime();
        u.discovery = g.time;
        u.color = "GRAY";
        for (Vertex v : g.adj.get(u)) {
            if (v.color.equals("WHITE")) {
                v.predecessor = u;
                visit(g, v);
            }
        }
        u.color = "BLACK";
        g.incrementTime();
        u.finish = g.time;
    }


    public static void main(String[] args) {
        Vertex q = new Vertex("q");
        Vertex r = new Vertex("r");
        Vertex s = new Vertex("s");
        Vertex t = new Vertex("t");
        Vertex u = new Vertex("u");
        Vertex v = new Vertex("v");
        Vertex w = new Vertex("w");
        Vertex x = new Vertex("x");
        Vertex y = new Vertex("y");
        Vertex z = new Vertex("z");
        Graph g = new Graph();
        g.addEdge(s, v);
        g.addEdge(v, w);
        g.addEdge(w, s);
        g.addEdge(q, s);
        g.addEdge(q, w);
        g.addEdge(q, t);
        g.addEdge(t, x);
        g.addEdge(t, y);
        g.addEdge(x, z);
        g.addEdge(z, x);
        g.addEdge(y, q);
        g.addEdge(r, y);
        g.addEdge(r, u);
        g.addEdge(u, y);

        dfs(g);

        for (Vertex vv: g.adj.keySet()) {
            System.out.println(vv.key);
            System.out.println("\t" + "Discovery: " + vv.discovery);
            System.out.println("\t" + "Finish: " + vv.finish);
        }

    }
}
