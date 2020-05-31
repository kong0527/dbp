package model;
// ����ǰ�� �����ϱ� ���� Ŭ����. ITEM + CATEGORY ���̺�� ������
public class Item {
	private String slimename;
	private int item_no;
	private int item_price;
	private String detail;

	public Item() { }

	public Item(String slimename, int item_no, int item_price, String detail) {
		super();
		this.slimename = slimename;
		this.item_no = item_no;
		this.item_price = item_price;
		this.detail = detail;
	}

	public void update (Item updateItem) {
		this.slimename = updateItem.slimename;
		this.item_price = updateItem.item_price;
	}
	
	public String getSlimename() {
		return slimename;
	}

	public void setSlimename(String slimename) {
		this.slimename = slimename;
	}

	public int getItem_no() {
		return item_no;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	} 
	
}
