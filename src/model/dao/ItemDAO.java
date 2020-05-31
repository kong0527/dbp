package model.dao;

import java.sql.*;
import java.util.*;
import model.Item;

public class ItemDAO {
	private JDBCUtil jdbcUtil = null;
	
	public ItemDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	//��ü �������� �����ְ� �ϴ� �޼ҵ�
	public List<Item> itemList() throws SQLException {
		String sql = "SELECT item_no, item_name, item_price, detail "
				+ "FROM ITEM ORDER BY item_no";
		jdbcUtil.setSqlAndParameters(sql, null);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Item> itemList = new ArrayList<Item>();
			while (rs.next()) {
				Item item = new Item(rs.getString("item_name"), rs.getInt("item_no"), rs.getInt("item_price"), rs.getString("detail"));
				itemList.add(item);
			}
			return itemList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public String findSlimeName(int item_no) throws SQLException {
		String sql = "SELECT item_name"
				+ "FROM ITEM WHERE item_no=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {item_no});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			rs.next();
			return rs.getString(1);		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	//������ Ŭ���� �󼼺���
	public Item showDetail (String itemName) throws SQLException {
		String sql = "SELECT item_no, item_price, detail "
				+ "FROM ITEM WHERE item_name=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {itemName});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				Item item = new Item(itemName, rs.getInt("item_no"), rs.getInt("item_price"),rs.getString("detail"));
				return item;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

}
