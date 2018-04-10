// Joseph Bonavia
// this class contains the algorithms necessary to search for cells based on their names (A1 - L20) 

package textExcel;

public class SpreadsheetLocation implements Location {
	private String cellName;
	
	// constructor
    public SpreadsheetLocation(String cellName) {
        this.cellName = cellName.toLowerCase();
    }
    
    // returns row index of cell array (zero-based)
    public int getRow() {
        String number = cellName.substring(1,cellName.length());
        int row = 0;
        while (!(number.equals("" + row))) {
        	row++;
        }
    	return row - 1;
    }

    // returns column index of cell array (zero-based)
    public int getCol()
    {
        char letter = cellName.charAt(0);
        letter = Character.toLowerCase(letter);
        return Character.getNumericValue(letter) - Character.getNumericValue('a');
        
        
    }

}
