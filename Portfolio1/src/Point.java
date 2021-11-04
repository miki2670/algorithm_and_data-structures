// using point class to instantiate new point object with their x and y value
// this way i can have an ArrayList of type Point
public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
