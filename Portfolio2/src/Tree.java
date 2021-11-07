public class Tree {

    Node root;

    public void insert(Node n) {

        if (root == null) {
            root = n;
        } else {
            Node curr = root;
            Node parent;

            while(true) {
                parent = curr;

                if (n.dis < curr.dis) {
                    curr = curr.left;

                    if(curr == null) {
                        parent.left = n;
                        return;
                    }
                } else {
                    curr = curr.right;

                    if (curr == null) {
                        parent.right = n;
                        return;
                    }
                }
            }
        }
    }

    public void BFS(Node targetNode) {
        if (targetNode != null) {
            BFS(targetNode.left);

            System.out.println(targetNode);

            BFS(targetNode.right);
        }
    }

}
