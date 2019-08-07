//package collinearpoints;

import java.util.Arrays;

public class FastCollinearPoints {
	   
	private int N = 0;
	private Point[] points;
	private LineSegment[] lgs = new LineSegment[N];
	
	public FastCollinearPoints(Point[] points) {
		   // finds all line segments containing 4 or more points
		   if (points == null) 	throw new IllegalArgumentException("!!!");
		    for (int i = 0; i < points.length; i++) {
		    	if (points[i] == null) 	throw new IllegalArgumentException("!!!");
		    	for (int j = i+1; j < points.length; j++) {
		    		if (points[i].compareTo(points[j]) == 0) 	throw new IllegalArgumentException("!!!");
		    	}
		    }
		    this.points = points;
	   }
	   public int numberOfSegments() {
		   // the number of line segments
		   return N;
	   }
	   public LineSegment[] segments() {
		   // the line segments
		   for (int i = 0; i < points.length; i++) {
			   Arrays.sort(points, points[i].slopeOrder());
			   int count = 0;
			   for (int j = 0; j < points.length; j++) {
				   double slope = points[j].slopeTo(points[j+1]);
				   if (slope == points[j].slopeTo(points[j+2])) {
					   count++;
				   }    
				   else if (count >= 2) {
					   lgs[N++] = new LineSegment(points[j-count], points[j+1]); count = 0;
				   }
				   else continue;
			   }
		   }
		   return lgs;
	   }   
	}