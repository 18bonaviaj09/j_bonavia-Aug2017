// Joseph Bonavia
// This class contains the data and algorithms for cells containing text

package textExcel;

public class TextCell implements Cell {
	private String value;
	
	// constructor
	public TextCell(String value) {
		this.value = value;
	}
	
	// returns version of text (value) that is either trimmed down or padded with spaces to have a length of 10
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
	
	// returns original text surrounded by quotation marks
	public String fullCellText() {
		return "\"" + value + "\"";
	}
}
