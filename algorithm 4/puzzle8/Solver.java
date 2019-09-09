package eightpuzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
	private SearchNode goalNode;
	private SearchNode initialNode;
	private MinPQ<SearchNode> minQ;
	private Stack<Board> returnS;
	private MinPQ<SearchNode> twinMinQ;
	private boolean solvable;
	
    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
    	if (initial == null) 	throw new IllegalArgumentException ("input is null!!");
    	this.initialNode = new SearchNode(initial, 0, null);
    	minQ = new MinPQ<>();
    	twinMinQ = new MinPQ<>(); 
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
		return this.solvable;   	
    }

    // min number of moves to solve initial board
    public int moves() {
    	if (!this.isSolvable())
    		return -1;
    	else return this.goalNode.getMove();
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution(){
    	this.returnS = new Stack<>();
    	minQ.insert(initialNode);
    	twinMinQ.insert(new SearchNode(initialNode.board.twin(), 0, null));
    	SearchNode currentNode = null;
    	SearchNode twinCurrentNode = null;
    	while (minQ.size() != 0 || twinMinQ.size() != 0) {
			currentNode = minQ.delMin();
			twinCurrentNode = twinMinQ.delMin();
			
			Iterable<Board> neighbors = currentNode.getBoard().neighbors();
			Iterable<Board> twinNeighbors = twinCurrentNode.getBoard().neighbors();
			
			returnS.push(currentNode.getBoard());
			
			SearchNode newNode;
			if (currentNode.getBoard().isGoal()) {  	
				this.solvable = true;
				this.goalNode = currentNode;
			}
			else
			{
				for (Board b : neighbors) {
					if (b != currentNode.getPrevious().getBoard()) {
						newNode = new SearchNode(b, currentNode.getMove()+1, currentNode);
						minQ.insert(newNode);
					}
				}
			} 
			
			if (twinCurrentNode.getBoard().isGoal()) 
				this.solvable = false;
			else {
				for (Board b : twinNeighbors) {
					if (b != twinCurrentNode.getPrevious().getBoard()) {
						newNode = new SearchNode(b, twinCurrentNode.getMove()+1, twinCurrentNode);
						twinMinQ.insert(newNode);
					}
				}
			}  
    	} 
		return returnS;  	  			
    }
    
    private static class SearchNode implements Comparable<SearchNode>{
    	private SearchNode previous;
		private Board board;
		private int priority;
		private int move;
		
		public SearchNode(Board board, int move, SearchNode previous) {
			this.priority = this.board.manhattan() + move;
			this.move = move;
			this.previous = previous;
		}
		
    	@Override
		public int compareTo(SearchNode o) { 
			return this.priority - o.priority;			
		}

		public SearchNode getPrevious() {
			return previous;
		}

		public Board getBoard() {
			return board;
		}

		public int getMove() {
			return move;
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