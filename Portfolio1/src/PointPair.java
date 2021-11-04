// using PointPair class to instantiate new PointPairs with their own two points
// this way i can group Points to their dedicated space in my matchingSlopes hashmap creation
// also i can have an ArrayList of type PointPair
public class PointPair {

    private Point point1;
    private Point point2;

    public PointPair(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }
}

