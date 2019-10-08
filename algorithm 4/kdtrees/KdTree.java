import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;
import java.util.TreeSet;

public class KdTree {

	private static class Node {
		private Point2D p;
		private RectHV rec;
		private Node leftBottom;
		private Node rightTop;
		private boolean vertical;

		public Node(Point2D p, RectHV rec, Node leftBottom, Node rightTop, boolean vertical){
			this.p = p;
			this.rec = rec;
			this.leftBottom = leftBottom;
			this.rightTop = rightTop;
			this.vertical = vertical;
		}

		public Point2D getP() {
			return p;
		}

		public boolean isVertical() {
			return vertical;
		}

		public void setVertical(boolean vertical) {
			this.vertical = vertical;
		}

		public void setP(Point2D p) {
			this.p = p;
		}

		public RectHV getRec() {
			return rec;
		}

		public void setRec(RectHV rec) {
			this.rec = rec;
		}

		public Node getLeftBottom() {
			return leftBottom;
		}

		public void setLeftBottom(Node leftBottom) {
			this.leftBottom = leftBottom;
		}

		public Node getRightTop() {
			return rightTop;
		}

		public void setRightTop(Node rightTop) {
			this.rightTop = rightTop;
		}
	}

	private Node root;
	private int size;

	public KdTree() {
		// construct an empty set of points
		this.root = new Node(null, new RectHV(0,0,1.0,1.0), null, null, false);
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public void insert(Point2D p){
		root = this.insert(root, p);
	}

	private Node insert(Node x, Point2D p) {
		// insert new node
		if(x == null){
			x = new Node(p,null,null,null,false);
			size++;
		}

		// search and update node
		Node leftBottom;
		Node rightTop;

		if (!x.isVertical()) { // x is horizontal
			Comparator<Point2D> comparatorX = Point2D.X_ORDER;
			int cmp = comparatorX.compare(x.getP(), p);

			if (cmp > 0) {
				leftBottom = this.insert(x.getLeftBottom(), p);
				if (x.getLeftBottom() == null) {
					leftBottom.setRec(new RectHV(x.getRec().xmin(), x.getRec().xmax()
							, x.getRec().ymin(), x.getP().y()));
					leftBottom.setVertical(true);
				}
				x.setLeftBottom(leftBottom);
			}
			if (cmp < 0) {
				rightTop = this.insert(x.getRightTop(), p);
				if (x.getRightTop() == null) {
					rightTop.setRec(new RectHV(x.getRec().xmin(), x.getRec().xmax()
							, x.getP().y(), x.getRec().ymax()));
					rightTop.setVertical(true);
				}
				x.setRightTop(rightTop);
			} else {
				x.setP(p);
			}
		}

		else { // x is vertical
			Comparator<Point2D> comparatorY = Point2D.Y_ORDER;
			int cmp = comparatorY.compare(x.getP(), p);

			if (cmp > 0) {
				leftBottom = this.insert(x.getLeftBottom(), p);
				if (x.getLeftBottom() == null) {
					leftBottom.setRec(new RectHV(x.getRec().xmin(), x.getP().x()
							, x.getRec().ymin(), x.getRec().ymax()));
					leftBottom.setVertical(false);
				}
				x.setLeftBottom(leftBottom);
			}
			if (cmp < 0) {
				rightTop = this.insert(x.getRightTop(), p);
				if (x.getRightTop() == null) {
					rightTop.setRec(new RectHV(x.getP().x(), x.getRec().xmax()
							, x.getRec().ymin(), x.getRec().ymax()));
					rightTop.setVertical(false);
				}
				x.setRightTop(rightTop);
			} else {
				x.setP(p);
			}
		}
		return x;
	}

	public boolean contains(Point2D p) {
		return this.contains(root, p) != null;
	}

	private Node contains(Node x, Point2D p){
		if (x == null)  return null;

		Node leftBottom;
		Node rightTop;

		if (!x.isVertical()) {
			Comparator<Point2D> comparatorX = Point2D.X_ORDER;
			int cmp = comparatorX.compare(x.getP(), p);

			if (cmp > 0) {
				leftBottom = this.contains(x.getLeftBottom(), p);
				x.setLeftBottom(leftBottom);
			}
			if (cmp < 0) {
				rightTop = this.contains(x.getRightTop(), p);
				x.setRightTop(rightTop);
			}
		}

		else { // x is vertical
			Comparator<Point2D> comparatorY = Point2D.Y_ORDER;
			int cmp = comparatorY.compare(x.getP(), p);
			if (cmp > 0) {
				leftBottom = this.contains(x.getLeftBottom(), p);
				x.setLeftBottom(leftBottom);
			}
			if (cmp < 0) {
				rightTop = this.contains(x.getRightTop(), p);
				x.setRightTop(rightTop);
			}
		}
		return x;
	}

	public void draw() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius();

		Point2D b0 = new Point2D(0.0, 0.0);
		Point2D b1 = new Point2D(1.0, 0.0);
		b0.drawTo(b1);
		Point2D l0 = new Point2D(0.0, 0.0);
		Point2D l1 = new Point2D(0.0, 1.0);
		l0.drawTo(l1);
		Point2D t0 = new Point2D(0.0, 1.0);
		Point2D t1 = new Point2D(1.0, 1.0);
		t0.drawTo(t1);
		Point2D r0 = new Point2D(1.0, 0.0);
		Point2D r1 = new Point2D(1.0, 1.0);
		r0.drawTo(r1);

		this.draw(root);
	}

