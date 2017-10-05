import java.util.*;
public class ProcessingNumbers {

	public static void main(String[] args) {
		boolean done = false;
		int sum = 0;
		int timesThrough = 0;
		int greatest = 0;
		int least = 0;
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to the Number Processor!");
		while (!done) {
			while (!done) {
				System.out.print("Enter a number: ");
				int num = userInput.nextInt();
				if (timesThrough == 0) {
					greatest = num;
					least = num;
					timesThrough++;
				}
				if ((num % 2) == 0) {
					sum += num;
				}
				if (num > greatest) {
					greatest = num;
				}
				if (num < least) {
					least = num;
				}
				System.out.println("Are those all your numbers? \n(Type \"yes\" to continue.)");
				String awnser = userInput.next();
				if (awnser.equals("yes")) {
					done = true;
				}
			}
			System.out.println("The sum of the even numbers is: " + sum);
			System.out.println("The greatest number is: " + greatest);
			System.out.println("The lowest number is: " + least);
			System.out.println("");
			System.out.println("Would you like to process another set of Numbers?");
			String awnser2 = userInput.next();
			if (awnser2.equals("yes")) {
				done = false;
			}
		}

	}

}
