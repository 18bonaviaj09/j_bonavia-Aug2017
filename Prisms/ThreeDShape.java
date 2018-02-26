
public abstract class ThreeDShape {
	
	private double volume;
	private double surfaceArea;

	public ThreeDShape() {
		this.volume = calcVolume();
		this.surfaceArea = calcSA();
	}
	
	public double getVolume() {
		return round(volume);
	}
	
	public double getSA() {
		return round(surfaceArea);
	}

	// Can you write this code for this class or does it need to be overridden by every subclass?
	public abstract double calcVolume();

	// Can you write this code for this class or does it need to be overridden by every subclass?
	public abstract double calcSA();
	
	public void setup() {
		volume = calcVolume();
		surfaceArea = calcSA();
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