	private void draw(Node x){
		if (x == null)  return;

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.01);
		x.getP().draw();

		RectHV rec = x.getRec();
		Point2D point = x.getP();

		if (x.isVertical()){
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.setPenRadius();

			Point2D p1 = new Point2D(point.x(), rec.ymin());
			Point2D p2 = new Point2D(point.x(), rec.ymax());
			p1.drawTo(p2);

			draw(x.getLeftBottom());
			draw(x.getRightTop());
		} else {
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.setPenRadius();

			Point2D p1 = new Point2D(rec.xmin(), point.y());
			Point2D p2 = new Point2D(rec.xmax(), point.y());
			p1.drawTo(p2);

			draw(x.getLeftBottom());
			draw(x.getRightTop());
		}
	}

	public Iterable<Point2D> range(RectHV rect) {
		// all points that are inside the rectangle (or on the boundary)
		return this.range(rect, root);
	}

	private Iterable<Point2D> range(RectHV rect, Node x){
		SET<Point2D> set = new SET<>();

		if (x == null)  return null;

		if (rect.intersects(x.getRec())){
			if (rect.contains(x.getP()))  set.add(x.getP());
			else {
				this.range(rect, x.getLeftBottom());
				this.range(rect, x.getRightTop());
			}
		} else return null;
		return set;
	}

	public Point2D nearest(Point2D p) {
		// a nearest neighbor in the set to point p; null if the set is empty
		return this.nearest(root, p);
	}

	private Point2D nearest(Node x, Point2D p){
		if (x == null)  return null;
		Point2D nearestPoint = x.getP();
		double minDist = x.getP().distanceSquaredTo(p);

		if (x.getLeftBottom() != null) {
			double distToLeft = x.getLeftBottom().getRec().distanceSquaredTo(p);
			if (minDist < distToLeft){
				nearestPoint = nearest(x.getRightTop(), p);
			}
		}

		if (x.getRightTop() != null) {
			double distToRight = x.getRightTop().getRec().distanceSquaredTo(p);
			if (minDist < distToRight){
				nearestPoint = nearest(x.getLeftBottom(), p);
			}
		}

		return nearestPoint;
	}

	public static void main(String[] args) {
		// unit testing of the methods (optional)
	}
}
