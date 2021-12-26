public class BinarySearchTree {

    // root of binary tree
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    /* Given a binary tree, print its nodes according to the
      "bottom-up" POSTORDER TRAVERSAL. */
    public void printPostorder(Node node) {
        if (node == null) {
            return;
        }

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }

    // Given a binary tree, print its nodes in INORDER
    public void printInorder(Node node) {
        if (node == null) {
            return;
        }

        // first recur on left child
        printInorder(node.left);

        // then print the data of node
        System.out.print(node.key + " ");

        // now recur on right child
        printInorder(node.right);
    }

    // Given a binary tree, print its nodes in PREORDER
    public void printPreorder(Node node) {
        if (node == null) {
            return;
        }

        // first print data of node
        System.out.print(node.key + " ");

        // then recur on left subtree
        printPreorder(node.left);

        // now recur on right subtree
        printPreorder(node.right);
    }

    // LEVEL ORDER TRAVERSAL
    public void printLevelorder(Node node) {
        int h = height(node);
        for (int i = 1; i <= h; i++) {
            printCurrentLevel(node, i);
        }
    }
    // Helper methods for level order traversal

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node root) {
        if (root == null) {
            return 0;
        }
        else {
            /* compute  height of each subtree */
            int leftheight = height(root.left);
            int rightheight = height(root.right);

            /* use the larger one */
            if (leftheight > rightheight)
                return (leftheight + 1);
            else
                return (rightheight + 1);
        }
    }

    /* Print nodes at the current level */
    void printCurrentLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.key + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    // prints the Internal Path Length
    public int printInternalPathLength(Node root, int count) {

        if (root == null || root.left == null || root.right == null) {
            return 0;
        }

        return (count + printInternalPathLength(root.left, count+1)+printInternalPathLength(root.right, count+1));
    }

    // prints the External Path Length
    public int printExternalPathLength(Node root, int count) {

        if (root == null) {
            return 0;
        }

        return (count + printExternalPathLength(root.left, count+1)+printExternalPathLength(root.right, count+1));
    }

    // Wrapper methods to above methods so they always use the root to print
    public void printPostorder() { printPostorder(root); System.out.println(); }
    public void printInorder() { printInorder(root); System.out.println(); }
    public void printPreorder() { printPreorder(root); System.out.println(); }
    public void printLevelorder() { printLevelorder(root); System.out.println(); }
    public void printInternalPathLength() { System.out.print(printInternalPathLength(root, 0)); System.out.println(); }
    public void printExternalPathLength() { System.out.print(printExternalPathLength(root, 0)); System.out.println(); }
}
