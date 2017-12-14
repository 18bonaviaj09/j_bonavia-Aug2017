// Joseph Bonavia
// Object Class for Frac Calc

package fracCalc;

public class Fraction {
	private int whole;
	private int numerator;
	private int denominator;
	
	public Fraction(String fractionStr) {
		parsingMethod(fractionStr);
	}
	
	public Fraction() {
		whole = 0;
		numerator = 0;
		denominator = 1;
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
    	String output = "";
    	if (whole == 0 && numerator == 0) {
    		output += "0";
    	} else if (whole == 0) {
    		output += numerator;
    		output += "/";
    		output += denominator;
    	} else if (numerator == 0) {
    		output += whole;
    	} else {
    		output += whole;
    		output += "_";
    		output += numerator;
    		output += "/";
    		output += denominator;
    	}
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
    
    public int getNum() {
    	return numerator;
    }
    
    public int getDenom() {
    	return denominator;
    }

	public int getWhole() {
		return whole;
	}
	
	public void setNum(int newNum) {
		numerator = newNum;
	}
	
	public void setDenom(int newDenom) {
		denominator = newDenom;
	}
	
	public void setWhole(int newWhole) {
		whole = newWhole;
	}
	
	public void toImpFrac() {
    		numerator += (whole * denominator);
    		whole = 0;
	}
	
	public void simplifier() {
    	int gcf = gcfFind();
    	numerator /= gcf;
    	denominator /= gcf;
    	int newNum = numerator % denominator;
    	int plusWhole = numerator / denominator;
    	whole += plusWhole;
    	numerator = newNum;
    	if (numerator < 0 && whole < 0) {
    		numerator *= -1;
    	}
    }
	
	public void negativeCorrector() {
    	if (whole < 0) {
    		numerator *= -1;
    	}
    }
	
	private int gcfFind() {
    	int gcf = 1;
    	int start = 0;
    	if (absVal(numerator) >= absVal(denominator)) {
    		start = absVal(denominator);
    	} else {
    		start = absVal(numerator);
    	}
    	for (int i = start; i > 1; i--) {
			if (absVal(numerator) % i == 0 && absVal(denominator) % i == 0) {
				gcf = i;
				i = 1;
			}
    	}
    	return gcf;
    }
	
	private int absVal(int operand) {
    	if (operand < 0) {
    		return operand * -1;
    	} else {
    		return operand;
    	}
    }
}
