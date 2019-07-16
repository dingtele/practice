package pegasus;

import java.util.HashSet;
import java.util.Set;

public class Percolation {

	private int[] location;
	private int n;
	private Set<Integer> openSet;
	private WeightedQuickUnionUF uf;
	private int virtualTop;
	private int virtualBottom;
	
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
    	if (n <= 0) 	throw new IllegalArgumentException("invalid input!");
    	this.n = n;
    	this.uf = new WeightedQuickUnionUF(n*n+2);
    	location = new int[n*n+2];
    	openSet = new HashSet<Integer>();
    	for(int i = 0; i < n*n+2; i++) {
    			location[i] = i;
    	}		
    	this.virtualTop = n*n+1;
    	this.virtualBottom = n*n+2;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {  	
    	validateIndices(row, col);
    	int i = xyTo1D(row, col);//convert to 1D index
    	openSet.add(Integer.valueOf(i));
    	if (row == 1) 	uf.union(virtualTop, i);
    	if (isOpen(row-1,col) && row >= 2) 			uf.union(i, i-n); 	// upper site is open
		else if (isOpen(row,col-1) && col >=2)		uf.union(i, i-1);// left site is open
		else if (isOpen(row,col+1) && col <= n-1)  	uf.union(i, i+1);// right site is open
		else if (isOpen(row+1,col) && row <= n-1)	uf.union(i, i+n); 	// down site is open	

    	System.out.println("precolation threshold is: " + openSet.size());//
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	validateIndices(row, col);
    	return openSet.contains(Integer.valueOf(xyTo1D(row, col)));
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    	validateIndices(row, col);   
    	int i = xyTo1D(row, col);
    	return (uf.connected(virtualTop, i));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	return openSet.size();
    }

    // does the system percolate?
    public boolean percolates() {
    	return (uf.connected(virtualTop, virtualBottom));
    }

    private int xyTo1D(int row, int col) {
    	return (row-1)*n + (col-1);
    }
    
    private void validateIndices(int row, int col) {
//    	if (!(row <= n && row > 0)) 	throw new IllegalArgumentException("invalid input!");
//    	if (!(col <= n && col > 0)) 	throw new IllegalArgumentException("invalid input!");
    }
    
    // test client (optional)
    public static void main(String[] args) {
    	int n = 2;
    	Percolation per = new Percolation(n);
    	per.open(1, 1);
    	per.open(1, 2);
    	System.out.println(per.uf.connected(0, 1));
    }
}
