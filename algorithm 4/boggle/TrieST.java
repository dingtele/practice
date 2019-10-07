package boggle;

public class TrieST<Value> {
	
	private final int R = 256;
	private Node root;
	
	private class Node<Value> {
		private Object val;
		private Node[] next = new Node[R];
	}
	
	public Value get(String key) {
		Node x = this.get(root, key, 0);
		if (x == null) 	return null;
		return (Value) x.val;
	}
	
	private Node get(Node x, String key, int d) {
		if (x == null) 	return null;
		if (key.length() == d) 	return x;
		char c = key.charAt(d);
		return this.get(x.next[c], key, d+1);
	}
	
	public void put(String key, Value val) {
		this.put(root, key, val, 0);
		
	}
	
	private Node put(Node x, String key, Value val, int d) {
		if (x == null) 	return new Node();
		if (key.length() == d) { 	x.val = val; return x; 	}
		char c = key.charAt(d);
		x.next[c] = this.put(x.next[c], key, val, d+1);
		return x;
	}
}
