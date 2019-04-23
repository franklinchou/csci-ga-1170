// This covers the case of finding the diameter when the root is known!

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
    
    void bfs(Node s) {
        Set<Node> nodes = this.adj.keySet();
        // Reset all values because bfs mutates state
        for (Node n: nodes) {
            n.color = "WHITE";
            n.predecessor = null;
            n.d = Integer.MAX_VALUE;
        }
        s.color = "GRAY";
        s.d = 0;
        s.predecessor = null;
        Queue<Node> q = new LinkedList<Node>();
        q.add(s);
        while (q.size() != 0) {
            Node u = q.remove();
            LinkedList<Node> adj = this.adj.get(u);
            // System.out.println("u=" + u.key + "; adj=" + adj.size());
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
    
    // Return the Node that is the maximum distance from the given root
    Node furthest(Node root) {
        this.bfs(root);
        int max = 0;
        Node maxNode = null;
        // System.out.println(this.adj.keySet().size());
        for(Node n: this.adj.keySet()) {
            if (n.d > max) {
                max = n.d;
                maxNode = n;
            }
        }
        return maxNode;
    }
    
}

// The longest path between any two nodes in a tree
// The longest shortest path between two nodes
public class Diameter {
    
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
        gr.addEdge(b, a);
        gr.addEdge(c, f);
        gr.addEdge(c, a);
        gr.addEdge(d, b);
        gr.addEdge(e, b);
        gr.addEdge(f, c);
        
        // assuming that the root is in the "center" of the tree.
        // The longest path between any two nodes is the 
        // longest path between the two furthest leaf nodes
        // from the root.
        Node fr = gr.furthest(a);
        
        // The second pass of BFS starts at the furthest leaf node
        // passes through the root node and ends at the longest path
        // between two nodes in the tree = diameter.
        System.out.println(gr.furthest(fr).d);
    }

}
