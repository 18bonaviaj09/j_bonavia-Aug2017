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
		int[] first = parsingMethod(inputArray[0]);
		int[] second = parsingMethod(inputArray[2]);
		int[] output = performOp(operator, first, second);
		if (inputArray.length > 3) {
			for (int i = 3; i < inputArray.length - 1; i += 2) {
				int[] nextOperand = parsingMethod(inputArray[i + 1]);
				String nextOperator = inputArray[i];
				output = performOp(nextOperator, output, nextOperand);
			}
		}
		return stringConstructor(output);
    }
    
    public static int[] parsingMethod(String operand) {
    	String[] array1 = operand.split("_");
    	if (array1.length == 2) {
    		String[] array2 = array1[1].split("/");
    		int[] numArray = {intoInt(array1[0]), intoInt(array2[0]), intoInt(array2[1])};
    		return numArray;
    	} else {
    		String[] array2 = array1[0].split("/");
    		if (array2.length == 2) {
    			int[] numArray = {0, intoInt(array2[0]), intoInt(array2[1])};
    			return numArray;
    		} else {
    			int[] numArray = {intoInt(array1[0]), 0, 1};
    			return numArray;
    		}
    	}
    }
    
    public static int intoInt(String input) {
    	if (input.indexOf("-") >= 0) {
    		String number = input.substring((input.indexOf("-") + 1), input.length());
    		int i = 0;
    		while (!number.equals("" + i)) {
    			i++;
    		}
    		return i * -1;
    	} else {
    		int i = 0;
    		while (!input.equals("" + i)) {
    			i++;
    		}
    		return i;
    	}
    }
    
    public static int[] performOp(String operator, int[] operand1, int[] operand2) {
    	int[] output = new int[3];
    	negativeCorrector(operand1);
    	negativeCorrector(operand2);
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
    
    public static int[] addMethod(int[] operand1, int[] operand2) {
    	int[] impFra1 = toImpFrac(operand1);
    	int[] impFra2 = toImpFrac(operand2);
    	int[] output = new int[3];
    	output[1] = (impFra1[0] * impFra2[1]) + (impFra2[0] * impFra1[1]);
    	output[2] = impFra1[1] * impFra2[1];
    	simplifier(output);
    	return output;
    }
    
    public static int[] subMethod(int[] operand1, int[] operand2) {
    	int[] subVersion = new int[3];
    	subVersion[0] = operand2[0] * -1;
    	subVersion[1] = operand2[1] * -1;
    	subVersion[2] = operand2[2];
    	int[] output = addMethod(operand1, subVersion);
    	simplifier(output);
    	return output;
    }
    		
    public static int[] multMethod(int[] operand1, int[] operand2) {
    	int[] impFra1 = toImpFrac(operand1);
    	int[] impFra2 = toImpFrac(operand2);
    	int[] output = new int[3];
    	output[1] = impFra1[0] * impFra2[0];
    	output[2] = impFra1[1] * impFra2[1];
    	simplifier(output);
    	return output;
    }
    		
    public static int[] divMethod(int[] operand1, int[] operand2) {
    	int[] output = new int[3];
    	int[] impFra2 = toImpFrac(operand2);
    	int divVersion1;
    	int divVersion2;
    	if (impFra2[0] < 0) {
    		divVersion1 = impFra2[1] * -1;
    		divVersion2 = impFra2[0] * -1;
    	} else {
    		divVersion1 = impFra2[1];
    		divVersion2 = impFra2[0];
    	}
    	output[1] = divVersion1;
    	output[2] = divVersion2;
    	int[] multOutput = multMethod(operand1, output);
    	return multOutput;
    }
    
    public static int[] toImpFrac(int[] operand) {
    	int[] output = new int[2];
    		int numerator = (operand[0] * operand[2]) + operand [1];
    		output[0] = numerator;
    		output[1] = operand[2];
    	return output;
	}
    
    public static void simplifier(int[] operand) {
    	int gcf = gcfFind(operand);
    	operand[1] /= gcf;
    	operand[2] /= gcf;
    	int newNum = operand[1] % operand[2];
    	int plusWhole = operand[1] / operand[2];
    	operand[0] += plusWhole;
    	operand[1] = newNum;
    	if (operand[1] < 0 && operand[0] < 0) {
    		operand[1] *= -1;
    	}
    }
    
    public static String stringConstructor(int[] operand) {
    	String output = "";
    	if (operand[0] == 0 && operand[1] == 0) {
    		output += "0";
    	} else if (operand[0] == 0) {
    		output += operand[1];
    		output += "/";
    		output += operand[2];
    	} else if (operand[1] == 0) {
    		output += operand[0];
    	} else {
    		output += operand[0];
    		output += "_";
    		output += operand[1];
    		output += "/";
    		output += operand[2];
    	}
    	return output;
    }
    
    public static void negativeCorrector(int[] operand) {
    	if (operand[0] < 0) {
    		operand[1] *= -1;
    	}
    }
    
    public static int gcfFind(int[] operand) {
    	int gcf = 1;
    	int start = 0;
    	if (absVal(operand[1]) >= absVal(operand[2])) {
    		start = absVal(operand[2]);
    	} else {
    		start = absVal(operand[1]);
    	}
    	for (int i = start; i > 1; i--) {
			if (absVal(operand[1]) % i == 0 && absVal(operand[2]) % i == 0) {
				gcf = i;
				i = 1;
			}
    	}
    	return gcf;
    }
    
    public static int absVal(int operand) {
    	if (operand < 0) {
    		return operand * -1;
    	} else {
    		return operand;
    	}
    }
    
}
