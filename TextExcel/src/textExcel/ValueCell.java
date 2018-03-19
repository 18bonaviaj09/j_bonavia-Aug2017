package textExcel;

public class ValueCell extends RealCell {
	
	public ValueCell (double value) {
		super(value);
	}
	
	public ValueCell (int value) {
		super(0.0 + value);
	}
	
	public String abbreviatedCellText() {
		String abbreviated = "" + getValue();
		if (abbreviated.length() > 10) {
			abbreviated = abbreviated.substring(0, 10);
		} else
		
		return abbreviated;
	}
	
	public String fullCellText() {
		return "" + getValue();
	}
}
