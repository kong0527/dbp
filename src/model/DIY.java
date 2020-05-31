package model;
//DIY �� ��ü������ �����ϱ� ���� Ŭ����. diy ���̺� �Ӹ� �ƴ϶� 
//scent, deco, color, glue �� ������ �����ϰ� ����
public class DIY {
	private int diy_itemno;
	private int diy_amount;
	private String scenttype;
	private String decotype;
	private String colortype;
	private String gluetype;
	private int diy_price;
	private int orderno;
	private String diy_name;
	private int diy_total_price;
	
	public DIY() { }
	
	public DIY(int diy_itemno, int diy_amount, String scenttype, String decotype, String colortype, String gluetype, int diy_price) {
		this.diy_itemno = diy_itemno;
		this.diy_amount = diy_amount;
		this.scenttype = scenttype;
		this.decotype = decotype;
		this.colortype = colortype;
		this.gluetype = gluetype;
		this.diy_price = diy_price;
	}
	
	public int getDiy_price() {
		return diy_price;
	}


	public void setDiy_price(int diy_price) {
		this.diy_price = diy_price;
	}


	public int getDiy_itemno() {
		return diy_itemno;
	}

	public void setDiy_itemno(int diy_itemno) {
		this.diy_itemno = diy_itemno;
	}

	public String getScenttype() {
		return scenttype;
	}

	public void setScenttype(String scenttype) {
		this.scenttype = scenttype;
	}

	public String getDecotype() {
		return decotype;
	}

	public int getDiy_amount() {
		return diy_amount;
	}

	public void setDiy_amount(int diy_amount) {
		this.diy_amount = diy_amount;
	}

	public void setDecotype(String decotype) {
		this.decotype = decotype;
	}


	public String getColortype() {
		return colortype;
	}

	public void setColortype(String colortype) {
		this.colortype = colortype;
	}

	public String getGluetype() {
		return gluetype;
	}

	public void setGluetype(String gluetype) {
		this.gluetype = gluetype;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderNo) {
		this.orderno = orderNo;
	}

	public String getDiy_name() {
		return diy_name;
	}

	public void setDiy_name(String diy_name) {
		this.diy_name = diy_name;
	}

	public int getDiy_total_price() {
		return diy_total_price;
	}

	public void setDiy_total_price(int diy_total_price) {
		this.diy_total_price = diy_total_price;
	}
	
}
