// Joseph Bonavia
// This class contains all algorithms, all subclasses of RealCell share

package textExcel;

public abstract class RealCell implements Cell {
	private String value;
	
	//constructor
	public RealCell(String value) {
		this.value = value;
	}
	
	// creates a double version of the string inputed that is a given length or shorter
	public double createDouble(String value, int length) {
		String shortened = value;
		if (shortened.length() > length) {
			shortened = shortened.substring(0, length);
		}
		return Double.parseDouble(shortened);
	}
	
	// must be implemented by each subclass
	public abstract String abbreviatedCellText(); 
	
	// returns the original double value or formula of a real cell
	public String fullCellText() {
		return value;
	}
	
	// adds spaces to a string until it has a length of 10
	public String pad(String input) {
		while (input.length() < 10) {
			input += " ";
		}
		return input;
	}
	
	// creates strings from double values that have become too long due to the addition of scientific exponents
	public String powerOfTenFixer(String input) {
		String abbreviated = input;
		if (abbreviated.contains("E")) {
			int e = abbreviated.indexOf("E");
			String powerOfTen = abbreviated.substring(e, abbreviated.length());
			String number = abbreviated.substring(0, e);
			abbreviated = "" + createDouble(number, 10 - powerOfTen.length()) + powerOfTen;
		}
		abbreviated = pad(abbreviated);
		return abbreviated;
	}
	
	// returns the double version of cells value or formula
	public double getDoubleValue() {
		return createDouble(value, Integer.MAX_VALUE);
	}
	
}
