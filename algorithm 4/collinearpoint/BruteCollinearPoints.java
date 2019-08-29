package collinearpoints;

public class BruteCollinearPoints {
	
	private int count;
	private Point[] points;
	
    public BruteCollinearPoints(Point[] points) {
	   // finds all line segments containing 4 points
	    this.points = points;
    }
    
    public int numberOfSegments() {
	   // the number of line segments
    	count = 0;
    	double slope = points[0].slopeTo(points[1]);
		if (points[0].slopeTo(points[2]) ==slope && points[0].slopeTo(points[3]) == slope)
			count++;
		return count;  	
    }
    
    public LineSegment[] segments() {
	   // the line segments

    }
}