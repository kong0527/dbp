package controller.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.DIY;
import model.Lineitem;
import model.User;
import model.service.UserManager;

public class OrderController  implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if (!UserSessionUtils.isLogined(request.getSession())) {
            return "redirect:/view/user/login/form";		// login form ��û���� redirect
        }
		
		int itemTotalPrice = 0, dlPrice = 0;
		
		UserManager userManager = UserManager.getInstance();
		User user = userManager.findUser(UserSessionUtils.getUserFromSession(request.getSession()));
		request.setAttribute("user", user);
		
		try{
			itemTotalPrice = Integer.parseInt(request.getParameter("itemTotalPrice"));
			dlPrice = Integer.parseInt(request.getParameter("dlPrice"));
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:/view/item/basket";
		}
		
		int totalPrice = itemTotalPrice + dlPrice;
		
		if(totalPrice <= 0) {
			return "redirect:/view/item/basket";
		}
		request.setAttribute("itemTotalPrice", itemTotalPrice);
		request.setAttribute("dlPrice", dlPrice);
		request.setAttribute("totalPrice", totalPrice);
		return "/view/order/orderForm.jsp";
	}
	

}
