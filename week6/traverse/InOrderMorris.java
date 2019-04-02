// Similar to in order thread, but does not use boolean isThread indicator

class Node {
  int data;
  Node left;
  // Right will point to a "true" right node or
  // the node's "in order successor"
  Node right; 
  public Node(int e) {
    data = e;
  }
}

class BTree {
  Node root;

  // Create a BTree
  public BTree() {
    root = null;
  }
}

public class Main {

  // All leaves (except the last right-most leaf)
  // must have a portal
  private static BTree makeTree() { 
    BTree t = new BTree();
    t.root = new Node(6);
    // Tier 2
    t.root.left = new Node(3);
    t.root.right = new Node(8);

    // Tier 3
    Node n3 = t.root.left;
    Node n8 = t.root.right;
    n3.left = new Node(1);
    n3.left.right = n3; // portal
    n3.right = new Node(5);
    n3.right.right = t.root; // portal
    n8.left = new Node(7);
    n8.left.right = n8; // portal
    n8.right = new Node(11);

    // Tier 4
    Node n11 = n8.right;
    n11.left = new Node(9);
    n11.left.right = n11; // portal
    n11.right = new Node(13);
    return t;
  }

  // return the left most element of a tree,
  // the left most element of a single node is the node itself
  private static Node leftMost(Node n) {
    Node c = n;
    if (n == null) {
      return null;
    }
    while (c.left != null) {
      c = c.left; 
    }
    return c;
  }
  
  
  // Check if a node n is the in order successor of a given
  // root node
  private static Node inOrderSuccessor(Node r, Node n) { 
    Node s = null;
    if (n.right != null) {
        s = leftMost(n);
    } else {
        while (r != null) {
            if (r.data > n.data) {
                // traverse right
                r = r.right;
            } else if (r.data < n.data) {
                // traverse left
                s = r;
                r = r.left;
            } else {
                break;
            }
        }
    }
    return s;
  }
  
  // Pass in the root node of the binary tree
  private static void inOrder(Node root) {
    if (root == null) { 
      return;
    }
    Node c = leftMost(root);
    while(c != null) {
      System.out.println(c.data);
      if (c.right == inOrderSuccessor(root, c)) {
        // In the case of a "portal"
        c = c.right;
      } else { 
        c = leftMost(c.right);
      }
    }
  }

  public static void main(String[] args) {
    BTree t = makeTree();

    // test leftMost
    assert(leftMost(t.root).data == 1);
    assert(leftMost(t.root.right).data == 7);

    inOrder(t.root);
  }
}
