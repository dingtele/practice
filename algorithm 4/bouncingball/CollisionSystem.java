package bouncingball;

public class CollisionSystem {
	
	private int N;
	private Partical[] par;
	private double t = 0.0;
	private MinPQ<Event> pq;
	
	public CollisionSystem(Partical[] par) {
		this.N = par.length;
		this.par = new Partical[N];
		for (int i = 0; i < N; i++) {
			this.par[i] = par[i];
		}
	}
	
	private void predict(Partical a) {
		if (a == null) return;	
		for (int i = 0; i < N; i++)
		{
			double dt = a.timeToHitPartical(par[i]);
			pq.insert(new Event(t+dt, a, par[i]));
		}
		pq.insert(new Event(t+a.timeToHitHorrizontalWall(), a, null));
		pq.insert(new Event(t+a.timeToHitVerticalWall(), null, a));
		
	}
	
	private void redraw() { }

	public void simulation() {
		// initialize PQ with collision event and redraw event
		pq = new MinPQ<Event>(N);
		for (int i = 0; i < N; i++) {
			predict(par[i]);
		}
		pq.insert(new Event(0, null,null));
		
		// delete event from pq and update position and time		
		while (!pq.isEmpty()) {
			Event event = pq.delMin();
			if (!event.isValid()) 	continue;
			Partical a = event.a;
			Partical b = event.b;
			
			for (int i = 0; i <N; i++) {
				par[i].move(event.time - this.t);
			}
			this.t = event.time;
			
			// process event
			if (a != null && b != null) 		a.bounceOff(b);
			else if (a != null && b == null) 	a.bounceOffVerticalWall();
			else if (a == null && b != null) 	b.bounceOffHorizontalWall();
			else if (a ==null && b ==null) 	redraw();
			
			predict(a);
			predict(b);
		}

	}
	
	private class Event implements Comparable<Event>{

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
		 
		
		public boolean isValid() {
			return false;		
		}
	}
}
