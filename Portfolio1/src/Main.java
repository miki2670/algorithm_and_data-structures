import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[][] input = {{7,1},{12,4},{14,6},{9,4},{1,6},{1,1},{2,2},{3,3},{4,4},{1,2},{2,4},{3,6},{4,8}};

        ArrayList<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i][0] == input[i][1]) {
                pairs.add(new int[] {input[i][0], input[i][1]});
            }
        }

        for (int[] e : pairs) {
            System.out.println(Arrays.toString(e));
        }

    }
}
