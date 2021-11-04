import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Logic {

    // I achieve the O(n^2 log n) time complexity by using:
    // nested loops O(n^2) in my program
    // and using the merge sort algorithm O(log n) to sort my array of points

    // creates and returns a hashmap with the slope of the pointpair as key (double)
    // and with a list of point pairs as value
    public HashMap<Double, ArrayList<PointPair>> matchingSlopes(ArrayList<Point> input) { // O(n^2)

        // sort array input by x value by comparing the two point's x value
        input.sort((o1, o2) -> o1.getX() - o2.getX()); // O(log n) - using merge sort method from java

        // save slopes and pairs together
        HashMap<Double, ArrayList<PointPair>> pairs = new HashMap<>(); // O(1)

        // iterates over the input list of points and calculates the slope between the two points that gets iterated
        // find point pairs in input and save them to a hashmap with their slope
        for (int i = 0; i < input.size()-1; i++) { // O(n^2)
            for (int j = i+1; j < input.size(); j++) {

                // calculate slope between the two points
                double slope = calculateSlope(input.get(i), input.get(j));

                // if the hashmap already contains the slope as key
                // add the two points as pointpair to that already existing slope's key value
                // as they share the slope - example: {1,1}, {2,2} = (y2-y1) / (x2-x1) = (2-1)/(2-1) = 1
                // points {1,1} and {2,2} share the same slope
                if (pairs.containsKey(slope)) {
                    // then add the two points as pairs
                    PointPair pointPair = new PointPair(input.get(i), input.get(j));
                    // and add them to that key in the hashmap
                    pairs.get(slope).add(pointPair);
                } else {
                    // if the hashmap does not contain the slope already as key
                    // then make a new list of pairs with the current two points
                    // with the new slope that didnt exist as key
                    ArrayList<PointPair> pairsList = new ArrayList<>();
                    pairsList.add(new PointPair(input.get(i), input.get(j)));
                    pairs.put(slope, pairsList);
                }
            }
        }
        return pairs;
    }

    // returns a hashmap of the valid collinear points
    // uses the matchingSlopes hashmap as argument
    public HashMap<String, ArrayList<Point>> getCollinearPoints(HashMap<Double, ArrayList<PointPair>> matchingSlopes) { // O(n^2)

        // result map of collinear points
        HashMap<String, HashSet<Point>> collinearPoints = new HashMap<>(); // O(1)

        // loop through the matchingSlopes hashmap
        for (Map.Entry<Double, ArrayList<PointPair>> element : matchingSlopes.entrySet()) { // O(n^2)
            // iterate through every value in the hashmap i.e every pointpair
            for (int i = 0; i < element.getValue().size(); i++) {
                // check the two points in pointpair list if they are collinear
                // use line equation as key in the result hashmap
                Point point1 = element.getValue().get(i).getPoint1();
                Point point2 = element.getValue().get(i).getPoint2();
                // get the line equation for the two points
                String line = getLineEquation(point1, point2);
                // if the collinearpoints hashmap contains the line equation string as key
                // i.e the two current points are on the same line
                if (collinearPoints.containsKey(line)) {
                    // then add the points as value to that line equation string key
                    collinearPoints.get(line).add(point1);
                    collinearPoints.get(line).add(point2);
                }
                // if collinearPoints map does not contain line equation key
                else {
                    // make a new empty value to later add points that are on same line
                    HashSet<Point> tempSet = new HashSet<>();
                    // and add the line equation string as key and the empty set as value
                    collinearPoints.put(line, tempSet);
                }
            }
        }

        HashMap<String, ArrayList<Point>> resultMap = new HashMap<>(); // O(1)

        // loop through the collinear points that now contains all the points on the same line
        for (Map.Entry<String, HashSet<Point>> element : collinearPoints.entrySet()) { // O(n)
            // if there are >= 4 points on that line
            if (element.getValue().size() >= 4) {
                // make a new list with those >= 4 points
                ArrayList<Point> tempList = new ArrayList<>(element.getValue());
                // and add them to the result hashmap with their line equation string
                resultMap.put(element.getKey(), tempList);
            }
        }
        return resultMap;
    }


    public double calculateSlope(Point point1, Point point2) { // O(1)

        // if the points are a horizontal linear = they have the same slope
        // example: {4,4}, {9,4} = y2 - y1 = 4-4 = 0 i.e their slope is the same
        if ((point2.getY()-point1.getY()) == 0) {
            return 0;
        }
        // if the points are a vertical linear = they have the same slope
        // example: {1,4}, {1,5} = x2 - x1 = 1-1 = 0 i.e their slope is the same
        else if ((point2.getX()-point1.getX()) == 0) {
            return 0;
        }

        // if they are not vertical or horizontal then calculate slope
        // example: {1,1}, {2,2} = (y2-y1) / (x2-x1) = (2-1)/(2-1) = 1
        return (point2.getY()-point1.getY())/(point2.getX()-point1.getX());
    }

    // returns a String with a line equation of two points that are on the same line
    public String getLineEquation(Point point1, Point point2) { // O(1)

        // check for vertical points with x value
        if (point1.getX() == point2.getX()) {
            // equation of vertical line // example: x = 2 i.e vertical line
            return "x = " + point2.getX();
        }
        // check for horizontal points with y value
        if (point1.getY() == point2.getY()) {
            // equation of horizontal line // example: y = 2 i.e horizontal line
            return "y = " + point2.getY();
        }

        // need to account for points like: {2,4}, {3,6}
        // do this by making a line equation
        int a = point2.getY()-point1.getY(); // 6-4 = 2
        int b = point1.getX()-point2.getX(); // 2-3 = -1
        int c = (a * point1.getX()) + (b * point1.getY()); // (2 * 2) + (-1 * 4) = 4-4 = 0
        // line equation for above would be = 2x - 1y = 0

        // need to reduce the line equation for scenarios as: 2x -8y = -14 is the same as 1x -4y = -7
        String reduce = reduce(a, b, c);
        return reduce;
    }

    public String reduce(int a, int b, int c) { // O(1)

        // example points: {2,4}, {3,6}, {4,8}
        // they are both on line equation 2x - 1y = 0
        // so only want to get one line equation for all i.e need to reduce the equation

        // reduce example with 2x - 8y = -14
        if (a % b == 0 && c % b == 0) {
            a = a/b;
            b = b/b;
            c = c/b;
        }
        // 2x - 8y = -14 would go into this if statement
        else if (b % a == 0 && c % a == 0) {
            a = a/a; // 2/2 = 1
            b = b/a; // -8/2 = -4
            c = c/a; // -14/2 = -7
            // reduced line equation 1x -4y = -7
        }
        else if (a % c == 0 && b % c == 0) {
            a = a/c;
            b = b/c;
            c = c/c;
        }

        // return line equation ax + by = c
        return a + "x +" + b + "y = " + c;
    }

    // print method for collinear points
    public void print(HashMap<String, ArrayList<Point>> collinearPoints) { // O(n^2)
        int index = 0;
        System.out.print("{" );
        for (Map.Entry<String, ArrayList<Point>> element : collinearPoints.entrySet()) {
            System.out.print("{" );
            for (int i = 0; i < element.getValue().size(); i++) {
                if (i == element.getValue().size() - 1) {
                    System.out.print("{" + element.getValue().get(i) + "}");
                } else {
                    System.out.print("{" + element.getValue().get(i) + "},");
                }
            }
            if (collinearPoints.entrySet().size()-1 == index) {
                System.out.print("}");
            } else {
                System.out.print("}, ");
            }
            index++;
        }
        System.out.print("}\n");
    }
}
