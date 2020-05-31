package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.LineItemDAO;
import model.*;

public class LineItemManager{
	private static LineItemManager lineItemMan = new LineItemManager();
	private LineItemDAO lineItemDAO;
	
	public LineItemManager() {
		try {
			lineItemDAO = new LineItemDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static LineItemManager getInstance() {
		return lineItemMan;
	}
	
	public Lineitem create(Lineitem lineItem) throws SQLException{
		return lineItemDAO.create(lineItem);
	}
	
	public List<Lineitem> findLineItmeList(int orderno) throws SQLException {
		return lineItemDAO.findLineItemList(orderno);
	}
	

	public LineItemDAO getLineitemDAO() {
		return this.lineItemDAO;
	}

}
