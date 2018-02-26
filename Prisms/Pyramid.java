
public abstract class Pyramid extends ThreeDShape {
	private double height;
	
	public Pyramid(double h) {
		height = h;
	}
	
	public double getHeight() {
		return height;
	}
	
	public abstract double calcAreaOfBase();
	
	public double calcVolume() {
		return (calcAreaOfBase() * height) / 3;
	}
	
	public abstract double calcSA();
			
}
