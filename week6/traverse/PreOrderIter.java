import java.util.Stack;

class Node {
  int key;
  Node left;
  Node right;

  public Node(int element) {
    key = element;
    right = null;
    left = null;
  }

}

class BinaryTree { 
  Node root;

  public BinaryTree() {
    root = null;
  }

}

class PreOrderIter { 

  private static BinaryTree makeTree() {
    // construct a Tree
    BinaryTree bt = new BinaryTree();
    bt.root = new Node(1);
    bt.root.left = new Node(2);
    bt.root.right = new Node(3);
    
    Node n = bt.root.left;
    n.left = new Node(4);
    n.right = new Node(5);

    return bt;
  }

  // Given the root node of a binary tree, traverse the tree pre order
  private static void preorder(Node root) {
    Stack<Node> s = new Stack<Node>();

    if (root == null) {
      return;
    } 

    Node current = root;
    s.push(current);
    while (!s.isEmpty()) {
      Node t = s.pop();
      System.out.println(t.key);
      // Because of the mechanics of a stack, the right children must
      // be pushed first
      if (t.right != null) {
        s.push(t.right);
      }
      if (t.left != null) {
        s.push(t.left);
      }
    }
  }

  public static void main(String[] args) {
    BinaryTree t = makeTree();
    preorder(t.root);
  }
}
