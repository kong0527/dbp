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
			// 수정 시도 실패
	    	request.setAttribute("exception", 
				new IllegalStateException("본인이 쓰지 않은 글은 수정할 수 없습니다."));            
			request.setAttribute("updateFailed", true);
		}
		else if (request.getParameter("deleteFailed") != null) {
			// 삭제 시도 실패	
	    	request.setAttribute("exception", new IllegalStateException("다른 사용자의 글은 삭제할 수 없습니다."));
			request.setAttribute("deleteFailed", true);
		}
		
		else if (request.getParameter("answerFailed") != null) {
			request.setAttribute("exception", new IllegalStateException("관리자만 답변할 수 있습니다."));
			request.setAttribute("answerFailed", true);
		}
		
		return "/view/board/boardDetail.jsp";
	}

}
