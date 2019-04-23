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

// The longest path between any two nodes in a tree
// The longest shortest path between two nodes
public class Diameter {
    
    
    
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
        return;
    }
    
    public static void main(String[] args) {
        Graph gr = new Graph(6); 
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        
        gr.addEdge(a, b);
        gr.addEdge(a, c);
        gr.addEdge(b, d);
        gr.addEdge(b, e);
        gr.addEdge(c, f);
        gr.addEdge(d, b);
        gr.addEdge(e, b);
        gr.addEdge(f, c);
        
        distance(gr);
    }

}
