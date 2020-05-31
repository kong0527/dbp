package model;
//�ֹ� ������ �����ϱ� ���� Ŭ����. LINEITEM ���̺�� ������
/**
 * @author nahoune
 *
 */
public class Lineitem {
	private int item_no;
	private int orderno;
	private int item_amount;
	private int item_price;
	private int item_total_price;
	private int lineitemno;
	private String item_name;
	
	public Lineitem() { }
	
	public Lineitem(int lineitemno,int item_no,int item_amount,int item_total_price) {
		super();
		this.lineitemno = lineitemno;
		this.item_no = item_no;
		this.item_amount = item_amount;
		this.item_total_price = item_total_price;
		
	}

	public int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public int getItem_amount() {
		return item_amount;
	}
	public void setItem_amount(int item_amount) {
		this.item_amount = item_amount;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public int getLineitemno() {
		return lineitemno;
	}
	public void setLineitemno(int lineitemno) {
		this.lineitemno = lineitemno;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String itemName) {
		this.item_name = itemName;
	}

	public int getItem_total_price() {
		return item_total_price;
	}

	public void setItem_total_price(int item_total_price) {
		this.item_total_price = item_total_price;
	}
	
	
	
}
