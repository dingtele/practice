package bouncingball;

import edu.princeton.cs.algs4.StdDraw;

public class Partical {
	private double rx, ry; // position
	private double vx, vy; // velocity
	private final double radius; // 
	private int mass; // TODO
	private int count;
//	private double[] 
//TODO how to set a proper dt?	
	public Partical(double rs, double ry, double radius) {
		this.rx = rs;
		this.ry = ry;
		this.radius = radius;
	}
	
	public void move(double dt) {
		if ((rx + vx*dt < radius) || (rx + vx*dt > 1 - radius))	{ 	vx = -vx; 	}
		if ((ry + vy*dt < radius) || (ry + vy*dt > 1 - radius)) { 	vy = -vy; 	}
		rx = rx + vx*dt;
		ry = ry + vy*dt;
	}
	
	public void draw() {
		StdDraw.filledCircle(rx, ry, radius);
	}
	
	public double timeToHitPartical(Partical that) {
		return 0;
	}
	
	public double timeToHitVerticalWall() {
		return 0;
	}
	
	public double timeToHitHorrizontalWall() {
		return 0;
	}
	
	public void bounceOff(Partical that) {
		
	}
	
	public void bounceOffVerticalWall() {
		
	}
	
	public void bounceOffHorizontalWall() {
		
	}
}
