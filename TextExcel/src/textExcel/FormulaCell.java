package textExcel;

public class FormulaCell extends RealCell{
	
	public FormulaCell (String value) {
		super(value);
	}
	
	public String abbreviatedCellText() {
		String abbreviated = "" + createDouble(fullCellText(), 10);
		abbreviated  = powerOfTenFixer(abbreviated);
		abbreviated = pad(abbreviated);
		return abbreviated;
	}
	
	public double createDouble(String value, int length) {
		String[] formulaArray = value.split(" ");
		double resultant = super.createDouble(formulaArray[1], Integer.MAX_VALUE);
		for (int i = 2; i < formulaArray.length - 3; i += 2) {
			double nextValue = super.createDouble(formulaArray[i + 1], Integer.MAX_VALUE);
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

}
