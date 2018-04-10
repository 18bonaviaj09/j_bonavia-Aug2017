// Joseph Bonavia
// The spreadsheet class contains all methods needed to parse input, and access cells 

package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid {
	
	Cell[][] thisSheet; 

	// constructor fills thisSheet with empty cells through reset method
	public Spreadsheet() {
		thisSheet = new Cell[getCols()][getRows()];
		reset();
	}
	
	
	// parses input from sent in from client code and performs necessary commands
	public String processCommand(String command) {
		String[] parsed = command.split(" ", 3);
		if(parsed.length == 1) {
			if (Character.isAlphabetic(Character.toLowerCase(command.charAt(0))) && Character.isDigit(command.charAt(1))) {
				Location thisCell = new SpreadsheetLocation(command);
				return getCell(thisCell).fullCellText();
			} else if (command.toLowerCase().equals("clear")) {
				reset();
				return getGridText();
			}
		} else if (parsed.length == 2) {
			if (command.toLowerCase().startsWith("clear")) {
				Location thisCell = new SpreadsheetLocation(parsed[1]);
				thisSheet[thisCell.getCol()][thisCell.getRow()] = new EmptyCell(); 
				return getGridText();
			}
		} else {
			if (Character.isAlphabetic(Character.toLowerCase(command.charAt(0))) && Character.isDigit(command.charAt(1))) {
				Location thisCell = new SpreadsheetLocation(parsed[0].toLowerCase());
				if (parsed[1].equals("=")) {
					if (parsed[2].startsWith("" + '"')) {
						String input = parsed[2].substring(1, (parsed[2].length() - 1));
						thisSheet[thisCell.getCol()][thisCell.getRow()] = new TextCell(input); 
					} else if (parsed[2].endsWith("%")) {
						String input = parsed[2].substring(0, (parsed[2].length() - 1));
						thisSheet[thisCell.getCol()][thisCell.getRow()] = new PercentCell(input);
					} else if (parsed[2].startsWith("(") && parsed[2].endsWith(")")) {
						thisSheet[thisCell.getCol()][thisCell.getRow()] = new FormulaCell(parsed[2], this);
					} else {
						thisSheet[thisCell.getCol()][thisCell.getRow()] = new ValueCell(parsed[2]);
					}
					return getGridText();
				}
			}
		}
		return "This is not a valid command.";

	}

	// returns number of rows
	public int getRows() {
		return 20;
	}

	// returns number of columns
	public int getCols() {
		return 12;
	}

	// returns the cell at a certain location
	public Cell getCell(Location loc) {
		return thisSheet[loc.getCol()][loc.getRow()];
	}

	// creates a String that contains the spreadsheet user interface
	public String getGridText() {
		String output = "   ";
		
		for (int i = 0; i < thisSheet.length; i++) {
			output = output + "|" + ((char)(65 + i)) + "         ";
		}
		output += "|\n";
		for (int r = 0; r < thisSheet[0].length; r++) {
			String rowNumber = "" + (r + 1);
			while (rowNumber.length() < 3) {
				rowNumber += " ";
			}
			output += rowNumber;
			for (int c = 0; c < thisSheet.length; c++) {
				output = output + "|" + thisSheet[c][r].abbreviatedCellText();
			}
			output += "|";
		output += "\n";
		}
		
		return output;
	}
	
	// sets every cell to an empty cell
	private void reset() {
		for (int r = 0; r < thisSheet[0].length; r++) {
			for (int c = 0; c < thisSheet.length; c++) {
				thisSheet[c][r] = new EmptyCell();
			}
		}
	}

}
  