package controller.board;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import controller.user.UserSessionUtils;
import model.Board;
import model.service.BoardManager;

public class ShowBoardController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		BoardManager manager = BoardManager.getInstance();
		List<Board> boardList = manager.boardList();
		request.setAttribute("curUserId", 
				UserSessionUtils.getUserFromSession(request.getSession()));		
		request.setAttribute("boardList", boardList);
		
		return "/view/board/showBoard.jsp";
	}
	

}
