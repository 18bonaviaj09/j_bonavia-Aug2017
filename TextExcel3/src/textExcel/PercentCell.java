// Joseph Bonavia
// This Class contains the algorithms necessary to manipulate the value of a PercentCell into the correct output

package textExcel;

public class PercentCell extends ValueCell{
	
	//constructor
	public PercentCell (String value) {
		super(value);
	}
	
	// returns the truncated version of the percent (before the decimal) and  % must be added
	public String abbreviatedCellText() {
		int point = super.fullCellText().indexOf(".");
		String abbreviated = super.fullCellText().substring(0, point) + "%";
		abbreviated = pad(abbreviated);
		return abbreviated;
	}
	
	// returns the decimal version of said percentage, so it must override fullCellText from real cell
	public String fullCellText() {
		double output = createDouble(super.fullCellText(), Integer.MAX_VALUE);
		output /= 100;
		return "" + output;
		
	}
}
