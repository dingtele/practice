package pegasus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Percolation {

	private Integer[][] location;
	private int N;
	private ArrayList<Integer> openList;
	private Set<Integer> topVal;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
    	this.N = n;
    	Set<Integer> topVal = new HashSet<Integer>();
    	for(int j = 0; j < N; j++)
    		topVal.add(location[0][j]);
    	for(int i = 0; i < n; i++)
    		for(int j = 0; i < n; j++)
    			location[i][j] = (i-1)*n + (j-1);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    	if ((row <= 0 || row > N) || col <= 0 || col > N) 	throw new IllegalArgumentException("invalid input!");
    	if (!isOpen(row,col)) {	
    		if(isOpen(row-1,col)) 			location[row][col] = location[row-1][col];
    		else if(isOpen(row,col-1)) 		location[row][col] = location[row][col-1];
    		else if(isOpen(row,col+1))  	location[row][col+1] = location[row][col];
    		else if(isOpen(row+1,col))		location[row+1][col] = location[row][col];
    		
    		openList.add((row-1)*N + (col-1));
    	}
    	
    	System.out.println("precolation threshold is" + openList.size() / N*N);
	
    	return;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	if ((row <= 0 || row > N) || col <= 0 || col > N) 	throw new IllegalArgumentException("invalid input!");
    	return openList.contains((row-1)*N + (col-1));
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    	if ((row <= 0 || row > N) || col <= 0 || col > N) 	throw new IllegalArgumentException("invalid input!");
    	return topVal.contains(location[row][col]);	
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	return openList.size();
    }

    // does the system percolate?
    public boolean percolates() {
    	Set<Integer> bottVal = new HashSet<Integer>();
    	Set<Integer> set = new HashSet<Integer>();
    	for(int j = 0; j < N; j++)
    		bottVal.add(location[N][j]);
    	set.containsAll(bottVal);
    	set.containsAll(topVal);
    	return set.size() < (bottVal.size() +  topVal.size()); 	
    }

    // test client (optional)
    public static void main(String[] args) {
    	StdIn.read
    }
}
