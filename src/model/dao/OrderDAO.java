package model.dao;

import java.sql.*;
import java.util.*;

import model.Board;
import model.Order;
import model.User;

public class OrderDAO {
	private JDBCUtil jdbcUtil = null;
	
	public OrderDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	public Order create(Order order) throws SQLException {
		String sql = "INSERT INTO ORDERLIST (orderno, order_address, totalprice, ordertime, id) " +
					"VALUES (order_seq.nextval, ?, ?, SYSDATE, ?)";
		Object[] param = new Object[] {order.getOrder_address(), order.getTotalprice(), order.getId()};
		jdbcUtil.setSqlAndParameters(sql, param);
		
		String key[] = {"orderno"};	// PK �÷��� �̸�     
		
		try {
			jdbcUtil.executeUpdate(key);  // insert �� ����
		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	if(rs.next()) {
		   		int generatedKey = rs.getInt(1);   // ������ PK ��
		   		order.setOrderno(generatedKey); 	// id�ʵ忡 ����  
		   	}
		   	return order;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return null;

	}
	
	public int update(Order order) throws SQLException {
		String sql = "UPDATE ORDERLIST "
					+ "SET address=? "
					+ "WHERE orderno=?";
		Object[] param = new Object[] {order.getOrder_address(), order.getOrderno()};
		jdbcUtil.setSqlAndParameters(sql,  param);
		
		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return 0;
	}
	
	public Order findOrder(int orderNo) throws SQLException {
		String sql = "SELECT order_address, totalprice, ordertime"
					+ "FROM ORDERLIST WHERE id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {orderNo});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy/MM/dd");
		        java.util.Date utilDate = new java.util.Date(rs.getDate("ordertime").getTime());
		        String date = df.format(utilDate);
				Order order = new Order(orderNo, rs.getString("order_address"), rs.getInt("totalprice"), date);
				return order;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public List<Order> findOrderList(String id) throws SQLException {
		String sql = "SELECT orderno, order_address, totalprice, ordertime "
				+ "FROM ORDERLIST WHERE id=? ORDER BY orderno DESC";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {id});

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Order> orderList = new ArrayList<Order>();
			while (rs.next()) {
				java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy/MM/dd");
				java.util.Date utilDate = new java.util.Date(rs.getDate("ordertime").getTime());
				String date = df.format(utilDate);
				Order order = new Order(rs.getInt("orderno"), rs.getString("order_address"), rs.getInt("totalprice"), date);
				orderList.add(order);
			}
			return orderList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
}

