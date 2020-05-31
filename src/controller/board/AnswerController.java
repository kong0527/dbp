package controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.Controller;
import controller.user.UserSessionUtils;
import model.Board;
import model.service.BoardManager;

public class AnswerController implements Controller{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setAttribute("curUserId", 
				UserSessionUtils.getUserFromSession(request.getSession()));		
		if (request.getMethod().equals("GET")) {
			String userId = UserSessionUtils.getUserFromSession(request.getSession());
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			if (userId.equals("admin")) {
				Board board = new Board(boardNo, userId);
				request.setAttribute("board", board);
				return "/view/board/answerForm.jsp";
			}
			
			return "redirect:/view/board/detail?boardNo=" + boardNo + "&answerFailed=true";
		} 
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Board board = new Board(request.getParameter("answer"));
		BoardManager manager = BoardManager.getInstance();
		manager.answer(board, boardNo);
		return "redirect:/view/board/list";
	}

}
