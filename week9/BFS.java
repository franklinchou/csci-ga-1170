import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class Node {
    String color;
    char key;
    int d = Integer.MAX_VALUE;
    Node predecessor = null;
    
    public Node(char n) {
        this.key = n;
    }
}

class Graph {
    private int vs; // number of vertices
    Map<Node, LinkedList<Node>> adj;
    
    public Graph(int vs) {
        this.vs = vs;
        this.adj = new HashMap<Node, LinkedList<Node>>();
    }
    
    void addEdge(Node u, Node v) {
        LinkedList<Node> adjacents = this.adj.get(u);
        if (adjacents == null) {
            adjacents = new LinkedList<Node>();
            adjacents.add(v);
            this.adj.put(u, adjacents);
        } else {
            adjacents.add(v);
            this.adj.put(u, adjacents);
        }
        return;
    }
    
}

public class BFS {
    
    static void bfs(Graph g, Node s) {
        for (Map.Entry<Node, LinkedList<Node>> e : g.adj.entrySet()) {
            if (s.key != e.getKey().key) {
                e.getKey().color = "WHITE";
            }
        }
        s.color = "GRAY";
        s.d = 0;
        s.predecessor = null;
        Queue<Node> q = new LinkedList<Node>();
        q.add(s);
        while (q.size() != 0) {
            Node u = q.remove();
            LinkedList<Node> adj = g.adj.get(u);
            for (Node v: adj) {
                if (v.color == "WHITE") {
                    v.color = "GRAY";
                    v.d = u.d + 1;
                    v.predecessor = u;
                    q.add(v);
                }
            }
            u.color = "BLACK";
        }
        for (Map.Entry<Node, LinkedList<Node>> e: g.adj.entrySet()) {
            Node n = e.getKey();
            System.out.println("Node:" + n.key);
            System.out.println("\td=" + n.d);
            String p;
            if (n.predecessor != null) {
                p = String.valueOf(n.predecessor.key);
            } else {
                p = "null";
            }
            System.out.println("\tp=" + p);
        }
    }
    
    public static void main(String[] args) {
        Graph g = new Graph(8); // Graph from CLRS p. 596, fig. 22.3
        Node r = new Node('r');
        Node s = new Node('s');
        Node t = new Node('t');
        Node u = new Node('u');
        Node v = new Node('v');
        Node w = new Node('w');
        Node x = new Node('x');
        Node y = new Node('y');
        
        g.addEdge(r, s);
        g.addEdge(r, v);
        g.addEdge(s, w);
        g.addEdge(s, r);
        g.addEdge(t, w);
        g.addEdge(t, x);
        g.addEdge(t, u);
        g.addEdge(u, t);
        g.addEdge(u, y);
        g.addEdge(u, x);
        g.addEdge(v, r);
        g.addEdge(w, s);
        g.addEdge(w, t);
        g.addEdge(w, x);
        g.addEdge(x, y);
        g.addEdge(x, w);
        g.addEdge(x, t);
        g.addEdge(x, u);
        g.addEdge(y, u);
        g.addEdge(y, x);

        bfs(g, u);  // Output = Problem1
    }

}
