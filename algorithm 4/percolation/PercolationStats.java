package pegasus;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

	private final int n;
	private final int trials;
	private Percolation perco;
	
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
    	if (n <= 0 || trials <= 0) 		throw new IllegalArgumentException("invalid input!");
    	this.n = n;
    	this.trials = trials;
    }

    // sample mean of percolation threshold
    public double mean() {
    	double[] res = new double[trials];
    	for (int i = 1; i <= trials; i++) {
    		perco = new Percolation(n);
    		while (!perco.percolates()) {
    			   int row = StdRandom.uniform(n);
    			   int col = StdRandom.uniform(n);
    			   perco.open(row, col);
    		}
    		res[i] = ((double) perco.numberOfOpenSites())/(n*n);
    	}
    	return StdStats.mean(res);
    	  
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
    	double[] res = new double[trials];
    	for (int i = 1; i <= trials; i++) {
    		perco = new Percolation(n);
    		while (!perco.percolates()) {
 			   int row = StdRandom.uniform(n);
 			   int col = StdRandom.uniform(n);
 			   perco.open(row, col);
    		}
    		res[i] = ((double) perco.numberOfOpenSites())/(n*n);
    	}
    	return StdStats.stddev(res);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
    	return this.mean() - this.stddev();
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
    	return this.mean() + this.stddev();
    }

   // test client (see below)
   public static void main(String[] args) {
	   while (!StdIn.isEmpty()) {
		   int n = StdIn.readInt();
		   int trials = StdIn.readInt();
		   PercolationStats stats = new PercolationStats(n, trials);
		   
		   System.out.println(stats.mean());
		   System.out.println(stats.stddev());
		   System.out.println(stats.confidenceHi());
		   System.out.println(stats.confidenceLo());  
	   }
   }
}
