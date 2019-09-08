package pegasus.puzzle8;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
	private SearchNode searchNode;
	private MinPQ<SearchNode> minQ;
	private Queue<Board> returnQ;
    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
    	if (initial == null) 	throw new IllegalArgumentException ("input is null!!");
    	this.searchNode = new SearchNode(initial);
    	minQ = new MinPQ<>();
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
		return false;
    	
    }

    // min number of moves to solve initial board
    public int moves() throws Exception {
		if (returnQ == null)  throw new Exception("");
		return returnQ.size();	
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution(){
    	this.returnQ = new Queue<>();
    	minQ.insert(searchNode);
    	while (minQ.size() != 0) {
			SearchNode deletedNode = minQ.delMin();
			returnQ.enqueue(deletedNode.board);
			SearchNode newNode;
			while (deletedNode.board.neighbors() != null) {
				for (Board b : deletedNode.board.neighbors()) {
					newNode = new SearchNode(b);
					newNode.move++;
					newNode.previous = deletedNode;  // TODO how to use
					minQ.insert(newNode);
				}
			}
    	}
		return returnQ;  	  			
    }
    
    private static class SearchNode implements Comparable<SearchNode>{
    	private SearchNode previous;
		private Board board;
		private int priority;
		private int move;
		
		public SearchNode(Board board) {
			this.priority = this.board.manhattan() + move;
		}
		
    	@Override
		public int compareTo(SearchNode o) { 
			return this.priority - o.priority;			
		}
    	
    }

    // test client (see below) 
    public static void main(String[] args) throws Exception {
    
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