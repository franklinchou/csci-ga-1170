// Tree = { 1, 2, 3, 4, 5 }
// post order = { 4, 5, 2, 3, 1 }
// In post order the root is always last

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


// Post-order traversal:
// Left children
// Right children
// Node itself
class Main {

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
  private static void postorder(Node root) {
    if (root == null) {
      return;
    }
    postorder(root.left);
    postorder(root.right);
    System.out.println(root.key);
  }

  public static void main(String[] args) {
    BinaryTree t = makeTree();
    postorder(t.root);
  }
}
