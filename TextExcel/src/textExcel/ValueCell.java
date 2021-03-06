package textExcel;

public class ValueCell extends RealCell {
	
	public ValueCell (String value) {
		super(value);
	}
	
	public String abbreviatedCellText() {
		String abbreviated = "" + createDouble(fullCellText(), 10);
		abbreviated  = powerOfTenFixer(abbreviated);
		abbreviated = pad(abbreviated);
		return abbreviated;
	}
	
}
