// Joseph Bonavia
// This Class contains the algorithms to parse the formulas put into the console and return a double value based on them.

package textExcel;

public class FormulaCell extends RealCell{
	
	Spreadsheet data;
	
	// this constructor takes the spreadsheet (data) we are using in addition to the formula (value) so it can access data stored in other cells
	public FormulaCell (String value, Spreadsheet data) {
		super(value);
		this.data = data;
	}
	
	// first creates a double of maximum length 10 and then fixes any errors caused by extremely large or small numbers
	// finally it pads the string to the proper length
	public String abbreviatedCellText() {
		String abbreviated = "" + createDouble(fullCellText(), 10);
		abbreviated  = powerOfTenFixer(abbreviated);
		abbreviated = pad(abbreviated);
		return abbreviated;
	}
	
	// overridden for the formula method so that it can take the formula (value) and create a double based off its contents
	public double createDouble(String value, int length) {
		String[] formulaArray = value.split(" ");
		double resultant = evaluator(formulaArray[1], formulaArray[2]);
		for (int i = 2; i < formulaArray.length - 2; i += 2) {
			double nextValue = evaluator(formulaArray[i + 1], "");
			if (formulaArray[i].equals("+")) {
				resultant = resultant + nextValue;
			} else if (formulaArray[i].equals("-")) {
				resultant = resultant - nextValue;
			} else if (formulaArray[i].equals("*")) {
				resultant = resultant * nextValue;
			} else {
				resultant = resultant / nextValue;
			}
		}
		resultant = super.createDouble("" + resultant, length);
		return resultant;
	}

	// evaluates cell names and SUM/AVG ranges. i.e. anything that isn't a straight forward number
	private double evaluator(String operand, String range) {
		if (operand.toLowerCase().startsWith("sum") || operand.toLowerCase().startsWith("avg")) {
			String[] begToEnd = range.split("-");
			double sum = 0;
			int n = 0;
			for (char col = Character.toUpperCase(begToEnd[0].charAt(0)); col <= Character.toUpperCase(begToEnd[1].charAt(0)); col++){
				for (int row = Integer.parseInt(begToEnd[0].substring(1, begToEnd[0].length())); row <= Integer.parseInt(begToEnd[1].substring(1, begToEnd[1].length())); row++){
					sum += valueGetter("" + col + row);
					n++;
				}
			}
			if (operand.toLowerCase().startsWith("sum")) {
				return sum;
			} else {
				return sum/n;
			}
		} else if (Character.isAlphabetic(operand.charAt(0))) {
			return valueGetter(operand);
		} else {
			return super.createDouble(operand, Integer.MAX_VALUE);
		}
	}
	
	// fetches the values of a given cell from the spreadsheet
	private double valueGetter(String operand) {
		Location loc = new SpreadsheetLocation(operand);
		return super.createDouble((data.getCell(loc)).abbreviatedCellText(), Integer.MAX_VALUE);
	}
	
}
