package textExcel;

public abstract class RealCell implements Cell {
	private String value;
	
	public RealCell(String value) {
		this.value = value;
	}
	
	public double createDouble(String value, int length) {
		String shortened = value;
		if (shortened.length() > length) {
			shortened = shortened.substring(0, length);
		}
		return Double.parseDouble(shortened);
	}
	
	public abstract String abbreviatedCellText(); 
	
	public String fullCellText() {
		return value;
	}
	
	public String pad(String input) {
		while (input.length() < 10) {
			input += " ";
		}
		return input;
	}
	
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
}
