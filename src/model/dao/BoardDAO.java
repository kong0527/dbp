package model.dao;

import java.sql.*;
import java.util.*;
import model.Board;

public class BoardDAO {
	private JDBCUtil jdbcUtil = null;
	
	public BoardDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	public List<Board> boardList() throws SQLException {
		String sql = "SELECT boardno, answer, inquiry, id, title, upload_time "
				+ "FROM BOARD ORDER BY boardno DESC";
		jdbcUtil.setSqlAndParameters(sql, null);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			jdbcUtil.setSqlAndParameters(sql, null);
			List<Board> boardList = new ArrayList<Board>();
			while (rs.next()) {
				java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy/MM/dd");
				java.util.Date utilDate = new java.util.Date(rs.getDate("upload_time").getTime());
				String date = df.format(utilDate);
				Board board = new Board(rs.getInt("boardno"), rs.getString("title"), rs.getString("id"), 
						rs.getString("answer"), rs.getString("inquiry"), date);
				boardList.add(board);
			}
			return boardList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public Board showDetail (int boardNo) throws SQLException {
		String sql = "SELECT boardno, answer, inquiry, id, title, upload_time "
				+ "FROM BOARD WHERE boardno=?";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {boardNo});
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy/MM/dd");
				java.util.Date utilDate = new java.util.Date(rs.getDate("upload_time").getTime());
				String date = df.format(utilDate);
				Board board = new Board(rs.getInt("boardno"), rs.getString("title"), rs.getString("id"), 
						 rs.getString("inquiry"),rs.getString("answer"), date);
				return board;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public int upload(Board board, String userId) throws SQLException {
		String sql = "INSERT INTO BOARD (boardno, id, title, inquiry, answer, upload_time) "
				+ "VALUES (board_seq.nextval, ?, ?, ?, ?, SYSDATE)";
		Object[] param = new Object[] {userId, board.getTitle(), board.getInquiry(), board.getAnswer()};
		jdbcUtil.setSqlAndParameters(sql, param);
		
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
	
	public int update (Board board, int boardNo) throws SQLException {
		String sql = "UPDATE BOARD "
					+ "SET inquiry=?, title=? "
					+ "WHERE boardno=?";
		Object[] param = new Object[] {board.getInquiry(), board.getTitle(), boardNo};
		jdbcUtil.setSqlAndParameters(sql, param);
		
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
	
	public int answer (Board board, int boardNo) throws SQLException {
		String sql = "UPDATE BOARD "
					+ "SET answer=? "
					+ "WHERE boardno=?";
		Object[] param = new Object[] {board.getAnswer(), boardNo};
		jdbcUtil.setSqlAndParameters(sql, param);
		
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
	
	public int remove (int boardNo) throws SQLException {
		String sql = "DELETE FROM BOARD WHERE boardno=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {boardNo});
		
		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return 0;
	}

}

