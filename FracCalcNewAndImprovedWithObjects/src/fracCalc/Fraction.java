package fracCalc;

public class Fraction {
	private int whole;
	private int numerator;
	private int denominator;
	
	public Fraction(String fractionStr) {
		parsingMethod(fractionStr);
	}
	
	private void parsingMethod(String operand) {
    	String[] array1 = operand.split("_");
    	if (array1.length == 2) {
    		String[] array2 = array1[1].split("/");
    		whole = intoInt(array1[0]);
    		numerator = intoInt(array2[0]);
    		denominator = intoInt(array2[1]);
    	} else {
    		String[] array2 = array1[0].split("/");
    		if (array2.length == 2) {
    			whole = 0;
    			numerator = intoInt(array2[0]);
    			denominator =intoInt(array2[1]);
    		} else {
    			whole = intoInt(array1[0]);
    			numerator = 0; 
    			denominator = 1;
    		}
    	}
    }
	
	public String toString() {
		String output = "whole:";
		output += whole;
		output += " numerator:";
		output += numerator;
		output += " denominator:";
		output += denominator;
		return output;
	}
    
    private int intoInt(String input) {
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
}
