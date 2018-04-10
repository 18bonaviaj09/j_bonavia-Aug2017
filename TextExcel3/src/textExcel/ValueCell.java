// Joseph Bonavia
// this class contains the algorithm and data necessary for cells containing simple double values

package textExcel;

public class ValueCell extends RealCell {
	
	// constructor
	public ValueCell (String value) {
		super(value);
	}
	
	// converts value into a double, fixes any errors introduced by scientific exponents, and then pads it if necessary returning it back in a string
	public String abbreviatedCellText() {
		String abbreviated = "" + createDouble(fullCellText(), 10);
		abbreviated  = powerOfTenFixer(abbreviated);
		abbreviated = pad(abbreviated);
		return abbreviated;
	}
	
}
