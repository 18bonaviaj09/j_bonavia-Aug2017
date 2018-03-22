package textExcel;

public class PercentCell extends ValueCell{
	
	public PercentCell (String value) {
		super(value);
	}
	
	public String abbreviatedCellText() {
		int point = super.fullCellText().indexOf(".");
		String abbreviated = super.fullCellText().substring(0, point) + "%";
		abbreviated = pad(abbreviated);
		return abbreviated;
	}
	
	public String fullCellText() {
		double output = createDouble(super.fullCellText(), Integer.MAX_VALUE);
		output /= 100;
		return "" + output;
		
	}
}
