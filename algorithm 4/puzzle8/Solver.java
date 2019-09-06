package eightpuzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
	private Board origin;
	private MinPQ<Board> minQ = new MinPQ<>();
	
    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
    	this.origin = initial;
    	if (initial == null) 	throw new IllegalArgumentException ("input is null!!");
    	minQ.insert(initial);
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
    	
    }

    // min number of moves to solve initial board
    public int moves() {
    	
    			
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution(){
    	int priority = (int) (Math.pow(origin.dimension(), 2) * 2);
    	Board father = minQ.delMin();
    	for(Board b : father.neighbors()) {
    		minQ.insert(b);
    		
    	}
    	
    	priority = Math.min(b.manhattan() + this.moves(), priority);
    	
    	
    	
    	
    			
		// comput the priority of each neighbor boards by using mahatten
		// find the min priority 
    			
    }

    // test client (see below) 
    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}