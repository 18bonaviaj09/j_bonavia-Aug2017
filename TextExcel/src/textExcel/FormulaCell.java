package textExcel;

public class FormulaCell extends RealCell{
	
	Spreadsheet data;
	
	public FormulaCell (String value, Spreadsheet data) {
		super(value);
		this.data = data;
	}
	
	public String abbreviatedCellText() {
		String abbreviated = "" + createDouble(fullCellText(), 10);
		abbreviated  = powerOfTenFixer(abbreviated);
		abbreviated = pad(abbreviated);
		return abbreviated;
	}
	
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

	private double evaluator(String operand, String range) {
		if (operand.startsWith("SUM") || operand.startsWith("AVG")) {
			String[] begToEnd = range.split("-");
			double sum = 0;
			int n = 0;
			for (char col = begToEnd[0].charAt(0); col <= begToEnd[1].charAt(0); col++){
				for (char row = begToEnd[0].charAt(1); row <= begToEnd[1].charAt(1); row++){
					sum += valueGetter("" + col + row);
					n++;
				}
			}
			if (operand.startsWith("SUM")) {
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
	
	private double valueGetter(String operand) {
		Location loc = new SpreadsheetLocation(operand);
		return super.createDouble((data.getCell(loc)).abbreviatedCellText(), Integer.MAX_VALUE);
	}
	
}
