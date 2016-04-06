// Java program to connect nodes at same level using extended
// pre-order traversal
 
// A binary tree node
class Node {
 
    int data;
    Node left, right, nextRight;
 
    Node(int item) {
        data = item;
        left = right = nextRight = null;
    }
}
 
class BinaryTree {
 
    static Node root;
 
    // Sets the nextRight of root and calls connectRecur() for other nodes
    void connect(Node p) {
 
        // Set the nextRight for root
        p.nextRight = null;
 
        // Set the next right for rest of the nodes (other than root)
        connectRecur(p);
    }
 
    /* Set next right of all descendents of p.
     Assumption:  p is a compete binary tree */
    void connectRecur(Node p) {
 
        // Base case
        if (p == null) {
            return;
        }
 
        // Set the nextRight pointer for p's left child
        if (p.left != null) {
            p.left.nextRight = p.right;
        }
 
        // Set the nextRight pointer for p's right child
        // p->nextRight will be NULL if p is the right most child at its level
        if (p.right != null) {
            p.right.nextRight = (p.nextRight != null) ? p.nextRight.left : null;
        }
 
        // Set nextRight for other nodes in pre order fashion
        connectRecur(p.left);
        connectRecur(p.right);
    }
 
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
 
        // Populates nextRight pointer in all nodes
        tree.connect(root);
 
        // Let us check the values of nextRight pointers
        System.out.println("Following are populated nextRight pointers in the tree "
                + "(-1 is printed if there is no nextRight)");
        int a = root.nextRight != null ? root.nextRight.data : -1;
        System.out.println("nextRight of " + root.data + " is "
                + a);
        int b = root.left.nextRight != null ? root.left.nextRight.data : -1;
        System.out.println("nextRight of " + root.left.data + " is "
                + b);
        int c=root.right.nextRight != null ? root.right.nextRight.data : -1;
        System.out.println("nextRight of " + root.right.data + " is "
                + c);
        int d = root.left.left.nextRight != null ? root.left.left.nextRight.data : -1;
        System.out.println("nextRight of " + root.left.left.data + " is "
                + d);
 
    }
}
