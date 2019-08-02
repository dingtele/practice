package collinearpoints;

import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;


public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public double slopeTo(Point that) {
        double slope = (that.y - this.y) / (that.x - this.y);
        if (this.x == that.x) 	return Double.POSITIVE_INFINITY;
        else if (this.y == that.y) 	return +0.0;
        else if ((this.x == that.x) && (this.y == that.y)) 	return Double.NEGATIVE_INFINITY;
        else 	return slope;
    }

    public int compareTo(Point that) {
        if (((that.y == this.y) && (this.x < that.x)) || (this.y < that.y)) 	return -1;
        else if ((this.x == that.x) && (this.y == that.y)) 	return 0;
        else return 1;
    }

    public Comparator<Point> slopeOrder() {
    	return new compareBySlope();
    }

    
    private class compareBySlope implements Comparator<Point>{
    	
    	public int compare (Point a, Point b) {
    		if (a.slopeTo(Point.this) < b.slopeTo(Point.this)) 	return -1;
    		else return (int) a.slopeTo(b);
    	}
    }

    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
       Point p0 = new Point(1,1);
       p0.slopeOrder();
       
    }
}