class BT {
    Node root;
    
    public BT(Node r) {
        this.root = r;
    }
    
    // Given a binary tree determine whether it is also a binary search tree
    boolean isBST(Node r, int hi, int lo) {
        if (r == null) {
            return true;
        }
        if (r.left != null && r.left.key < lo) {
            return false;
        }
        if (r.right != null && r.right.key > hi) {
            return false;
        }
        return isBST(r.left, r.key, lo) && isBST(r.right, hi, r.key);
    }
    
}

class Node {
    
    Node left;
    Node right;
    int key;
    
    public Node(int k) {
        this.key = k;
    }
    
}


public class ValidateBST {
    
    public static void main(String[] args) {
        
        Node r = new Node(5);
        r.left = new Node(2);
        r.right = new Node(8);
        r.left.left = new Node(1);
        r.left.right = new Node(7);
        // r.left.right = new Node(3);
        r.right.left = new Node(6);
        BT tree = new BT(r);
        System.out.println(tree.isBST(r, Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
}
