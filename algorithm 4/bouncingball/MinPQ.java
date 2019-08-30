package bouncingball;

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
	public void insert(Key key) {
		pq[N++] = key;
		swim(N);
	}
	
	public Key delMin() {
		Key min = pq[0];
		exch(0, N-1);
		sink(0);
		pq[N-1] = null;
		return min;
	}
	
	private void swim(int k) {
		while (k >= 0 && greater(k/2, k)) {
			exch(k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k) {
		while (2*k <= N) {
			int j = 2*k;
			if (j < N-1 && greater(j, j+1))  j++;
			if (!greater(k, j))	break;
			exch(k, j);
			k = j;
		}
	}
	
	private boolean greater(int i, int j) {
		return pq[i].compareTo(pq[j]) > 0;
	}
	
	private void exch(int i, int j) {
		Key temp = pq[i]; pq[i] = pq[j]; pq[j] = temp;
	}
}
