import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[][] input1 = {{7,1},{12,4},{14,6},{9,4},{1,6},{1,1},{2,2},{3,3},{4,4},{1,2},{2,4},{3,6},{4,8}};
        int[][] input2 = {{7,1},{12,4},{14,6},{1,6},{2,2},{3,3},{4,4},{1,2},{2,4},{3,6},{4,8}};
        int[][] input3 = {{7,1},{14,6},{9,4},{1,6},{1,1},{1,4},{1,5},{4,4},{1,2},{2,4},{3,6},{4,8}};
        int[][] input4 = {{2,2},{3,3},{4,4},{7,1},{14,6},{9,4},{1,6},{1,1},{1,4},{1,5},{4,4},{1,2},{2,4}};

        List<int[]> solutions = points(input2);

        for (int[] e : solutions) {
            System.out.println(Arrays.toString(e));
        }

    }

    public static List<int[]> points(int[][] input) {
        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i][0] == input[i][1]) {
                pairs.add(new int[] {input[i][0], input[i][1]});
            }
        }

        if (pairs.size() == 4) {
            return pairs;
        }

        return null;
    }
}
