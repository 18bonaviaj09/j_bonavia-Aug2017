package textExcel;

public class FormulaCell extends RealCell{
	
	public FormulaCell (String value) {
		super(value);
	}
	
	public String abbreviatedCellText() {
		return pad("FORMULA");
	}

}
