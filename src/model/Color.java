package model;

public class Color {
	private String colorType;
	private int cprice;
	
	public Color() {}

	
	
	public Color(String colorType, int cprice) {
		this.colorType = colorType;
		this.cprice = cprice;
	}

	public String getColorType() {
		return colorType;
	}

	public void setColorType(String colorType) {
		this.colorType = colorType;
	}

	public int getCprice() {
		return cprice;
	}

	public void setCprice(int cprice) {
		this.cprice = cprice;
	}
	
	

}
