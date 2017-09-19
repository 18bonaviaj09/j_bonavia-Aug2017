/* Joseph Bonavia,
 * September 5, 2017
 * This class will be used to run and test the Calculate Library Methods. */

public class DoMath {
	
	public static void main(String[] args) {
		System.out.println(Calculate.square(12));
		System.out.println(Calculate.cube(5));
		System.out.println(Calculate.average(-3,3));
		System.out.println(Calculate.average(1,2,3));
		System.out.println(Calculate.toDegrees(-3.14159));
		System.out.println(Calculate.toRadians(-180));
		System.out.println(Calculate.discriminant(2, 2, 2));
		System.out.println(Calculate.toImproperFrac(3,1,2));
		System.out.println(Calculate.toMixedNum(7, 2));
		System.out.println(Calculate.foil(2, 3, 6, -7, "n"));
		System.out.println(Calculate.isDivisibleBy(6, 3));
		System.out.println(Calculate.absValue(-3.654));
		System.out.println(Calculate.max(3, 8));
		System.out.println(Calculate.max(16, -22, 5));
		System.out.println(Calculate.min(6, -34));
		System.out.println(Calculate.round2(-12.5436729));
		System.out.println(Calculate.exponent(5.00, 30));
		System.out.println(Calculate.factorial(3));
		System.out.println(Calculate.isPrime(27));
		System.out.println(Calculate.gcf(2, 5));
		System.out.println(Calculate.sqrt(7));
	}
	
}
