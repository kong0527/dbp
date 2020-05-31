package controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import controller.user.UserSessionUtils;
import model.Board;
import model.service.BoardManager;

public class ShowBoardDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Board board = null;
		BoardManager manager = BoardManager.getInstance();
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		request.setAttribute("curUserId", 
				UserSessionUtils.getUserFromSession(request.getSession()));		
		
		try {
			board = manager.showDetail(boardNo);

		} catch (Exception e) {
			return "redirect:/view/board/list";
		}
		
		request.setAttribute("board", board);
		
		if (request.getParameter("updateFailed") != null) {
			// ���� �õ� ����
	    	request.setAttribute("exception", 
				new IllegalStateException("������ ���� ���� ���� ������ �� �����ϴ�."));            
			request.setAttribute("updateFailed", true);
		}
		else if (request.getParameter("deleteFailed") != null) {
			// ���� �õ� ����	
	    	request.setAttribute("exception", new IllegalStateException("�ٸ� ������� ���� ������ �� �����ϴ�."));
			request.setAttribute("deleteFailed", true);
		}
		
		else if (request.getParameter("answerFailed") != null) {
			request.setAttribute("exception", new IllegalStateException("�����ڸ� �亯�� �� �ֽ��ϴ�."));
			request.setAttribute("answerFailed", true);
		}
		
		return "/view/board/boardDetail.jsp";
	}

}
