package model.dao;

import java.sql.*;
import java.util.*;
import model.*;

public class DIYDAO {
	private JDBCUtil jdbcUtil = null;
	public DIYDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	public DIY create(DIY diy) {
		String sql = "INSERT INTO DIY (diy_itemno, diy_amount, diy_price, orderno, gluetype, colortype, scenttype, decotype) " +
				"VALUES (diy_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] {diy.getDiy_amount(), diy.getDiy_price(), diy.getOrderno(), diy.getGluetype(), diy.getColortype(), diy.getScenttype(), diy.getDecotype()};
		jdbcUtil.setSqlAndParameters(sql, param);
		
		String key[] = {"diy_itemno"};	    
		
		try {
			jdbcUtil.executeUpdate(key);  
		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	if(rs.next()) {
		   		int generatedKey = rs.getInt(1);
		   		diy.setDiy_itemno(generatedKey);
		   	}
		   	return diy;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return null;
	}
	
	
	public List<Scent> findScent() throws SQLException {
		String sql = "SELECT scenttype, sprice "
				+ "FROM SCENT ORDER BY scenttype";
		jdbcUtil.setSqlAndParameters(sql, null);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Scent> scentList = new ArrayList<Scent>();
			while (rs.next()) {
				Scent scent = new Scent(rs.getString("scenttype"), rs.getInt("sprice"));
				scentList.add(scent);
			}
			return scentList;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public List<Deco> findDeco() throws SQLException {
		String sql = "SELECT decotype, dprice "
				+ "FROM Deco ORDER BY decotype";
		jdbcUtil.setSqlAndParameters(sql, null);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Deco> decoList = new ArrayList<Deco>();
			while (rs.next()) {
				Deco deco = new Deco(rs.getString("decotype"), rs.getInt("dprice"));
				decoList.add(deco);
			}
			return decoList;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public List<Color> findColor() throws SQLException {
		String sql = "SELECT colortype, cprice "
				+ "FROM Color ORDER BY colortype";
		jdbcUtil.setSqlAndParameters(sql, null);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Color> colorList = new ArrayList<Color>();
			while (rs.next()) {
				Color color = new Color(rs.getString("colortype"), rs.getInt("cprice"));
				colorList.add(color);
			}
			return colorList;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public List<Glue> findGlue() throws SQLException {
		String sql = "SELECT gluetype, gprice "
				+ "FROM GLUE ORDER BY gluetype";
		jdbcUtil.setSqlAndParameters(sql, null);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Glue> glueList = new ArrayList<Glue>();
			while (rs.next()) {
				Glue glue = new Glue(rs.getString("gluetype"), rs.getInt("gprice"));
				glueList.add(glue);
			}
			return glueList;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public List<DIY> findDIYList(int orderno) throws SQLException {
		String sql = "SELECT * " + " FROM DIY WHERE orderno=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {orderno});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<DIY> DIYList = new ArrayList<DIY>();
			while (rs.next()) {
				DIY diy = new DIY(rs.getInt("diy_itemno"), rs.getInt("diy_amount"), rs.getString("scenttype"), rs.getString("decotype"), rs.getString("colortype"), rs.getString("gluetype"), rs.getInt("diy_price"));
				DIYList.add(diy);
			}
			return DIYList;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	
}
