package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.DIYDAO;
import model.*;

public class DIYManager{
	private static DIYManager diyMan = new DIYManager();
	private DIYDAO diyDAO;
	
	public DIYManager() {
		try {
			diyDAO = new DIYDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DIYManager getInstance() {
		return diyMan;
	}
	
	public DIY create(DIY diy) throws SQLException{
		return diyDAO.create(diy);
	}
	
	public List<Scent> findScent() throws SQLException {
		return diyDAO.findScent();
	}
	
	public List<Deco> findDeco() throws SQLException {
		return diyDAO.findDeco();
	}
	
	public List<Color> findColor() throws SQLException {
		return diyDAO.findColor();
	}
	
	public List<Glue> findGlue() throws SQLException {
		return diyDAO.findGlue();
	}
	
	public List<DIY> findDIYList(int orderno) throws SQLException {
		return diyDAO.findDIYList(orderno);
	}

	public DIYDAO getDIYDAO() {
		return this.diyDAO;
	}

}
