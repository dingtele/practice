package pegasus.bouncingball;

public class CollisionSystem {
	
	private int N;
	private Partical[] par;
	private double t = 0.0;
	private MinPQ<Event> pq;
	
	public CollisionSystem(Partical[] par) {
		this.N = par.length;
		this.par = new Partical[N];
//		this.pq = new MinPQ<Event>(N);
		for (int i = 0; i < N; i++) {
			this.par[i] = par[i];
		}
	}
	
	public void predict(Partical a) {
		if (a == null) return;	
		for (int i = 0; i < N; i++)
		{
			double dt = a.timeToHitPartical(par[i]);
			pq.insert(new Event(t+dt, a, par[i]));
		}
		pq.insert(new Event(t+a.timeToHitHorrizontalWall(), a, null));
		pq.insert(new Event(t+a.timeToHitVerticalWall(), null, a));
		
	}

	public void simulation() {
		for (int i = 0; i < N; i++) {
			predict(par[i]);
		}
		
	}
}
