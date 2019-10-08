package pegasus.kdtrees;

public class RedBlackBST <Key extends Comparable<Key>, Value>{
	
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = true;

	public RedBlackBST() {
		
	}
	
	public void put(Key key, Value val) {
		 if (key == null) throw new IllegalArgumentException("first argument to put() is null");
	        if (val == null) {
	            this.delete(key);
	            return;
	        }
	
	        root = put(root, key, val);
	        root.color = BLACK;
	}
	
	private Node put(Node h, Key key, Value val) {
		// search and insert node into right place
		if (h == null) 	return new Node(key, val, RED, 1);
		int cmp = key.compareTo(h.key);
		if		(cmp > 0) 	h.right = put(h.right, key, val);
		else if (cmp < 0) 	h.left = put(h.left, key, val);
		else    		 	h.val = val;
		
		// change color of the nodes related to the operation
		if 		(isRed(h.right) && isRed(h.left))		h = this.fipperColor(h);
		else if (isRed(h.left) && isRed(h.left.left))	h = this.rotateRight(h.left);
		else if (isRed(h.right) && !isRed(h.left))		h = this.rotateLeft(h.right);
		
		// update color of the return node
		h.size = size(h.left) + size(h.right) + 1;
		
		return h;
	}
	
	public void delete(Key key) {
		
	}
	
	public Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		
		x.color = h.color;
		h.color = RED;
		x.size = h.size;
		h.size = 1 + size(h.left) + size(h.right);
		
		return x;
	}
	
	public Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
			
		h.color = x.color;
		x.size = h.size;
		h.size = 1 + size(h.left) + size(h.right);
		
		return x;
	}
	
	public Node fipperColor(Node x) {
		x.left.color = false;
		x.right.color = false;
		x.color = true;
		return x;
	}
	
	public int size(Node x) {
		return x.size;
	}
	
	private class Node{
		private Key key;
		private Value val;
		private Node left;
		private Node right;
		private boolean color;
		private int size;
		
		Node(Key key, Value val, boolean color, int size){
			this.color = color;
			this.key = key;
			this.val = val;
			this.size = size;
		}
	}
	
	private boolean isRed(Node n) {
		if (n == null) 	return false;
		return n.color == RED;
	}
}
