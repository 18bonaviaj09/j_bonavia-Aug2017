package textExcel;

public abstract class RealCell implements Cell {
	private double value;
	
	public RealCell(double value) {
		this.value = value;
	}
	
	protected double getValue() {
		return value;
	}
	
	public abstract String abbreviatedCellText(); 
	public abstract String fullCellText();
	
}
