import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Graph {

    HashMap<Node, HashMap<Node, Integer>> adj;

    Set<Node> ns;

    public Graph() {
        this.ns = new HashSet<>();
        this.adj = new HashMap<>();
    }


    public void addDirectedEdge(Node u, Node v, Integer weight) {
        HashMap<Node, Integer> m;

        // when adding an edge add both nodes to the universe of nodes
        // in the graph
        this.ns.add(u);
        this.ns.add(v);

        if (this.adj.get(u) == null) {
            m = new HashMap<>();
        } else {
            m = this.adj.get(u);
        }
        m.put(v, weight);
        this.adj.put(u, m);
    }

    Integer weight(Node u, Node v) {
        if (this.adj.get(u) == null && this.adj.get(u).get(v) != null) {
            return null;
        }
        return this.adj.get(u).get(v);
    }

    void initializeSingleSource(Node s) {
        for (Node n : this.ns) {
            n.setD(Integer.MAX_VALUE);
        }
        s.setD(0);
    }

}


class Node {

    private int d;
    private Node predecessor;
    String key;

    public Node(String key) {
        this.key = key;
    }

    void setD(int d) {
        this.d = d;
    }

    int getD() {
        return this.d;
    }

    void setPredecessor(Node p) {
        this.predecessor = p;
    }
}


class MinPQ {

    private class Heap {
        Node[] ns;
        int heapSize;

        private boolean inArrayBound(int e) {
            return e <= this.heapSize - 1;
        }

        Integer leftChild(int e) {
            int l = 2 * e + 1;
            if (l > ns.length - 1) {
                return null;
            }
            return l;
        }

        Integer rightChild(int e) {
            int r = 2 * e + 2;
            if (r > ns.length - 1) {
                return null;
            }
            return r;
        }

        Heap(Node[] ns) {
            this.ns = ns;

            buildMinHeap();
            this.heapSize = ns.length;
        }

        void buildMinHeap() {
            this.heapSize = this.ns.length;

            int start = ((this.ns.length - 1) / 2);
            for (int i = start; i != 0; i--) {
                minHeapify(i);
            }
        }

        void minHeapify(int e) {
            Integer left = leftChild(e);
            Integer right = rightChild(e);

            int smallestIndex;

            if (left != null && inArrayBound(left) && this.ns[left].getD() < this.ns[e].getD()) {
                smallestIndex = left;
            } else {
                smallestIndex = e;
            }

            if (right != null && inArrayBound(right) && this.ns[right].getD() < this.ns[smallestIndex].getD()) {
                smallestIndex = right;
            }

            if (this.ns[smallestIndex] != this.ns[e]) {
                Node smallest = this.ns[smallestIndex];
                this.ns[smallestIndex] = this.ns[e];
                this.ns[e] = smallest;
                minHeapify(smallestIndex);
            }

        }

    }

    private Heap h;

    public MinPQ(Node[] ns) {
        this.h = new Heap(ns);
    }

    Node extractMin() {
        Node min = this.h.ns[0];
        int last = h.heapSize - 1;
        this.h.ns[0] = this.h.ns[last];

        // Fill the removed value with null
        this.h.ns[last] = null;
        this.h.heapSize -= 1;
        this.h.minHeapify(0);
        return min;
    }

    boolean isEmpty() {
        return this.h.heapSize == 0;
    }

}


class Dijkstra {

    // The process of relaxing an edge (u, v) consists of testing
    // whether we can improve the shortest path to v found by going
    // through u & if so, updating v.d & v.predecessor
    private static void relax(Node u, Node v, int weight) {
        int thruU = u.getD() + weight;
        if (v.getD() > thruU) {
            v.setD(thruU);
            v.setPredecessor(u);
        }
    }

    static void traverse(Graph g, Node source) {
        g.initializeSingleSource(source);
        // Set<Node> s = new HashSet<>();  // Visited

        Node[] ns = new Node[g.ns.size()];
        int i = 0;
        for (Node n : g.ns) {
            ns[i++] = n;
        }

        MinPQ q = new MinPQ(ns);

        while (!q.isEmpty()) {
            // At first run, the source node should be extracted.
            Node u = q.extractMin();
            // s.add(u);
            for (Node v : g.adj.get(u).keySet()) {
                relax(u, v, g.weight(u, v));
            }
        }
    }


    public static void main(String[] args) {
        Node s = new Node("s");
        Node t = new Node("t");
        Node x = new Node("x");
        Node y = new Node("y");
        Node z = new Node("z");

        Graph g = new Graph();

        g.addDirectedEdge(s, t, 10);
        g.addDirectedEdge(s, y, 5);
        g.addDirectedEdge(t, y, 2);
        g.addDirectedEdge(t, x, 1);
        g.addDirectedEdge(y, x, 9);
        g.addDirectedEdge(y, z, 2);
        g.addDirectedEdge(y, t, 3);
        g.addDirectedEdge(x, z, 4);
        g.addDirectedEdge(z, x, 6);
        g.addDirectedEdge(z, s, 7);

        traverse(g, s);
        System.out.println("pause");
    }

}
