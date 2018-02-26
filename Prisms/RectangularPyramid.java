
public class RectangularPyramid extends Pyramid {
	private double length;
	private double width;
	
	public RectangularPyramid (double l, double w, double h) {
		super(h);
		length = l;
		width = w;
		this.setup();
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getLength() {
		return length;
	}
	
	private double intermediate(double a, double b) {
		double inside = 0;
		inside += Math.pow((b / 2), 2);
		inside += Math.pow(getHeight(), 2);
		inside = a * Math.sqrt(inside);
		return inside;
	}
	
	public double calcAreaOfBase() {
		return width * length;
	}
	
	public double calcSA() {
		double area = 0;
		area += calcAreaOfBase();
		area += intermediate(width, length);
		area += intermediate(length, width);
		return area;
	}
	
}
