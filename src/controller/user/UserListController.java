package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.User;
import model.service.UserManager;

public class UserListController implements Controller {
	// private static final int countPerPage = 100;	// �� ȭ�鿡 ����� ����� ��

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		// �α��� ���� Ȯ��
    	if (!UserSessionUtils.isLogined(request.getSession())) {
            return "redirect:/view/user/login/form";		// login form ��û���� redirect
        }
		UserManager manager = UserManager.getInstance();
		List<User> userList = manager.findUserList();
		
		// userList ��ü�� ���� �α����� ����� ID�� request�� �����Ͽ� ����
		request.setAttribute("userList", userList);				
		request.setAttribute("curUserId", 
				UserSessionUtils.getUserFromSession(request.getSession()));		

		// ����� ����Ʈ ȭ������ �̵�(forwarding)
		return "/view/user/list.jsp";        
    }
}
