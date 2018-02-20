/* Write this abstract class called Prism.  It has one private field (height) and a constructor.  
 * It contains the methods calcAreaOfBase, calcPerimeter, calcVolume, and calcSA.
 * None of these methods require parameters.   
 * A couple are abstract - can you tell which ones and why?
 * 
 * Math note:
 * The volume of any prism can be found by multiplying the area of the base by the height.
 * The surface area of any prism can be found by multiplying the perimeter of the base by the height
 *   and then adding on the areas of the 2 bases.
 */


public abstract class Prism  {
	private double height;
	
	public Prism(double h) {
		height = h;
	}
	
	public double getHeight() {
		return height;
	}
	
	public abstract double calcAreaOfBase();
	
	public abstract double calcPerimeter();
	
	public double calcVolume() {
		return round(calcAreaOfBase() * height);
	}
	
	public double calcSA() {
		return round((2 * calcAreaOfBase()) + (calcPerimeter() * height));
	}
	
	private double round (double operand) {
		int times100 = (int) (operand * 100);
		int thousandths = times100 % 10;
		times100 = times100/10;
		if (thousandths >= 5) {
			times100++;
			double rounded = (times100 / 10.00);
			return rounded;
		} else if (thousandths <= -5) {
			times100--;
			double rounded = (times100 / 10.00);
			return rounded;
		} else {
			double rounded = (times100 / 10.00);
			return rounded;
		}
		
	}
	
}
	