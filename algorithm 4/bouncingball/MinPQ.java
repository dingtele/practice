package pegasus.bouncingball;

public class MinPQ<Key extends Comparable<Key>> {

	private Key[] pq;
	private int N;
	
	public MinPQ(int capacity) {
		this.N = capacity;
		pq = (Key[]) new Comparable[N];
	}
	
	public boolean isEmpty() {
		return (N == 0);
	}
	public void insert(Key k) {
		
	}
	
	public Key delMin() {
		return null;
	}
	
	public void sort() {
		
	}
}
