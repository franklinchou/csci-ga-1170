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


// In order traversal:
// Left children
// Node itself
// Right children
class InOrder { // Inorder

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

  // Given the root node of a binary tree, traverse the tree in order
  private static void inorder(Node root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    System.out.println(root.key);
    inorder(root.right);
  }

  public static void main(String[] args) {
    BinaryTree t = makeTree();
    inorder(t.root);
  }
}
