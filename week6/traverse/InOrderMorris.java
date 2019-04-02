// Similar to in order thread, but does not use boolean isThread indicator

import java.util.Stack;

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

public class InOrderMorris {

  // All leaves (except the last right-most leaf)
  // must have a portal
  private static BTree makeTree() { 
    BTree t = new BTree();
    t.root = new Node(10);
    t.root.left = new Node(5);
    t.root.left.left = new Node(2);
    t.root.left.right = new Node(7);
    t.root.right = new Node(15);
    t.root.right.right = new Node(30);
    return t;
  }

  // find the predecessor, the right most element of the
  // left subtree
  private static Node predecessor(Node n) {
    if (n.left == null) {
      return null;
    }

    Node c = null;
    Stack<Node> s = new Stack<Node>();
    if (n.left != null) {
      c = n.left;
    }

    while (c != null) {
      s.push(c);
      if (c.right == null) {
        break;
      }
      c = c.right;
    }
    return s.pop();
  }
  
  // Pass in the root node of the binary tree
  private static void morrisTraversal(Node r) {
    Node c = r;
    while (c != null) {
      if (c.left == null) {
        System.out.println(c.data);
        c = c.right;
        if (c != null) {
          c.left = null;
        }
      } else {
        Node p = predecessor(c);
        if (p.right == null) {
          p.right = c;
          c = c.left;
        } else {
          p.right = null;
          System.out.println(c.data);
          c = c.right;
        }
      }
    }
  }

  public static void main(String[] args) {
    BTree t = makeTree();

    assert(predecessor(t.root).data == 7); 
    assert(predecessor(t.root.left).data == 2);

    morrisTraversal(t.root);
  }
}
