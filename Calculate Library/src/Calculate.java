/* Joseph Bonavia,
 * September 5, 2017
 * This class contains various mathematical methods. */

public class Calculate {
	
	// This method takes an integer and returns its square.
	public static int square (int operand) { 
		return operand * operand;
	}
	
	// This method takes an integer and returns its cube.
	public static int cube (int operand) { 
		return operand * operand * operand;
	}
	
	// This method takes two doubles and returns their average.
	public static double average (double operand1, double operand2) {
		return (operand1 + operand2) / 2;
	}
	
	// This method takes three doubles and returns their average.
	public static double average (double operand1, double operand2, double operand3) {
		return (operand1 + operand2 + operand3) / 3;
	}
	
	// This method takes a double in radians and converts it to degrees.
	public static double toDegrees (double radians) {
		return (radians * 180) / 3.14159;
	}
	
	// This method takes a double in radians and converts it to degrees.
	public static double toRadians (double degrees) {
		return (degrees * 3.14159) / 180;
	}
	
	// This method takes the three coefficients in a quadratic equation and returns the discriminant.
	public static double discriminant (double a, double b, double c) {
		return (b * b) - (4 * a * c);
	}
	
	/* This method takes the integer parts of a mixed number and creates an improper fraction
	public static string toImproperFrac (int whole, int numerator, int denominator) {
		return  
	}*/
	
}
