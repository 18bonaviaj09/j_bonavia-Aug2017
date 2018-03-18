package textExcel;

public class TextCell implements Cell {
	private String value;
	
	public TextCell(String value) {
		this.value = value;
	}
	
	public String abbreviatedCellText() {
		String abbreviated;
		if (value.length() > 10) {
			abbreviated = value.substring(0, 10);
		} else {
			abbreviated = value;
			for (int i = value.length(); i <= 10 - 1; i++) {
				abbreviated += " ";
			}
		}
		return abbreviated;
	}
	
	public String fullCellText() {
		return "\"" + value + "\"";
	}
}
