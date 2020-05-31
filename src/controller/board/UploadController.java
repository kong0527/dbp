package controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import controller.user.UserSessionUtils;
import model.Board;
import model.service.BoardManager;


public class UploadController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Board board = new Board(request.getParameter("title"), request.getParameter("inquiry"));
		String userId = UserSessionUtils.getUserFromSession(request.getSession());
		request.setAttribute("curUserId", 
				UserSessionUtils.getUserFromSession(request.getSession()));		
		try {
			BoardManager manager = BoardManager.getInstance();
			manager.upload(board, userId);
			return "redirect:/view/board/list";
		} catch (Exception ex) {
			return "redirect:/view/item/list";
		}
	}

}
