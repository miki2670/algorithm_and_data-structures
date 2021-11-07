public class Node {
    int x;
    int y;
    int dis;
    Node left;
    Node right;

    public Node(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }

    public String toString() {
        return "x: " + x + " y: " + y + " distance: " + dis;
    }
}
