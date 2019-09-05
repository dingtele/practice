package eightpuzzle;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Board {
	private int n;
	private int[][] tiles;
	private Map<Integer, int[]> map;
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
    	this.n = (int) Math.sqrt(tiles.length);
    	this.tiles = tiles;
    	this.map = new HashMap<>();
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			map.put(tiles[i][j], new int[] {i, j});
    		}
    	}
    }
                                           
    // string representation of this board
    public String toString() {
    	StringBuilder s = new StringBuilder();
    	s.append(n +"\n");
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			s.append(String.format("%2d", tiles[i][j]));
    		}
    		s.append("\n");
    	}
    	return s.toString();
    }

    // board dimension n
    public int dimension() {
    	return n;
    }

    // number of tiles out of place
    public int hamming() {
    	int count = 0;
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			if (tiles[i][j] != (i*n+j+1) && tiles[i][j] != 0)
    				count++;
    		}
    	}
    	return count;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
    	int absi = 0;
    	int absj = 0;
    	int sum = 0;
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			if (tiles[i][j] == (i*n+j+1)) return 0;
    			else if (tiles[i][j] == 0) 	continue; 
    			else { 
	    			absi = Math.abs(map.get(tiles[i][j])[0] - i); 
	    			absj = Math.abs(map.get(tiles[i][j])[1] - j);
	    			return sum += absj+ absj;
    			}
    		}
    	}
    	return sum;
    }

    // is this board the goal board?
    public boolean isGoal() {
    	return (hamming() == 0);
    }

    // does this board equal y?
    public boolean equals(Object y) {
    	if (y == this) return true;
    	if (y == null) 	return false;
    	if (y.getClass() != this.getClass()) 	return false;
    	Board that = (Board) y;
    	
    	if(that.dimension() == this.dimension()) {
    		for (int i = 0; i < n; i++) {
        		for (int j = 0; j < n; j++) {
        			if (that.tiles[i][j] != this.tiles[i][j]) 	return false;
        		}
        	}
    		return true;
    	}
    }

    // all neighboring boards
    public Iterable<Board> neighbors(){
    	int i = map.get(0)[0];
    	int j = map.get(0)[1];
    	Stack<Board> s = new Stack<>();
    	if (i == 0 )
    		switch(j) {
    			case 0: 
    				this.tiles[i][j] = tiles[i][j+1];
    				s.add(this);
    			case n-1:
    				this.tiles[i][j] = tiles[][]
    		}
    			
    		
    	
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
    	
    }

    // unit testing (not graded)
    public static void main(String[] args)

}
