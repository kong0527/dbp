package model.service;

import java.util.List;
import java.sql.SQLException;
import model.Board;
import model.dao.BoardDAO;

public class BoardManager {
   private static BoardManager boardMan = new BoardManager();
   private BoardDAO boardDAO;
   
   private BoardManager() {
      try {
         boardDAO = new BoardDAO();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public static BoardManager getInstance() {
      return boardMan;
   }
   
   public List<Board> boardList() throws SQLException {
      return boardDAO.boardList();
   }
   
   public Board showDetail(int boardNo) throws SQLException {
      Board board = boardDAO.showDetail(boardNo);
      return board;
   }
   
   public BoardDAO getBoardDAO() {
      return this.boardDAO;
   }
   
   public int upload(Board board, String userId) throws SQLException {
      return boardDAO.upload(board, userId);
   }
   
   public int update(Board board, int boardNo) throws SQLException {
      return boardDAO.update(board, boardNo);
   }
   
   public int answer(Board board, int boardNo) throws SQLException {
      return boardDAO.answer(board, boardNo);
   }
   
   public int remove(int boardNo) throws SQLException {
      return boardDAO.remove(boardNo);
   }

}