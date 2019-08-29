package pegasus;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private final int n;
	private final boolean[] isOpen;
	private final WeightedQuickUnionUF uf;
	private final int virtualTop;
	private final int virtualBottom;
	
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
    	if (n <= 0) 	throw new IllegalArgumentException("invalid input!");
    	this.n = n;
    	this.uf = new WeightedQuickUnionUF(n*n+2);
    	isOpen = new boolean[n*n];		
    	this.virtualTop = n*n;
    	this.virtualBottom = n*n+1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {  	
    	validate(row, col);
    	int i = xyTo1D(row, col); // convert to 1D index
    	
    	if (!isOpen(row, col)) { 					
    		isOpen[i] = true;
	    	if (row == 1) 							uf.union(virtualTop, i); // connect with virtualTop
	    	if (isOpen(row-1, col) && row >= 2) 		uf.union(i, i-n); // upper site is open
			if (isOpen(row, col-1) && col >= 2)		uf.union(i, i-1); // left site is open
			if (isOpen(row, col+1) && col <= n-1)  	uf.union(i, i+1); // right site is open
			if (isOpen(row+1, col) && row <= n-1)	uf.union(i, i+n); // down site is open	
    	}
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	validate(row, col);
    	return isOpen[xyTo1D(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    	validate(row, col);   
    	return (uf.connected(virtualTop, xyTo1D(row, col)));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	int count = 0;
    	for (int i = 0; i < isOpen.length; i++) {
    		if (isOpen[i] == true) 	count++;
    	}
    	return count;
    }

    // does the system percolate?
    public boolean percolates() {
    	return (uf.connected(virtualTop, virtualBottom));
    }

    private int xyTo1D(int row, int col) {
    	return (row-1)*n + (col-1);
    }
    
    private void validate(int row, int col) {
    	if (row <= 0 || row > n || col <= 0 || col > n) 	{throw new IllegalArgumentException("invalid input!");}
    }
    
    // test client (optional)
    public static void main(String[] args) {
    	int n = 2;
    	Percolation per = new Percolation(n);
    	per.open(1, 1);
    	per.open(1, 2);
    	
    	StdOut.print(per.uf.connected(0, 1));
//    	StdOut.print(("precolation threshold is: " + ((double) numberOfOpenSites())/(n*n)));
    }
}
