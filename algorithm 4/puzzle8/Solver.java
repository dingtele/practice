package eightpuzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
	private SearchNode goalNode;
	private SearchNode initialNode;
	private boolean solvable;
	
    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
    	if (initial == null) 	throw new IllegalArgumentException ("input is null!!");
    	this.initialNode = new SearchNode(initial, 0, null);
    	MinPQ<SearchNode> minQ = new MinPQ<>();
    	MinPQ<SearchNode> twinMinQ = new MinPQ<>(); 
    	
    	minQ.insert(this.initialNode);
    	twinMinQ.insert(new SearchNode(initialNode.getBoard().twin(), 0, null));
    	SearchNode father = null;
    	SearchNode twinFather = null;
    	
    	System.out.println("before entering while loop!");
    	System.out.println("initial node is :  " +  "\n" + minQ.min().getBoard().toString());
    	
    	while (this.goalNode == null) {
//    		System.out.println("within while loop!");
    		
    		father = minQ.delMin();
			twinFather = twinMinQ.delMin();
			
//			System.out.println(" deleted the father!" +  "\n" + father.getBoard().toString());
//			System.out.println(" deleted the <twin> father!" +  "\n" + twinFather.getBoard().toString());
			
			Iterable<Board> children = father.getBoard().neighbors();
			Iterable<Board> twinChildren = twinFather.getBoard().neighbors();
			
			SearchNode newNode;
			if (father.getBoard().isGoal()) {  
				System.out.println("got the goal node!");
				this.solvable = true;
				this.goalNode = father;
				break;
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
					System.out.println("successfully added first generation chirdren"
							+ "\n"+ minQ.size());
				} else {	
							for (Board b : children) {
								if (b != father.getPrevious().getBoard()) {
									
									newNode = new SearchNode(b, father.getMove()+1, father);
									minQ.insert(newNode);
//									System.out.println("inserted children:  "
//											+ "\n " + newNode.getBoard().toString());
								}
							}
						}
			}
			
			if (twinFather.getBoard().isGoal()) {
				System.out.println("got the twin goal node!");
				this.solvable = false;
				break;
			}
			else {
			
				if (twinFather.getPrevious() == null) {
					System.out.println("i am <twin> initial node!"
							+ "  move = " + twinFather.getMove());
					Iterable<Board> initialTwinChildren = twinFather.getBoard().neighbors();
					for (Board b : initialTwinChildren) {
						newNode = new SearchNode(b, twinFather.getMove()+1, twinFather);
						twinMinQ.insert(newNode);
					}
					System.out.println("successfully added first generation <twin> chirdren, size:  " + twinMinQ.size());
				} else {	
							for (Board b : twinChildren) {
								if (b != twinFather.getPrevious().getBoard()) {
//									System.out.println("i am non-initial <twin> node!  "
//															+ "move = " + twinFather.getMove());
									newNode = new SearchNode(b, twinFather.getMove()+1, twinFather);
									twinMinQ.insert(newNode);
								}
							}
						}
			}  
			 
    	} // while loop
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
    	Stack<Board> returnS = new Stack<>();
    	SearchNode getPrevious = this.goalNode;
    	
    	while (getPrevious != null) {
    		returnS.push(getPrevious.getBoard());
    		getPrevious = getPrevious.getPrevious();
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
//            for (Board board : solver.solution())
//                StdOut.println(board);
        }
    }
}