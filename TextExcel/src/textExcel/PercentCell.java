package textExcel;

public class PercentCell extends ValueCell{
	
	public PercentCell (String value) {
		super(value);
	}
	
	public String abbreviatedCellText() {
		String abbreviated = ((int) createDouble(super.fullCellText(), (super.fullCellText().substring(0, super.fullCellText().indexOf(".")))).length()) + "%";
		abbreviated = pad(abbreviated);
		return abbreviated;
	}
	
	public String fullCellText() {
		double output = createDouble(super.fullCellText(), Integer.MAX_VALUE);
		output /= 100;
		return "" + output;
		
	}
}
