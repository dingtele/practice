package collinearpoints;

public class BruteCollinearPoints {
	
	private int N = 0;
	private Point[] points;
	private LineSegment[] lgs = new LineSegment[N];
	
    public BruteCollinearPoints(Point[] points) {
	    // finds all line segments containing 4 points
	    this.points = points;
    }
    
    public int numberOfSegments() {
	    // the number of line segments	
		return N;  	
    }
    
    public LineSegment[] segments() {
    	// the line segments
    	double slope = points[0].slopeTo(points[1]);
    	Point max = points[0];
    	Point min = points[0];
    	for (int i = 0; i < points.length; i += 4) {
	    	if (points[i].slopeTo(points[i+2]) ==slope && points[0].slopeTo(points[i+3]) == slope) {
	    		for (int j = 1; j < 4; j++) {
					if (points[j].compareTo(max) == 1)  		max = points[j];
					if (points[j].compareTo(min) == -1) 		min = points[j]; 			
	    		}
	    		lgs[N++] = new LineSegment(max, min);
	    	}
	    	else continue;
    	}
		return lgs;
    }
}
