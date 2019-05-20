import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

class Node {
    String key;
    
    public Node(String k) {
        this.key = k;
    }
}

class Graph {
    
    HashMap<Node, LinkedList<Node>> adj;
    
    HashSet<Node> vs;
    
    public Graph() {
        this.vs = new HashSet<>();
        this.adj = new HashMap<>();
    }

    // Add an edge and build the list of all nodes in the graph
    public void addEdge(Node u, Node v) {
        LinkedList<Node> uAdjs = this.adj.get(u);
        if (uAdjs == null) {
            uAdjs = new LinkedList<>();
        }
        uAdjs.add(v);
        this.adj.put(u, uAdjs);
        this.vs.add(u);
        this.vs.add(v);
    }

    public LinkedList<Node> order() {
        // Compute the in-degree of each node in the graph
        
        // Transpose the graph first
        Graph t = new Graph();
        for (Node n : this.vs) {
            LinkedList nAdj = this.adj.get(n);
            if (nAdj != null) {
                for (Node p : nAdj) {
                    t.addEdge(p, n);
                }
            }
        }
        
        HashMap<Node, Integer> inDegrees = new HashMap<>();
        for (Node n: vs) {
            LinkedList<Node> nAdjs = this.adj.get(n);
            if (nAdjs == null) {
                inDegrees.put(n, 0);
            } else {
                inDegrees.put(n, nAdjs.size());
            }
        }
        
        // Collect only those with in-degree = 0
        Queue<Node> q = new LinkedList<Node>();
        for (Node n : inDegrees.keySet()) {
            if (inDegrees.get(n) == 0) {
                q.add(n);
            }
        }
        
        LinkedList<Node> order = new LinkedList<>();
        while (q.size() > 0) {
            Node u = q.remove();
            order.add(u);
            LinkedList<Node> uAdj = this.adj.get(u);
            System.out.println("u = " + u.key);
            if (uAdj != null) {
                for (Node v : uAdj) {
                    System.out.println("u-adj = " + uAdj.size());
                    Integer p = inDegrees.get(v) - 1;
                    inDegrees.put(v, p);
                    if (p == 0) {
                        q.add(v);
                    }
                }
            }
        }
        
        return order;
    }
    
}

public class TopologicalOrder {
    
    public static void main(String[] args) {
        Node s = new Node("s");
        Node a = new Node("a");
        Node b = new Node("b");
        Node d = new Node("d");
        Node t = new Node("t");
        
        Graph g = new Graph();
        g.addEdge(s, a);
        g.addEdge(s, b);
        g.addEdge(a, d);
        g.addEdge(b, d);
        g.addEdge(d, t);
        
        LinkedList<Node> l = g.order();
        
        for (Node n : l) {
            System.out.println(n.key);
        }
    }
}
