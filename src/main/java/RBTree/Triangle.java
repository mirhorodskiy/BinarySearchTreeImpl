package RBTree;

import java.util.Objects;

public class Triangle implements Comparable<Triangle> {

    int x1;
    int y1;

    int x2;
    int y2;

    int x3;
    int y3;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double perimeter() {
        return getLength(x1, x2, y1, y2) + getLength(x1, x3, y1, y3) + getLength(x2, x3, y2, y3);
    }

    private double getLength(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return x1 == triangle.x1 && y1 == triangle.y1 && x2 == triangle.x2 && y2 == triangle.y2 && x3 == triangle.x3 && y3 == triangle.y3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2, x3, y3);
    }

//    @Override
//    public String toString() {
//        return "RBTree.Triangle{" +
//                "x1=" + x1 +
//                ", y1=" + y1 +
//                ", x2=" + x2 +
//                ", y2=" + y2 +
//                ", x3=" + x3 +
//                ", y3=" + y3 +
//                '}';
//    }
    @Override
    public String toString() {
        return String.format("%.2f", this.perimeter());
    }

    @Override
    public int compareTo(Triangle o) {
        if (this.perimeter() - o.perimeter() < 0) {
            return - 1;
        }
        if (this.perimeter() - o.perimeter() > 0) {
            return 1;
        }
        return 0;
    }
}
