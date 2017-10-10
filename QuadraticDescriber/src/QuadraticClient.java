
import java.util.*;
public class QuadraticClient {
	public static void main (String [] args) {
		boolean goOn = true;
		Scanner inputVariables = new Scanner (System.in);
		while (goOn == true) {
			System.out.println("Welcome to the Quadratic Describer.");
			System.out.println("Provide Values for coefficients a, b, and c.");
			System.out.print("\na: ");
			double a = inputVariables.nextDouble();
			System.out.print("b: ");
			double b = inputVariables.nextDouble();
			System.out.print("c: ");
			double c = inputVariables.nextDouble();
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println("\nDo you want to keep going? (type \"quit\" to end)");
			String shouldIContinue = inputVariables.next();
			if (shouldIContinue.equals("quit") || shouldIContinue.equals("q")){
					goOn = false;
			} else {
				goOn = true;	
			}
		}
	}
}
