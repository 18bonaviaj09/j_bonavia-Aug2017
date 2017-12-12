// Joseph Bonavia 
//This Program takes in user input in the form of an equation of fractions and outputs an answer.

package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner fractionInput = new Scanner(System.in);
    	boolean done = false;
    	while (!done == true) {
    		System.out.println("Give me an equation.");
    		String equation = fractionInput.nextLine();
    		System.out.println("\n" + produceAnswer(equation));
    		System.out.println("\n Would you like to enter another equation? (enter \"quit\" to end)");
    		String quitting = fractionInput.nextLine();
    		if (quitting.equals("quit")) {
    			done = true;
    		}
    	}
    }
    
    public static String produceAnswer(String input) { 
		String[] inputArray = input.split(" ");
		String operator = inputArray[1];
		Fraction frac1 = new Fraction(inputArray[0]);
		Fraction frac2 = new Fraction(inputArray[2]);
		Fraction output = performOp(operator, frac1, frac2);
		if (inputArray.length > 3) {
			for (int i = 3; i < inputArray.length - 1; i += 2) {
				Fraction nextOperand = new Fraction(inputArray[i + 1]);
				String nextOperator = inputArray[i];
			output = performOp(nextOperator, output, nextOperand);
			}
		}
		return output.toString();
    }
    
    public static Fraction performOp(String operator, Fraction operand1, Fraction operand2) {
    	Fraction output = new Fraction();
    	operand1.negativeCorrector();
    	operand2.negativeCorrector();
    	if (operator.equals("+")) {
    		output = addMethod(operand1, operand2);
    	} else if (operator.equals("-")) {
    		output = subMethod(operand1, operand2);
    	} else if (operator.equals("*")) {
    		output = multMethod(operand1, operand2);
    	} else {
    		output = divMethod(operand1, operand2);
    	}
    	return output;
    }
    
    public static Fraction addMethod(Fraction operand1, Fraction operand2) {
    	operand1.toImpFrac();
    	operand2.toImpFrac();
    	Fraction output = new Fraction();
    	output.setNum((operand1.getNum() * operand2.getDenom()) + (operand2.getNum() * operand1.getDenom()));
    	output.setDenom(operand1.getDenom() * operand2.getDenom());
    	output.simplifier();
    	return output;
    }
    
    public static Fraction subMethod(Fraction operand1, Fraction operand2) {
    	Fraction subVersion = new Fraction();
    	subVersion.setWhole(operand2.getWhole() * -1);
    	subVersion.setNum(operand2.getNum() * -1);
    	subVersion.setDenom(operand2.getDenom());
    	Fraction output = addMethod(operand1, subVersion);
    	return output;
    }
    		
    public static Fraction multMethod(Fraction operand1, Fraction operand2) {
    	operand1.toImpFrac();
    	operand2.toImpFrac();
    	Fraction output = new Fraction();
    	output.setNum(operand1.getNum() * operand2.getNum());
    	output.setDenom(operand1.getDenom() * operand2.getDenom());
    	output.simplifier();
    	return output;
    }
    		
    public static Fraction divMethod(Fraction operand1, Fraction operand2) {
    	Fraction output = new Fraction();
    	operand2.toImpFrac();
    	int divVersion1;
    	int divVersion2;
    	if (operand2.getNum() < 0) {
    		divVersion1 = operand2.getDenom() * -1;
    		divVersion2 = operand2.getNum() * -1;
    	} else {
    		divVersion1 = operand2.getDenom();
    		divVersion2 = operand2.getNum();
    	}
    	output.setNum(divVersion1);
    	output.setDenom(divVersion2);
    	Fraction multOutput = multMethod(operand1, output);
    	return multOutput;
    }
    
}
