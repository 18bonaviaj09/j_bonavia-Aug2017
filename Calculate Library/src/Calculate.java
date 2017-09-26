/* Joseph Bonavia,
 * September 5, 2017
 * This class contains various mathematical methods. */

public class Calculate {
	
	// This method takes an integer and returns its square.
	public static int square (int operand) { 
		return operand * operand;
	}
	
	// This method takes a double and returns its square.
		public static double square (double operand) { 
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
		return (square(b)) - (4 * a * c);
	}
	
	// This method takes the three coefficients in a quadratic equation and returns the discriminant.
		public static double discriminant (int a, int b, int c) {
			return (double) (square(b)) - (4 * a * c);
		}
	
	// This method takes the integer parts of a mixed number and returns an improper fraction in the form of a string.
	public static String toImproperFrac (int whole, int numerator, int denominator) {
		return  ((whole * denominator) + numerator) + "/" + denominator;
	}
	
	// This method takes the integer parts of an improper fraction and returns a mixed number in the form of a string.
	public static String toMixedNum (int numerator, int denominator) {
		return (numerator / denominator) + " " + (numerator % denominator) + "/" + (denominator);
	}
	
	/*This method takes the four integer parts of two binomial equations and its variable in the form of a string
	 * and returns a quadratic equation in the form of a string. */
	public static String foil (int a, int b, int c, int d, String variableLetter) {
		if (((a * d) + (b * c)) < 0) {
			if ((b * d) < 0) {
				return (a * c) + variableLetter + "^2 - " + absValue((a * d) + (b * c)) + variableLetter + " - " + absValue(b * d);
			} else {
				return (a * c) + variableLetter + "^2 - " + absValue((a * d) + (b * c)) + variableLetter + " + " + (b * d);
			}
		} else {
			if ((b * d) < 0) {
				return (a * c) + variableLetter + "^2 + " + ((a * d) + (b * c)) + variableLetter + " - " + absValue(b * d);
			} else { 
				return (a * c) + variableLetter + "^2 + " + ((a * d) + (b * c)) + variableLetter + " + " + (b * d);
			}
		}
	}
	
	/* This method takes two integers and determines whether the first one is divisible by the second.
	* The output is in the form of a boolean. */
	public static boolean isDivisibleBy (int dividend, int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException("Cannot Divide By Zero");
		}
		return (dividend % divisor) == 0;
	}
	
	// This method takes a double and returns its absolute value
	public static double absValue (double operand) {
		if (operand < 0) {
			return operand * -1;
		}
		else {
			return operand;
		}
	}
	
	// This method takes a integer and returns its absolute value
		public static int absValue (int operand) {
			if (operand < 0) {
				return operand * -1;
			}
			else {
				return operand;
			}
		}
	
	// This method takes two integers and returns the maximum between them. 
	public static int max (int operand1, int operand2) {
		if (operand1 < operand2) {
			return operand2; 
		}
		else {
			return operand1;
		}
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
	
	// This method takes three integers and returns the maximum between them. 
	public static int max (int operand1, int operand2, int operand3) {
		if ((operand1 < operand2) && (operand3 < operand2)) {
			return operand2; 
		}
		else  if ((operand1 < operand3) && (operand2 < operand3)) {
			return operand3;
		}
		
		else {
			return operand1;
		}
	}
	
	//This method takes two integers and returns the minimum between them 
	public static int min (int operand1, int operand2) {
		if (operand1 > operand2) {
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
	
	//This method accepts and integer and a double and raises the double to the integer power. 
	public static double exponent (double operand, int exponent) {
		double awnser = 1.00;
		if (exponent < 0) {
			throw new IllegalArgumentException("Does not work for a negative exponent");
		}
		for (int i = 0; i < exponent; i++) {
			awnser = awnser * operand;
		}
		return awnser;
	
	}
	
	// This method accepts an integer and returns its factorial as an integer. 
	public static int factorial (int operand) {
		int awnser = 1;
		if (operand < 0) {
			throw new IllegalArgumentException("Cannot find the factorial of a negative number.");
		}
		while (operand > 0) {
			awnser = awnser * operand;
			operand--;
		}
		return awnser;
	}
	
	// This method accepts and integer and returns whether or not it is prime in the form of a boolean.
	public static boolean isPrime (int operand) {
		if (operand < 2) {
			return false;
		} else if (operand == 2) {
			return true;
		} else
			for (int divisor = 2; divisor < operand; divisor++) {
				if (isDivisibleBy(operand,divisor)) {
					return false;
				}
			}
		return true;
	}	
	
	// This method accepts two integers and returns their greatest common factor
	public static int gcf (int operand1, int operand2) {
		if(operand1 == operand2) {
			return operand1;
		} else if (operand1 == 1 || operand2 == 1) {
			return 1;
		} else {
			for (int factor = operand1; factor > 1; factor--) {
				if (isDivisibleBy(operand1, factor) && isDivisibleBy(operand2, factor)) {
					return factor;
				}
			}
		}
		return 1;
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
	
	// This method accepts accepts a integer and returns an approximation of the square root of that double
		public static double sqrt (int operand) {
			double guess = operand/2;
			if (operand < 0) {
				throw new IllegalArgumentException("Cannot find the square root of a negative number.");
			}
			while ((guess * guess > operand + 0.005) || (guess * guess) < operand - 0.005) {
				guess = (0.5 * ((operand / guess) + guess));
			}
			return round2(guess);
		}
	
	// This method accepts the three integer coefficients of a quadratic equation and returns its real roots in a string.
	public static String quadForm(int a, int b, int c) {
		if (discriminant(a,b,c) < 0) {
			return "no real roots";
		}
		double negative = ((b * -1) - sqrt(discriminant(a,b,c))) / (2 * a);
		double positive = ((b * -1) + sqrt(discriminant(a,b,c))) / (2 * a); 
		return round2(min(negative, positive)) + " and " + round2(max(negative, positive));
	}

}



