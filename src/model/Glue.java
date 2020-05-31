package model;

public class Glue {
	private String glueType;
	private int gprice;
	
	public Glue() { }
	
	public Glue(String glueType, int gprice) {
		this.glueType = glueType;
		this.gprice = gprice;
	}

	public String getGlueType() {
		return glueType;
	}

	public void setGlueType(String glueType) {
		this.glueType = glueType;
	}

	public int getGprice() {
		return gprice;
	}

	public void setGprice(int gprice) {
		this.gprice = gprice;
	}
	
	
	
	

}
