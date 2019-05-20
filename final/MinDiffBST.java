class BTree {
    
    BNode root;
    int minDiff;
    
    public BTree(BNode root) {
        this.root = root;
        this.minDiff = 0;
    }
    
    int prev = 0;
    
    // The min difference in a sorted binary tree must exist
    // between two consecutive nodes. Perform in order
    // traversal to determine the minimum difference.
    public void minDiff(BNode n) {
        if (n == null) {
            return;
        }
        minDiff(n.left);
        int d = Math.abs(n.key - prev);
        // System.out.println("d = " + d);
        if (minDiff > d) {
            minDiff = d;
        }
        prev = n.key;
        minDiff(n.right);
    }
        
}

class BNode {
    
    BNode left;
    BNode right;
    
    int key;
    
    public BNode(int k) {
        this.key = k;
        this.left = null;
        this.right = null;
    }
    
}


// Give an algorithm to return the minimum difference between 
// two keys in a BST
public class MinDiffBST {
    
    public static void main(String args[]) {
        // See BST, CLRS, p. 287.
        BNode root = new BNode(6);
        root.left = new BNode(5);
        root.right = new BNode(7);
        root.left.left = new BNode(2);
        root.left.right = new BNode(5);
        root.right.right = new BNode(8);
        
        BTree tree = new BTree(root);
        tree.minDiff(root);
        System.out.println(tree.minDiff);
    }
    
}
