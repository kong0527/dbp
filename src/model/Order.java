package model;
//�ֹ��� �����ϱ� ���� Ŭ����. ORDERLIST ���̺�� ������
public class Order {
	private int orderno;
	private String order_address;
	private int totalprice;
	private String ordertime;
	private String id;
	
	public Order() { }
	
	public Order(int orderno, String order_address, int totalprice, String ordertime) {
		this.orderno = orderno;
		this.order_address = order_address;
		this.totalprice = totalprice;
		this.ordertime = ordertime;
	}
	
	public void update(Order updateOrder) {
		this.order_address = updateOrder.order_address;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public String getOrder_address() {
		return order_address;
	}

	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
