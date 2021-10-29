import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Logic logic = new Logic();

        // Input Test 1
        ArrayList<Point> input1 = new ArrayList<>();
        input1.add(new Point(7,1));
        input1.add(new Point(12,3));
        input1.add(new Point(14,6));
        input1.add(new Point(9,4));
        input1.add(new Point(1,6));
        input1.add(new Point(1,1));
        input1.add(new Point(2,2));
        input1.add(new Point(3,3));
        input1.add(new Point(4,4));
        input1.add(new Point(1,2));
        input1.add(new Point(2,4));
        input1.add(new Point(3,6));
        input1.add(new Point(4,7));

        // create the matchingSlopes hashmap with slope as key
        // and list of pointpairs that shares the same slope
        HashMap<Double, ArrayList<PointPair>> mapTest1 = logic.matchingSlopes(input1);

        // use the matchingSlopes hashmap to create a final hashmap
        // that contains the points(ArrayList<Point>) - value
        // that are on the same line equation(String) - key
        HashMap<String, ArrayList<Point>> collinearPointsTest1 = logic.getCollinearPoints(mapTest1);

        // print out the final hashmap
        logic.print(collinearPointsTest1);

        // Input Test 2
        ArrayList<Point> input2 = new ArrayList<>();
        input2.add(new Point(7,1));
        input2.add(new Point(12,5));
        input2.add(new Point(14,6));
        input2.add(new Point(9,4));
        input2.add(new Point(1,6));
        input2.add(new Point(2,2));
        input2.add(new Point(3,3));
        input2.add(new Point(4,4));
        input2.add(new Point(1,2));
        input2.add(new Point(2,4));
        input2.add(new Point(3,6));
        input2.add(new Point(4,7));

        HashMap<Double, ArrayList<PointPair>> mapTest2 = logic.matchingSlopes(input2);

        HashMap<String, ArrayList<Point>> collinearPointsTest2 = logic.getCollinearPoints(mapTest2);
        logic.print(collinearPointsTest2);

        // Input Test 3
        ArrayList<Point> input3 = new ArrayList<>();
        input3.add(new Point(7,1));
        input3.add(new Point(12,3));
        input3.add(new Point(14,6));
        input3.add(new Point(9,4));
        input3.add(new Point(1,6));
        input3.add(new Point(2,1));
        input3.add(new Point(1,4));
        input3.add(new Point(1,5));
        input3.add(new Point(4,4));
        input3.add(new Point(1,2));
        input3.add(new Point(2,5));
        input3.add(new Point(3,6));
        input3.add(new Point(4,8));

        HashMap<Double, ArrayList<PointPair>> mapTest3 = logic.matchingSlopes(input3);

        HashMap<String, ArrayList<Point>> collinearPointsTest3 = logic.getCollinearPoints(mapTest3);
        logic.print(collinearPointsTest3);

        // Input Test 4
        ArrayList<Point> input4 = new ArrayList<>();
        input4.add(new Point(2,2));
        input4.add(new Point(3,3));
        input4.add(new Point(4,4));
        input4.add(new Point(7,1));
        input4.add(new Point(14,6));
        input4.add(new Point(9,4));
        input4.add(new Point(1,1));
        input4.add(new Point(1,4));
        input4.add(new Point(1,5));
        input4.add(new Point(1,2));
        input4.add(new Point(2,4));

        HashMap<Double, ArrayList<PointPair>> mapTest4 = logic.matchingSlopes(input4);

        HashMap<String, ArrayList<Point>> collinearPointsTest4 = logic.getCollinearPoints(mapTest4);
        logic.print(collinearPointsTest4);
    }
}
