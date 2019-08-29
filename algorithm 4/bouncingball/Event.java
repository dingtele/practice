package pegasus.bouncingball;

public class Event implements Comparable<Event>{

	private double time;
	private Partical a, b;
	private MinPQ[] pq;
	
	public Event(double time, Partical a, Partical b) {
		this.time = time;
		this.a = a;
		this.b = b;		
		
	}
	
	@Override
	public int compareTo(Event that) {		
		return (int) (this.time - that.time);
	}
	 
}
