import java.util.LinkedList;
import java.util.Stack;

class Node {

    String color;
    String key;
    LinkedList<Node> adj;
    int discovered;

    public Node(String key) {
        this.key = key;
        this.color = "WHITE";
        this.adj = new LinkedList<>();
        this.discovered = 0;
    }

    void visit(int d) {
        this.color = "BLACK";
        this.discovered = d;
    }

}

class Graph {

    void addDirectedEdge(Node u, Node v) {
        u.adj.add(v);
    }

    void traverse(Node s) {
        Stack<Node> st = new Stack<>();
        
        // Visited nodes can be memoized either using a hash set or
        // by modifying the node's color.
        // Set<Node> visited = new HashSet<>();
        
        st.push(s); // push the source node onto the stack

        // global discovery time
        int d = 0;

        while (!st.isEmpty()) {
            Node current = st.pop();
            if (current.color.equals("WHITE")) {
                current.visit(d);
                d += 1;
            }

            // Push all adjacent of current onto the stack
            for (Node a : current.adj) {
                st.push(a);
            }
        }
    }

}

class NonRecursiveDFS {

    public static void main(String[] args) {

        Graph g = new Graph();

        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        g.addDirectedEdge(a, b);
        g.addDirectedEdge(a, c);
        g.addDirectedEdge(b, d);
        g.addDirectedEdge(b, e);
        g.addDirectedEdge(c, f);

        g.traverse(a);

        System.out.println("pause");
    }
}
