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



public class Cross {
    
    static void bfs(Graph g, Node r) {
        for (Node n: g.adj.keySet()) {
            n.color = "WHITE";
        }
        r.color = "GRAY";
        r.d = 0;
        r.predecessor = null;
        Queue<Node> q = new LinkedList<Node>();
        q.add(r);
        while (q.size() != 0) {
            Node u = q.remove();
            LinkedList<Node> uAdj = g.adj.get(u); // Node u's adjacency list
            for (Node v: uAdj) {
                if (v.color == "WHITE") {
                    System.out.printf(
                        "At Node=%s, encountered Node=%s (TREE)\n",
                        u.key,
                        v.key
                    );
                    v.color = "GRAY";
                    v.d = u.d + 1;
                    v.predecessor = u;
                    q.add(v);
                }
                Boolean pchk = v.predecessor != null && u.predecessor != null;
                // What if v.predecessor = u.predecessor + 1?
                if (v.color == "GRAY" 
                        && pchk 
                        && v.predecessor.d == u.predecessor.d) {
                    System.out.printf(
                        "At Node=%s, encountered Node=%s (CROSS)\n",
                        u.key,
                        v.key
                    );
                }
            }
            u.color = "BLACK";
        }
    }
    
    public static void main(String[] args) {
        Graph g = new Graph(3);
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        g.addEdge(a, b);
        g.addEdge(a, c);
        g.addEdge(b, c);
        g.addEdge(b, a);
        g.addEdge(c, a);
        g.addEdge(c, b);
        bfs(g, a);
    }
}
