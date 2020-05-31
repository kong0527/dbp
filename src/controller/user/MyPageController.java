package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.*;
import model.service.OrderManager;
import model.service.UserManager;

public class MyPageController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
  
    	if (!UserSessionUtils.isLogined(request.getSession())) {
            return "redirect:/view/user/login/form";		// login form ��û���� redirect
        }
		
		try{
			UserManager userManager = UserManager.getInstance();
			User user = userManager.findUser(UserSessionUtils.getUserFromSession(request.getSession()));
			request.setAttribute("user", user);
			
			OrderManager orderMan = OrderManager.getInstance();
			List<Order> orderList = orderMan.findOrderList(user.getId());
			request.setAttribute("orderList", orderList);
			
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:/view/item/showAll";
		}
		
		return "/view/user/myPage.jsp";
    }
}
