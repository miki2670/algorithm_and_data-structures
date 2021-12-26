public class main {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(
                "Preorder traversal ");
        tree.printPreorder();

        System.out.println(
                "\nInorder traversal ");
        tree.printInorder();

        System.out.println(
                "\nPostorder traversal ");
        tree.printPostorder();

        System.out.println(
                "\nLevel order traversal ");
        tree.printLevelorder();

        System.out.println(
                "\nInternal Path Length ");
        tree.printInternalPathLength();

        System.out.println(
                "\nExternal Path Length ");
        tree.printExternalPathLength();
    }


}
