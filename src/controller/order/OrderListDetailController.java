package controller.order;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.DIY;
import model.Lineitem;
import model.User;
import model.service.DIYManager;
import model.service.LineItemManager;
import model.service.UserManager;

public class OrderListDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int orderno = Integer.parseInt(request.getParameter("orderno"));
		
		try{
			LineItemManager lineItemMan = LineItemManager.getInstance();
			DIYManager DIYMan = DIYManager.getInstance();
			
			List<Lineitem> lineItemList = lineItemMan.findLineItmeList(orderno);
			List<DIY> DIYList = DIYMan.findDIYList(orderno);
			
			request.setAttribute("lineItemList", lineItemList);
			request.setAttribute("DIYList", DIYList);
			
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:/view/user/myPage";
		}
		
		return "/view/order/orderDetail.jsp";
	}
	

}
