import java.util.HashMap;
import java.util.LinkedList;

class Vertex {

    String color;
    String key;
    int discovery;
    int finish;
    Vertex predecessor;

    public Vertex(String key) {
        this.key = key;
        this.color = "WHITE";
        this.predecessor = null;
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


    /**
     * Perform topological sort
     */
    LinkedList<Vertex> sort(Vertex[] vs) {

        LinkedList<Vertex> result = new LinkedList<>();

        // Perform sort with implicit ordering
        String[] order = {"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        for (String s : order) {
            Vertex u = null;
            for (Vertex t : vs) {
                if (t.key.equals(s)) {
                    u = t;
                    break;
                }
            }
            if (u != null && u.color.equals("WHITE")) {
                visit(u, result);
            }
        }

        return result;
    }

    private void visit(Vertex u, LinkedList<Vertex> l) {
        this.incrementTime();
        u.discovery = this.time;
        u.color = "GRAY";

        if (this.adj.get(u) != null) {
            for (Vertex v : this.adj.get(u)) {
                if (v.color.equals("WHITE")) {
                    v.predecessor = u;
                    visit(v, l);
                }
            }
        }

        u.color = "BLACK";
        l.push(u);
        this.incrementTime();
        u.finish = this.time;
    }

}


class TopSort {


    public static void main(String[] args) {
        Vertex m = new Vertex("m");
        Vertex n = new Vertex("n");
        Vertex o = new Vertex("o");
        Vertex p = new Vertex("p");
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
        
        g.addEdge(m, q);
        g.addEdge(m, r);
        g.addEdge(m, x);
        g.addEdge(n, q);
        g.addEdge(n, u);
        g.addEdge(n, o);
        g.addEdge(o, r);
        g.addEdge(o, v);
        g.addEdge(o, s);
        g.addEdge(p, o);
        g.addEdge(p, s);
        g.addEdge(p, z);
        g.addEdge(q, t);
        g.addEdge(r, u);
        g.addEdge(r, y);
        g.addEdge(s, r);
        g.addEdge(u, t);
        g.addEdge(v, x);
        g.addEdge(v, w);
        g.addEdge(w, z);
        g.addEdge(y, v);

        Vertex[] vs = {m, n, o, p, q, r, s, t, u, v, w, x, y, z};
        LinkedList<Vertex> result = g.sort(vs);
        System.out.println("Node | Discovery | Finish");
        System.out.println("--- | --- | ---");
        for (Vertex vv : result) {
            // System.out.printf("%s\n", vv.key);
            System.out.printf("%s | %d | %d\n", vv.key, vv.discovery, vv.finish);
        }
    }
}
