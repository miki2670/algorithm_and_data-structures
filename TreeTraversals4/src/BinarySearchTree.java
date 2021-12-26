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
        System.out.println(node.key + " ");
    }

    // Given a binary tree, print its nodes in INORDER
    public void printInorder(Node node) {
        if (node == null) {
            return;
        }

        // first recur on left child
        printInorder(node.left);

        // then print the data of node
        System.out.println(node.key + " ");

        // now recur on right child
        printInorder(node.right);
    }

    // Given a binary tree, print its nodes in PREORDER
    public void printPreorder(Node node) {
        if (node == null) {
            return;
        }

        // first print data of node
        System.out.println(node.key + " ");

        // then recur on left subtree
        printPreorder(node.left);

        // now recur on right subtree
        printPreorder(node.right);
    }

    // Wrapper methods to above methods so they always use the root to print
    public void printPostorder() { printPostorder(root); }
    public void printInorder() { printInorder(root); }
    public void printPreorder() { printPreorder(root); }

}
