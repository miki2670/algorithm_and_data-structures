import java.util.ArrayList;
import java.util.List;

public class Tree {

    List<Node> nodes;
    Node root;

    public Tree() {
        nodes = new ArrayList<Node>();
        root = null;
    }

    public int minimum_steps(int board_height, int board_width, int knight_start_x_position, int knight_start_y_position, int knight_end_x_position, int knight_end_y_position) {

        // knight can move:
        // y + 2 and x + 1
        // x + 2 and y + 1
        // x + 2 and y - 1
        // y - 2 and x + 1
        // y - 2 and x - 1
        // x - 2 and y - 1
        // x - 2 and y + 1
        // y + 2 and x - 1

        // set root node to knight's starting position
        this.root = new Node(knight_start_x_position, knight_start_y_position, 0);

        // knight's possible moves
        int xMoves[] = { +1, +2, +2, +1, -1, -2, -2, -1 };
        int yMoves[] = { +2, +1, -1, -2, -2, -1, +1, +2 };

        // knight's starting position i.e root into tree
        Node currentNode = this.root;
        this.insertNode(currentNode);

        // node counter, to move to next node
        int nodeCounter = 0;
        // x and y for temporary position for move
        int x;
        int y;
        // setup visited board with boolean values, true for visited, false for unvisited
        boolean visited[][] = new boolean[board_width + 1][board_height + 1];

        // make all cells unvisited
        for (int i = 0; i < board_width; i++) {
            for (int j = 0; j < board_height; j++) {
                visited[i][j] = false;
            }
        }

        // make starting position visited
        visited[root.x][root.y] = true;

        // while tree has nodes
        while (!this.nodes.isEmpty()) {

            // if target position found return distance
            if(currentNode.x == knight_end_x_position && currentNode.y == knight_end_y_position) {
                return currentNode.distance;
            }

            // set next 8 moves to visited cells if move is inside of board
            for (int i = 0; i < 8; i++) {
                x = currentNode.x + xMoves[i];
                y = currentNode.y + yMoves[i];

                if(isInsideOfBoard(x, y, board_height, board_width) && !visited[x][y]) {
                    visited[x][y] = true;
                    // insert node to tree
                    this.insertNode(new Node(x,y,currentNode.distance + 1));
                }
            }
            currentNode = this.nodes.get(nodeCounter++);
        }

        // return -1 if path not possible
        return -1;
    }

    // insert node to tree
    public void insertNode(Node node) {
        this.nodes.add(node);
    }

    public boolean isInsideOfBoard(int x, int y, int board_height, int board_width) {
        if (x >= 0 && x <= board_width && y >= 0 && y <= board_height) {
            return true;
        }
        return false;
    }
}
