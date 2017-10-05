
import java.util.*;
public class QuadraticClient {
	public static void main (String [] args) {
		boolean goOn = true;
		Scanner inputVariables = new Scanner (System.in);
		while (goOn == true) {
			System.out.println("Welcome to the Quadratic Describer.");
			System.out.println("Provide Values for coefficients a, b, and c.");
			System.out.print("a: ");
			double a = inputVariables.nextDouble();
			System.out.print("b: ");
			double b = inputVariables.nextDouble();
			System.out.print("c: ");
			double c = inputVariables.nextDouble();
			Quadratic.quadrDescriber(a, b, c);
			System.out.println("Do you want to keep going? <type \"quit\" to end>");
			String shouldIContinue = inputVariables.next();
			if (shouldIContinue.equals("quit")){
					goOn = false;
			} else {
				goOn = true;	
			}
		}
	}
}
