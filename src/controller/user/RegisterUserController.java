package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.User;
import model.service.ExistingUserException;
import model.service.UserManager;

public class RegisterUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = new User(request.getParameter("username"), request.getParameter("id"), 
				request.getParameter("pw"), request.getParameter("address"));
        log.debug("Create User : {}", user);

		try {
			UserManager manager = UserManager.getInstance();
			manager.create(user);
	        return "redirect:/view/user/list";		// 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙트 화占쏙옙占쏙옙占쏙옙 redirect
	        
		} catch (ExistingUserException e) {		// 占쏙옙占쏙옙 占쌩삼옙 占쏙옙 회占쏙옙占쏙옙占쏙옙 form占쏙옙占쏙옙 f
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", user);
			return "/view/user/registerForm.jsp";
		}
    }
}
