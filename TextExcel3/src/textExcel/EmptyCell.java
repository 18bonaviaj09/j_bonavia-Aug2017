// Joseph Bonavia
// This Class contains the data for all empty cells.

package textExcel;

public class EmptyCell implements Cell{
	
	// returns String containing 10 spaces
	public String abbreviatedCellText() {
		return "          ";
	}
	
	// returns empty string
	public String fullCellText() { // text for individual cell inspection, not truncated or padded
		return "";
	}
}
