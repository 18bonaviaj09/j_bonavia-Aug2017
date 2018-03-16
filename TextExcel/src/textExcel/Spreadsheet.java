package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid {
	
	Cell[][] thisSheet; 

	public Spreadsheet() {
		thisSheet = new Cell[getCols()][getRows()];
	}
	
	@Override
	public String processCommand(String command) {
		return "";
	}

	@Override
	public int getRows() {
		return 20;
	}

	@Override
	public int getCols() {
		return 12;
	}

	@Override
	public Cell getCell(Location loc) {
		return null;
	}

	@Override
	public String getGridText() {
		String output = "   ";
		
		for (int i = 0; i < thisSheet.length; i++) {
			output = output + "|" + ((char)(65 + i)) + "         ";
		}
		
		output += "\n";
		
		return output;
	}

}
