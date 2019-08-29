package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int count;
	
	private class Node {
		Item item;
		Node prev;
		Node next;
	}
    // construct an empty deque
    public Deque() {
    	first = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
    	return (first == null);
    }

    // return the number of items on the deque
    public int size() {
    	return count;
    }

    // add the item to the front
    public void addFirst(Item item) {
    	if (item == null) 	throw new IllegalArgumentException("wrong[addfirst]");
    	
    	Node oldFirst = first;
    	first = new Node();
    	first.item = item;
    	
    	if(isEmpty()) 	first = last;
    	else 			first.next = oldFirst;
    	count++;
    }

    // add the item to the back
    public void addLast(Item item) {
    	if (item == null) 	throw new IllegalArgumentException("wrong[addlast]");
    	
    	Node oldLast = last;
    	last = new Node();
    	last.item = item;
    	last.prev = oldLast;

    	
    	if(isEmpty()) 	first = last;
    	else 			oldLast.next = last;
    					last.next = null;
    	count++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
    	if (isEmpty()) 	throw new NoSuchElementException("NoSuchElement[removeFirst]");
    	
    	Item item = first.item;
    	first = first.next;
    	first.prev = null;
    	count--;
    	return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
    	if (isEmpty()) 	throw new NoSuchElementException("NoSuchElement[removelast]");
    	
    	Item item = last.item;
    	last = last.prev;
    	last.next = null;		
    	count--;
    	return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
    	return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item>{
    	
    	private Node current = first;
    	
    	public boolean hasNext(){
    		return (current != null);
    	}
    	
    	public void remove() { throw new UnsupportedOperationException("UnsupportedOperation");}
    	
    	public Item next(){
    		if (!hasNext()) 	throw new NoSuchElementException("NoSuchElement[current]"); 
    		Item item = current.item;
    		current = current.next;
    		return item;
    	}
    }

    // unit testing (required)
    public static void main(String[] args) {
    	Deque<String> deque = new Deque<String>();
    	while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
            	deque.addFirst(item);
            else if (!deque.isEmpty())
                StdOut.print(deque.removeFirst() + " ");
        }
        StdOut.println("(" + deque.size() + " left on stack)");
    		
    }

}