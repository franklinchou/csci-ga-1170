// https://www.geeksforgeeks.org/threaded-binary-tree/

class Node {
  int data;
  Node left;
  Node right;
  // rightThread is used to indicate
  // whether right points to a right child
  // or to a in-order successor
  Boolean rightThread;

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

class Main {

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
    n3.left.rightThread = true;
    n3.right = new Node(5);
    n3.right.right = t.root; // portal
    n3.right.rightThread = true; 
    n8.left = new Node(7);
    n8.left.right = n8; // portal
    n8.left.rightThread = true;
    n8.right = new Node(11);

    // Tier 4
    Node n11 = n8.right;
    n11.left = new Node(9);
    n11.left.right = n11;
    n11.left.rightThread = true; // portal
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

  // Pass in the root node of the binary tree
  private static void inOrder(Node root) {
    if (root == null) { 
      return;
    }
    Node c = leftMost(root);
    while(c != null) {
      System.out.println(c.data);
      if (c.rightThread != null && c.rightThread) {
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
