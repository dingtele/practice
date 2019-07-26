package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private int n;
	private Item[] que; // number of elements in the stack
	
    // construct an empty randomized queue
    public RandomizedQueue() {
    	que = (Item[]) new Object[2];
    	n = que.length;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
    	return (n == 0);
    }

    // return the number of items on the randomized queue
    public int size() {
    	return n;
    }

    private Item[] resize(int capacity) {
    	assert capacity >= 0;
    	Item[] temp = (Item[]) new Object[capacity];
    	for (int i = 0; i < n; i++) {
    		temp[i] = que[i];
    	}
    	que = temp;
    	return que;
    }
    
    // add the item
    public void enqueue(Item item) {
		if (item == null) 	throw new IllegalArgumentException("wrong[addlast]");
		if (n == que.length) resize(2*que.length);	
		que[n] = item;	
		n++;
    }

    // remove and return a random item
    public Item dequeue() {
    	if (isEmpty()) 		throw new NoSuchElementException("NoSuchElementException [deque]");
    	int index = StdRandom.uniform(n);
    	Item item = que[index];
    	for (int i = index + 1; i < n; i++) {
    		que[i-1] = que[i];
    	}
    	que[n-1] = null;
    	n--;
    	return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
    	if (isEmpty()) 		throw new NoSuchElementException("NoSuchElementException [sample]");
    	int index = StdRandom.uniform(n);
    	Item item = que[index];
    	return item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
    	return new ArrayIterator<Item>();
    }
    
    private class ArrayIterator<Item> implements Iterator<Item>{

    	private int current = 0;
    	
    	public boolean hasNext() {
    		return (current < n-1);
    	}
    	
    	public Item next() {
    		if (!hasNext()) 	throw new NoSuchElementException("NoSuchElement[current]"); 
    		Item item = (Item) que[current % que.length];
    		current++;
    		return item;
    	}    	
    }

    // unit testing (required)
    public static void main(String[] args) {
    	RandomizedQueue<String> rq = new RandomizedQueue<String>();
    	while (!StdIn.isEmpty()) {
    		String item = StdIn.readString();
    		if (!item.equals("-"))
    			rq.enqueue(item);
    		else if (!rq.isEmpty()) 	
    			StdOut.println(rq.dequeue());
    	}
    	String sample = rq.sample();
    	while (rq.iterator().hasNext()) {
    		if (sample == rq.iterator().next());
    	    StdOut.println(sample);	       	
    	}	
    }  	
}
