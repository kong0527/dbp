package model.service;

import java.util.List;
import java.sql.SQLException;
import model.Item;
import model.dao.ItemDAO;

public class ItemManager {
	private static ItemManager itemMan = new ItemManager();
	private ItemDAO itemDAO;
	
	private ItemManager() {
			try {
				itemDAO = new ItemDAO();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static ItemManager getInstance() {
		return itemMan;
	}
	
	public List<Item> itemList() throws SQLException {
		return itemDAO.itemList();
	}
	
	public Item showDetail(String itemName) throws SQLException {
		Item item = itemDAO.showDetail(itemName);
		return item;
	}
	
	public boolean isSoldOut(int storage) {
		if (storage == 0)
			return true;
		return false;
	}
	
	public ItemDAO getItemDAO() {
		return this.itemDAO;
	}
	
	public String getSlimeName(int item_no) throws SQLException{
		return itemDAO.findSlimeName(item_no);
	}
}
