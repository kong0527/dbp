package model.dao;

import java.sql.*;
import java.util.*;
import model.User;

public class UserDAO {
	private JDBCUtil jdbcUtil = null;
	
	public UserDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	public int create(User user) throws SQLException {
		String sql = "INSERT INTO USERLIST (username, id, pw, address) " +
					"VALUES (?, ?, ?, ?)";
		Object[] param = new Object[] {user.getUsername(), user.getId(), user.getPw(), user.getAddress()};
		jdbcUtil.setSqlAndParameters(sql,  param);
		
		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return 0;
	}
	
	public User findUser(String userId) throws SQLException {
		String sql = "SELECT pw, username, address "
					+ "FROM USERLIST WHERE id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				User user = new User(rs.getString("username"), userId, rs.getString("pw"), rs.getString("address"));
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public List<User> findUserList() throws SQLException {
        String sql = "SELECT id, pw, username, address " 
        		   + "FROM USERLIST ORDER BY id";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil�� query�� ����
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query ����			
			List<User> userList = new ArrayList<User>();	// User���� ����Ʈ ����
			while (rs.next()) {
				User user = new User(rs.getString("username"), rs.getString("id"), rs.getString("pw"), rs.getString("address"));	
				userList.add(user);				// List�� User ��ü ����
			}		
			return userList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	public List<User> findUserList(int currentPage, int countPerPage) throws SQLException {
        String sql = "SELECT userno, id, pw, username, address " 
        		   + "FROM USERLIST ORDER BY id";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil�� query�� ����
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll ����
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query ����			
			int start = ((currentPage-1) * countPerPage) + 1;	// ����� ������ �� ��ȣ ���
			if ((start >= 0) && rs.absolute(start)) {			// Ŀ���� ���� ������ �̵�
				List<User> userList = new ArrayList<User>();	// User���� ����Ʈ ����
				do {
					User user = new User(rs.getString("usernmae"), rs.getString("id"), rs.getString("pw"), rs.getString("address"));	
					userList.add(user);							// ����Ʈ�� User ��ü ����
				} while ((rs.next()) && (--countPerPage > 0));		
				return userList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	public boolean isExisting(String userId) throws SQLException {
		String sql = "SELECT count(*) FROM USERLIST WHERE id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		
		return false;
	}
}

