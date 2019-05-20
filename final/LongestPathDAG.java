import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.HashSet;

class Graph {
    
    Map<Node, LinkedList<Pair>> adj;
    
    HashSet<Node> vs;
    
    public Graph() {
        this.adj = new HashMap<>();
        this.vs = new HashSet<>();
    }
    
    // Create an edge between two nodes, 
    // if a node does not exist add it to the adjacency list
    void addEdge(Node u, Node v, int weight) {
        LinkedList<Pair> adjacents = this.adj.get(u);
        if (adjacents == null) {
            adjacents = new LinkedList<Pair>();
        }
        Pair p = new Pair(v, weight);
        adjacents.add(p);
        this.adj.put(u, adjacents);
        this.vs.add(u);
        this.vs.add(v);
    }
    
    // Provide the topological sorted list
    // topologically sorted or topologically ordered
    // all the nodes are arranged such that each previous node can
    // only travel forward to any successor node
    LinkedList<Node> sort() {
        LinkedList<Node> sorted = new LinkedList<>();
        for (Node n: vs) {
            visit(n, sorted);
        }
        return sorted;
    }
    
    
    // visit a node and add it to the list of sorted
    private void visit(Node n, LinkedList<Node> l) {
        if (n.color == "BLACK") {
            return;
        }
        if (n.color == "GRAY") {
            // encountered a back edge (cycle); not a DAG
            return;
        }
        n.color = "GRAY";
        // For each edge between n and another node
        LinkedList<Pair> ps = this.adj.get(n);
        if (ps != null) {
            for(Pair p: this.adj.get(n)) {
                Node q = p.getNode();
                visit(q, l);
            }
        }
        n.color = "BLACK";
        l.addFirst(n);
    }
    
    
    LinkedList<Node> longest() {
        LinkedList<Node> result = new LinkedList<>();
        for (Node n: this.sort()) {
            LinkedList<Pair> nAdjs = this.adj.get(n);
            if (nAdjs != null) {
                for (Pair p: nAdjs) {
                    int d = n.dist + p.weight;
                    if (d > n.dist) {
                        p.n.dist = d;
                    }
                }
            }
            result.add(n);
        }
        // System.out.println(((Node) result.getLast()).dist);
        return result;
    }
    
}

class Node {
    
    String key;
    String color;
    int dist;
    Node next;
    
    public Node(String k) {
        this.key = k;
        this.color = "WHITE";
        this.dist = 0;
        this.next = null;
    }
    
}

class Pair {

    Node n;
    int weight;

    public Pair(Node n, int w) {
        this.n = n;
        this.weight = w;
    }
    
    public Node getNode() {
        return n;
    }
    
    public int getWeight() {
        return weight;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair p = (Pair) o;
        return this.n.equals(p.n) && this.weight == p.weight;
    }

}

public class LongestPathDAG {
    
    public static void main(String[] args) {
        
        Graph g = new Graph();
        Node s = new Node("s");
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node t = new Node("t");
        g.addEdge(s, a, 1);
        g.addEdge(s, b, 2);
        g.addEdge(a, b, 1);
        g.addEdge(a, c, 10);
        g.addEdge(b, c, 5);
        g.addEdge(c, t, 8);
    
        // LinkedList<Node> sorted = g.sort();
        
        LinkedList<Node> longest = g.longest();
        for (Node n: longest) {
            System.out.println(n.key);
        }
        
    }

}
