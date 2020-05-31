package model;

public class Deco {
	
	private String decoType;
	private int dprice;
	
	public Deco() {}
	
	public Deco(String decoType, int dprice) {
		this.decoType = decoType;
		this.dprice = dprice;
	}

	public String getDecoType() {
		return decoType;
	}
	
	public void setDecoType(String decoType) {
		this.decoType = decoType;
	}
	
	public int getDprice() {
		return dprice;
	}
	
	public void setDprice(int dprice) {
		this.dprice = dprice;
	}
	
	

}
