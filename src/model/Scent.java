package model;

public class Scent {
	private String scentType;
	private int sprice;
	
	public Scent() {}
	
	public Scent(String scentType, int sprice) {
		this.scentType = scentType;
		this.sprice = sprice;
	}
	
	public String getScentType() {
		return scentType;
	}
	
	public void setScentType(String scentType) {
		this.scentType = scentType;
	}
	
	public int getSprice() {
		return sprice;
	}
	
	public void setSprice(int sprice) {
		this.sprice = sprice;
	}
	
	
}
