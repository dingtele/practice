package pegasus.puzzle8;

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
		this.solution();
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
    	minQ.insert(this.initialNode);
    	twinMinQ.insert(new SearchNode(initialNode.board.twin(), 0, null));
    	SearchNode father = null;
    	SearchNode twinFather = null;
    	
    	System.out.println("before entering while loop!");
    	System.out.println("initial node is :  " +  "\n" + minQ.min().getBoard().toString());
    	
    	while (minQ.size() != 0 || twinMinQ.size() != 0) {
    		System.out.println("within while loop!");
    		
    		father = minQ.delMin();
			twinFather = twinMinQ.delMin();
			System.out.println(" deleted the father!" +  "\n" + father.getBoard().toString());
			
			Iterable<Board> children = father.getBoard().neighbors();
			Iterable<Board> twinChildren = twinFather.getBoard().neighbors();
			
			returnS.push(father.getBoard());
			
			SearchNode newNode;
			if (father.getBoard().isGoal()) {  
				System.out.println("got the goal node!");
				this.solvable = true;
				this.goalNode = father;
			}
			else {
			
				if (father.getPrevious() == null) {
					System.out.println("i am initial node!"
							+ "  move = " + father.getMove());
					Iterable<Board> initialChildren = this.initialNode.getBoard().neighbors();
					for (Board b : initialChildren) {
						newNode = new SearchNode(b, father.getMove()+1, father);
						minQ.insert(newNode);
					}
					System.out.println("successfully added first generation chirdren");
				} else {	
							for (Board b : children) {
								if (father.getMove() > 0 && b != father.getPrevious().getBoard()) {
									System.out.println("i am non-initial node!  "
															+ "move = " + father.getMove());
									newNode = new SearchNode(b, father.getMove()+1, father);
									minQ.insert(newNode);
								}
							}
						}
			}
			
			if (twinFather.getBoard().isGoal()) 
				this.solvable = false;
			else {
				for (Board b : twinChildren) {
					if (twinFather.getMove() > 0 && b != twinFather.getPrevious().getBoard()) {
						newNode = new SearchNode(b, twinFather.getMove()+1, twinFather);
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
			this.board = board;
			this.priority = board.manhattan() + move;
			this.move = move;
			this.previous = previous;
		}
		
    	@Override
		public int compareTo(SearchNode o) { 
			return this.priority - o.priority;		// TODO 	
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