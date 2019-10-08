import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Set;
import java.util.TreeSet;

public class PointSET {

	private final Set<Point2D> set;
	private int N;

	public PointSET() {
		// construct an empty set of points
		this.set = new TreeSet<>();
		this.N = set.size();
	}

	public boolean isEmpty() {
		// is the set empty?
		return N == 0;
	}

	public int size() {
		// number of points in the set
		return N;
	}

	public void insert(Point2D p) {
		// add the point to the set (if it is not already in the set)
		if (p == null) throw new IllegalArgumentException();
		if (set.contains(p)) return;
		else set.add(p);
	}

	public boolean contains(Point2D p) {
		// does the set contain point p?
		return set.contains(p);
	}

	public void draw() {
		// draw all points to standard draw
//		this.set.forEach(Point2D::draw);
		for (Point2D p : set) {
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.setPenRadius(0.01);
			p.draw();
		}
	}

	public Iterable<Point2D> range(RectHV rect) {
		// all points that are inside the rectangle (or on the boundary)
		Set<Point2D> containSet = new TreeSet<>();
		for (Point2D p : set) {
			if (rect.contains(p))
				containSet.add(p);
		}

		return containSet;
	}


	public Point2D nearest(Point2D p) {
		// a nearest neighbor in the set to point p; null if the set is empty
		if (p == null) throw new IllegalArgumentException();
		if (this.isEmpty()) return null;
		double minDist = Double.POSITIVE_INFINITY;
		Point2D nearestPoint = null;
		for (Point2D e : set) {
			if (e.distanceSquaredTo(p) < minDist) {
				minDist = e.distanceSquaredTo(p);
				nearestPoint = e;
			}
		}
		return nearestPoint;
	}

	public static void main(String[] args) {
		// unit testing of the methods (optional)
	}
}