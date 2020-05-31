package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.OrderDAO;
import model.*;

public class OrderManager{
	private static OrderManager orderMan = new OrderManager();
	private OrderDAO orderDAO;
	
	private OrderManager() {
		try {
			orderDAO = new OrderDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static OrderManager getInstance() {
		return orderMan;
	}
	
	public Order create(Order order) throws SQLException{
		return orderDAO.create(order);
	}
	
	public int update(Order order) throws SQLException{
		return orderDAO.update(order);
	}
	
	public Order findOrder(int orderno)throws SQLException{
		return orderDAO.findOrder(orderno);
	}
	
	public List<Order> findOrderList(String id) throws SQLException {
		return orderDAO.findOrderList(id);
	}
	
	public OrderDAO getOrderDAO() {
		return this.orderDAO;
	}

}
