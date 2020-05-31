package model.dao;

import java.sql.*;
import java.util.*;
import model.*;

public class LineItemDAO {
	private JDBCUtil jdbcUtil = null;
	public LineItemDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	public Lineitem create(Lineitem lineItem) {
		String sql = "INSERT INTO LINEITEM (lineitemno, item_no, orderno, item_amount, item_totalprice) " +
				"VALUES (line_seq.nextval, ?, ?, ?, ?)";
		Object[] param = new Object[] {lineItem.getItem_no(), lineItem.getOrderno(), lineItem.getItem_amount(), lineItem.getItem_total_price()};
		jdbcUtil.setSqlAndParameters(sql, param);
	
		String key[] = {"lineitemno"};	// PK �÷��� �̸�     
	
		try {
			jdbcUtil.executeUpdate(key);  // insert �� ����
			ResultSet rs = jdbcUtil.getGeneratedKeys();
			if(rs.next()) {
				int generatedKey = rs.getInt(1);   // ������ PK ��
				lineItem.setLineitemno(generatedKey); 	// id�ʵ忡 ����  
			}
			return lineItem;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
	}
	
	return null;
	}
	
	public List<Lineitem> findLineItemList(int orderno) throws SQLException {
		String sql = "SELECT * " + " FROM LINEITEM WHERE orderno=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {orderno});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Lineitem> lineItemList = new ArrayList<Lineitem>();
			while (rs.next()) {
				Lineitem lineItem = new Lineitem(rs.getInt("lineitemno"),rs.getInt("item_no"), rs.getInt("item_amount"),rs.getInt("item_totalprice"));
				lineItemList.add(lineItem);
			}
			return lineItemList;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	
}
