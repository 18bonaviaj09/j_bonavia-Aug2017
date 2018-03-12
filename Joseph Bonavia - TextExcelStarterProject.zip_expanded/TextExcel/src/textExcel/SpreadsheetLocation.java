package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String cellName;
   
	@Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getCol().
    {
        char col = cellName.charAt(0);
        col = Character.toLowerCase(col);
        return Character.getNumericalValue(col) - 97;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        this.cellName = cellName;
    }

}
