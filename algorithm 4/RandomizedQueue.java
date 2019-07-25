package queues;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private int N;
	private int first;
	private int last; 
	private Item[] que;
	
    // construct an empty randomized queue
    public RandomizedQueue() {
    	que = (Item[]) new Object[0];
    	N = que.length;
    	first = 0;
    	last = N-1;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
    	return (N == 0);
    }

    // return the number of items on the randomized queue
    public int size() {
    	return N;
    }

    // add the item
    public void enqueue(Item item) {
		if (item == null) 	throw new IllegalArgumentException("wrong[addlast]");

		
    }

    // remove and return a random item
    public Item dequeue() {
    	Item item = StdRandom.random()
    	
    }

    // return a random item (but do not remove it)
    public Item sample() {
    	
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator()

    // unit testing (required)
    public static void main(String[] args)

}