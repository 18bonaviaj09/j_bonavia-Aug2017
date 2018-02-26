
class Cone extends Pyramid {
	private double radius;
	
	public Cone(double r, double h) {
		super(h);
		radius = r;
		this.setup();
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double calcAreaOfBase() {
		return Math.PI * (radius * radius);
	}
	
	public double calcSA() {
		double area = 0;
		area += Math.pow(radius, 2);
		area += Math.pow(getHeight(), 2);
		area = Math.sqrt(area);
		area += radius;
		area *= (Math.PI * radius);
		return area;
	}
}
