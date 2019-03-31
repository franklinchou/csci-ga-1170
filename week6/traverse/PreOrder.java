// Tree = { 1, 2, 3, 4, 5 }
// pre order = { 1, 2, 4, 5, 3 }
// In preorder, the root is always first

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


// Pre-order traversal:
// Node itself
// Left children
// Right children
class PreOrder { // preorder

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
    if (root == null) {
      return;
    }
    System.out.println(root.key);
    preorder(root.left);
    preorder(root.right);
  }

  public static void main(String[] args) {
    BinaryTree t = makeTree();
    preorder(t.root);
  }
}
