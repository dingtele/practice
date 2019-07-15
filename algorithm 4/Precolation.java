package pegasus;

import java.util.HashSet;
import java.util.Set;

public class Percolation {

	private int[][] location;
	private int N;
	private Set<Integer> openSet;
	private WeightedQuickUnionUF uf;
	
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
    	this.N = n;
    	this.uf = new WeightedQuickUnionUF(N*N);
    	location = new int[N][N];
    	openSet = new HashSet<Integer>();
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			location[i][j] = i*N + j;
    		}
    	}		
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {  	
//TODO    	if ((row <= 0 || row > N) || (col <= 0 || col > N)) 	throw new IllegalArgumentException("invalid input!");
    	
		int upperSite = (row-2)*N + (col-1);
		int leftSite = (row-1)*N + (col-2);
		int rightSite = (row-1)*N + col;
		int downSite = row*N + (col-1);
		int site = (row-1)*N + (col-1);
		
    	if (!isOpen(row,col)) {	  		
        	if (row == 1) {
        		for (int j = 0; j < N; j++) {
        			location[row-1][j] = 0;// top row unified value
        		}
        	}else if (row == N) {
        		for (int j = 0; j < N; j++) {
        			location[row-1][j] = N*N-1;//TODO
        		}
        	}
		
    		if(isOpen(row-1,col) && row >= 2) 			uf.union(site, upperSite);// upper site is open
    		else if(isOpen(row,col-1) && col >=2)		uf.union(leftSite, site);// left site is open
    		else if(isOpen(row,col+1) && col <= N-1)  	uf.union(rightSite, site);// right site is open
    		else if(isOpen(row+1,col) && row <= N-1)	uf.union(downSite, site);// down site is open
    		
    		openSet.add(Integer.valueOf((row-1)*N + (col-1)));
    	}    
    	System.out.println("precolation threshold is: " + openSet.size());
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
//    	if ((row <= 0 || row > N) || (col <= 0 || col > N)) 	throw new IllegalArgumentException("invalid input!");
    	return openSet.contains(Integer.valueOf(row-1)*N + (col-1));
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
//    	if ((row <= 0 || row > N) || (col <= 0 || col > N)) 	throw new IllegalArgumentException("invalid input!");
    	if (row == 1) {	
    			location[row-1][col-1] = 0;
    			return true;
    		}
    	else if(!isOpen(row-1, col-1)) 	return false;
    	else if (uf.connected((row-2)*N + (col-1), 0)) 	
    			location[row-1][col-1] = 0;
    			return true;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	return openSet.size();
    }

    // does the system percolate?
    public boolean percolates() {
    	return location[N-1][N-1] == 0;
    }

    // test client (optional)
//    public static void main(String[] args) {

//    }
}
