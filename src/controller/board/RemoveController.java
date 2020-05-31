package controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controller.Controller;
import controller.user.UserSessionUtils;
import model.Board;
import model.service.BoardManager;

public class RemoveController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		request.setAttribute("curUserId", 
				UserSessionUtils.getUserFromSession(request.getSession()));		
		
		if (UserSessionUtils.getUserFromSession(request.getSession()).equals("admin")) {
			BoardManager manager = BoardManager.getInstance();
			manager.remove(boardNo);
			return "redirect:/view/board/list";
		}
		
		if (UserSessionUtils.isLoginUser(userId, session)) {
			BoardManager manager = BoardManager.getInstance();
			manager.remove(boardNo);
			return "redirect:/view/board/list";
		}
		
		return "redirect:/view/board/detail?boardNo=" + boardNo + "&deleteFailed=true";
		
		
	}

}
