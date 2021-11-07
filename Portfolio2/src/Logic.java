import java.util.ArrayList;

public class Logic {

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

        int knightPos[] = {knight_start_x_position, knight_start_y_position};

        // knight's possible moves
        int xMoves[] = { +1, +2, +2, +1, -1, -2, -2, -1 };
        int yMoves[] = { +2, +1, -1, -2, -2, -1, +1, +2 };

        // storing moves
        ArrayList<CellPoint> queue = new ArrayList<>();

        // starting position to queue
        queue.add(new CellPoint(knightPos[0], knightPos[1], 0));

        CellPoint cell;
        int x;
        int y;
        boolean visited[][] = new boolean[board_width + 1][board_height + 1];
        
        // make cells unvisited 
        for (int i = 1; i <= board_width; i++) {
            for (int j = 1; j <= board_height; j++) {
                visited[i][j] = false;
            }
        }

        // make starting point visited
        visited[knightPos[0]][knightPos[1]] = true;

        Tree tree = new Tree();

        // while (node.next = true)
        // if node.data.x == knight-start-x && node.data.y == knight-start-y
            // return node

        // tree.insert(Node n = new Node(new CellPoint(x, y, cell.dis + 1));
        while (!queue.isEmpty()) {
            cell = queue.get(0);
            queue.remove(0);

            // if target pos found return distance
            if(cell.x == knight_end_x_position && cell.y == knight_end_y_position) {
                tree.BFS(tree.root);
                return cell.dis;
            }

            // set next visited cells
            for (int i = 0; i < 8; i++) {
                x = cell.x + xMoves[i];
                y = cell.y + yMoves[i];

                if(isInsideOfBoard(x, y, board_height, board_width) && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new CellPoint(x, y, cell.dis + 1));
                    tree.insert(new Node(x,y,cell.dis+1));
                }
            }
        }

        // return infinity if path not possible
        return Integer.MAX_VALUE;
    }

    public static boolean isInsideOfBoard(int x, int y, int board_height, int board_width) {
        if (x >= 1 && x <= board_width && y >= 1 && y <= board_height) {
            return true;
        }
        return false;
    }

}
