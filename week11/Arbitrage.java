import org.apache.commons.lang3.tuple.Triple;

import java.math.BigDecimal;
import java.util.*;

class Graph {

    HashMap<Node, HashMap<Node, BigDecimal>> adj;

    Set<Node> ns;

    public Graph() {
        this.ns = new HashSet<>();
        this.adj = new HashMap<>();
    }


    void addDirectedEdge(Node u, Node v, BigDecimal weight) {
        HashMap<Node, BigDecimal> m;

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

    BigDecimal weight(Node u, Node v) {
        if (this.adj.get(u) == null && this.adj.get(u).get(v) != null) {
            return null;
        }
        return this.adj.get(u).get(v);
    }

    void initializeSingleSource(Node s) {
        for (Node n : this.ns) {
            n.setD(new BigDecimal(Integer.MAX_VALUE));
        }
        s.setD(new BigDecimal(0));
    }

    // The process of relaxing an edge (u, v) consists of testing
    // whether we can improve the shortest path to v found by going
    // through u & if so, updating v.d & v.predecessor
    private static void relax(Node u, Node v, BigDecimal weight) {
        BigDecimal thruU = u.getD().add(weight);
        if (v.getD().compareTo(thruU) > 0) {
            v.setD(thruU);
            v.setPredecessor(u);
        }
    }


    // Flatten the adjacency list
    LinkedList<Triple<Node, Node, BigDecimal>> edges() {
        LinkedList<Triple<Node, Node, BigDecimal>> result = new LinkedList<>();
        for (Map.Entry<Node, HashMap<Node, BigDecimal>> e : this.adj.entrySet()) {
            HashMap<Node, BigDecimal> out = e.getValue();
            for (Node o : out.keySet()) {
                result.add(Triple.of(e.getKey(), o, out.get(o)));
            }
        }
        return result;
    }

    // Traverse using the Bellman-Ford algorithm, CLRS, p. 651
    boolean traverse(Node s) {
        initializeSingleSource(s);
        for (int i = 0; i < this.ns.size(); i++) {
            for (Triple e : this.edges()) {
                Node u = (Node) e.getLeft();
                Node v = (Node) e.getMiddle();
                BigDecimal weight = (BigDecimal) e.getRight();
                relax(u, v, weight);
            }
        }
        for (Triple e: this.edges()){
            Node u = (Node) e.getLeft();
            Node v = (Node) e.getMiddle();
            BigDecimal weight = (BigDecimal) e.getRight();
            if (v.getD().compareTo(u.getD().add(weight)) > 0) {
                return false;
            }
        }
        return true;
    }

}


class Node {

    private BigDecimal d;
    private Node predecessor;
    String key;

    public Node(String key) {
        this.key = key;
    }

    void setD(BigDecimal d) {
        this.d = d;
    }

    BigDecimal getD() {
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

            if (left != null && inArrayBound(left) &&
                    this.ns[left].getD().compareTo(this.ns[e].getD()) < 0) {
                smallestIndex = left;
            } else {
                smallestIndex = e;
            }

            if (right != null && inArrayBound(right) &&
                    this.ns[right].getD().compareTo(this.ns[smallestIndex].getD()) < 0) {
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


class Arbitrage {


    public static void main(String[] args) {
        Node usd = new Node("USD");
        Node inr = new Node("INR");
        Node jpy = new Node("JPY");


        Graph g = new Graph();

        g.addDirectedEdge(usd, inr, new BigDecimal(49));
        g.addDirectedEdge(usd, jpy, new BigDecimal(0.0107));
        g.addDirectedEdge(inr, usd, new BigDecimal(1));
        g.addDirectedEdge(inr, jpy, new BigDecimal(2));
        g.addDirectedEdge(jpy, usd, new BigDecimal(1));
        g.addDirectedEdge(jpy, inr, new BigDecimal(1));

        g.traverse(usd);

        System.out.println("pause");
    }

}
