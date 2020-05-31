package controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controller.user.UserSessionUtils;
import controller.Controller;
import model.Board;
import model.service.BoardManager;

public class UpdateBoardController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("GET")) {
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			String userId = request.getParameter("userId");
			HttpSession session = request.getSession();
			request.setAttribute("curUserId", 
					UserSessionUtils.getUserFromSession(request.getSession()));		
			
			if (UserSessionUtils.isLoginUser(userId,session)) {
				BoardManager manager = BoardManager.getInstance();
				Board board = manager.showDetail(boardNo);
				request.setAttribute("board", board);
				
				return "/view/board/updateForm.jsp";
			}
			
			return "redirect:/view/board/detail?boardNo=" + boardNo + "&updateFailed=true"; 
		}
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Board updateBoard = new Board(request.getParameter("title"), request.getParameter("inquiry"));
		BoardManager manager = BoardManager.getInstance();
		manager.update(updateBoard, boardNo);
		return "redirect:/view/board/list";		
	}

}
