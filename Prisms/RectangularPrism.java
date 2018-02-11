/* Write this concrete (non-abstract) class called RectangularPrism.  
 * It has 2 private fields (length and width).
 * It inherits its height from its superclass, Prism (because all prisms have a height).
 * Provide a constructor and the methods required by its abstract superclass.  
 */

public class RectangularPrism extends Prism {
	private double length;
	private double width;
	
	public RectangularPrism (double l, double w, double h) {
		super(h);
		length = l;
		width = w;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getLength() {
		return length;
	}
	
	public double calcAreaOfBase() {
		return width * length;
	}
	
	public double calcPerimeter() {
		return (4 * (getHeight() + length + width));
	}
	
	public double calcVolume() {
		return (width * length * getHeight());
	}
	
	public double calcSA() {
		return 2 * (calcAreaOfBase() + (getHeight() * (length + width)));
	}
}

