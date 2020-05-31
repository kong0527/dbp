package controller.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.DIY;
import model.Lineitem;
import model.Order;
import model.User;
import model.service.DIYManager;
import model.service.LineItemManager;
import model.service.OrderManager;
import model.service.UserManager;

public class CompleteOrderController  implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		ArrayList<Lineitem> lineItemList = null; 
		ArrayList<DIY> DIYList = null; 
		
		try {	
		if(session.getAttribute("lineItemList") == null && session.getAttribute("DIYList") == null)
			return "/view/item/showAll.jsp";
		
		OrderManager orderMan = OrderManager.getInstance();
		Order order = new Order();
		order.setId(request.getParameter("userId"));
		order.setOrder_address(request.getParameter("address"));
		order.setTotalprice(Integer.parseInt(request.getParameter("totalPrice")));
		order = orderMan.create(order);
		
		int orderNo = order.getOrderno();
		
		if(session.getAttribute("lineItemList") != null) {
			lineItemList = (ArrayList<Lineitem>)session.getAttribute("lineItemList"); 
			LineItemManager lineItemMan = LineItemManager.getInstance();
			for(int i = 0; i < lineItemList.size(); i++) {
				lineItemList.get(i).setOrderno(orderNo);
				lineItemMan.create(lineItemList.get(i));
			}
		}	
		
		if(session.getAttribute("DIYList") != null) {
			DIYList = (ArrayList<DIY>)session.getAttribute("DIYList");
			DIYManager diyMan = DIYManager.getInstance();
			for(int i = 0; i < DIYList.size(); i++) {
				DIYList.get(i).setOrderno(orderNo);
				diyMan.create(DIYList.get(i));
			}
		}
		
		request.setAttribute("order", order);
		

		}catch(Exception e) {
			return "redirect:/view/item/basket";
		}
		
		return "/view/order/complete.jsp";
	}
	

}
