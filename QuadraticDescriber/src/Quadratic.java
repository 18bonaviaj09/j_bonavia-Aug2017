
public class Quadratic {
	public static void quadrDescriber (double a, double b, double c) {
		if (a == 0) {
			System.out.println("Not a Quadratic Equation.");
		} else {
			System.out.println("Description of the Graph of: ");
			System.out.println(quadEqu(a,b,c));
			System.out.println("\nOpens: " + direction(a));
			System.out.println("Axis of Symmetry: " + axisOfSymmetry(a,b,c));
		}
	}
	
	//This method takes the three coefficients of a quadratic equation and returns its axis of symmetry
	
	//This method takes the first coefficient of a quadratic equation and returns which direction they open
	public static String direction(double a) {
		if (a< 0) {
			return "Down";
		} else {
			return "Up";
		}
	}
	
	//This method takes the three coefficients of a quadratic equation and turns them into a String equation
	public static String quadEqu(double a, double b, double c) {
		if (b < 0) {
			if (c < 0) {
				return a + " x^2 - " + absValue(b) + " x - " + absValue(c);
			} else if (c == 0){
				return a + " x^2 - " + absValue(b) + " x";
			} else {
				return a + " x^2 - " + absValue(b) + " x + " + c;
			}
		} else if (b == 0) {
			if (c < 0) {
				return a + " x^2 - " + absValue(c);
			} else if (c == 0){
				return a + " x^2";
			} else {
				return a + " x^2 + " + c;
			}
		} else {
			if (c < 0) {
				return a + " x^2 + " + b + " x - " + absValue(c);
			} else if (c == 0) {
				return a + " x^2 + " + b + " x";
			} else {
				return a + " x^2 + " + b + " x + " + c;
			}
		}
			
	}
	
	// This method accepts the three integer coefficients of a quadratic equation and returns its real roots in a string.
	public static String quadForm(double a, double b, double c) {
		if (discriminant(a,b,c) < 0) {
			return "no real roots";
		}
		double negative = ((b * -1) - sqrt(discriminant(a,b,c))) / (2 * a);
		double positive = ((b * -1) + sqrt(discriminant(a,b,c))) / (2 * a); 
		return round2(min(negative, positive)) + " and " + round2(max(negative, positive));
	}
	
	// This method takes the three coefficients in a quadratic equation and returns the discriminant.
	public static double discriminant (double a, double b, double c) {
		return (b * b) - (4 * a * c);
	}
	
	// This method takes two integers and returns the maximum between them. 
	public static double max (double operand1, double operand2) {
		if (operand1 < operand2) {
			return operand2; 
		}
		else {
			return operand1;
		}
	}
	
	//This method takes two integers and returns the minimum between them 
	public static double min (double operand1, double operand2) {
			if (operand1 > operand2) {
				return operand2; 
			}
			else {
				return operand1;
			}
		}
	
	// This method takes a double and rounds it to two decimal places
	public static double round2 (double operand) {
		int times100 = (int) (operand * 1000);
		int thousandths = times100 % 10;
		times100 = times100/10;
		if (thousandths >= 5) {
			times100++;
			double rounded = (times100 / 100.00);
			return rounded;
		} else if (thousandths <= -5) {
			times100--;
			double rounded = (times100 / 100.00);
			return rounded;
		} else {
			double rounded = (times100 / 100.00);
			return rounded;
		}	
	}
	
	// This method accepts accepts a double and returns an approximation of the square root of that double
	public static double sqrt (double operand) {
		double guess = operand/2;
		if (operand < 0) {
			throw new IllegalArgumentException("Cannot find the square root of a negative number.");
		}
		while ((guess * guess > operand + 0.005) || (guess * guess) < operand - 0.005) {
			guess = (0.5 * ((operand / guess) + guess));
		}
		return round2(guess);
	}
	
	// This method takes a integer and returns its absolute value
	public static double absValue (double operand) {
			if (operand < 0) {
				return operand * -1;
			}
			else {
				return operand;
			}
		}
}
