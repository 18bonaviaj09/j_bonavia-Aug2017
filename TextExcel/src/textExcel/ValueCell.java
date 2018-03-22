package textExcel;

public class ValueCell extends RealCell {
	
	public ValueCell (String value) {
		super(value);
	}
	
	public String abbreviatedCellText() {
		String abbreviated = "" + createDouble(fullCellText(), 10);
		if (abbreviated.contains("E")) {
			int e = abbreviated.indexOf("E");
			String powerOfTen = abbreviated.substring(e, abbreviated.length());
			String number = abbreviated.substring(0, e);
			abbreviated = "" + createDouble(number, 10 - powerOfTen.length()) + powerOfTen;
		}
		abbreviated = pad(abbreviated);
		return abbreviated;
	}
	
}
