import java.util.Stack;

// In order iterative (complete binary tree)
// tree = { 1, 2, 3, 4, 5 }
// In order = { 4, 2, 5, 1, 3 }

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
class InOrderIter { 

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
    Stack<Node> s = new Stack<Node>();

    Node current = root;
    while (current != null || !s.isEmpty()) {
      // Push all the left children from the root onto the stack 
      while (current != null) {
        s.push(current);
        current = current.left;
      }
      current = s.pop();
      System.out.println(current.key);
      current = current.right;
    }
  }

  public static void main(String[] args) {
    BinaryTree t = makeTree();
    inorder(t.root);
  }
}
