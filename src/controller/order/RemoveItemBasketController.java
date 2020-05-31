package controller.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Lineitem;
import model.service.ItemManager;

public class RemoveItemBasketController  implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int index = Integer.parseInt(request.getParameter("tIndex"));
		HttpSession session = request.getSession();
		ArrayList<Lineitem> lineItemList = (ArrayList<Lineitem>) session.getAttribute("lineItemList"); 
			
		if(lineItemList == null || lineItemList.size() <= index || index < 0) {
			return "redirect:/view/item/basket";
		}
	
		lineItemList.remove(index);
		session.setAttribute("ineItemList", lineItemList);
		// TODO Auto-generated method stub
		return "/view/item/basket.jsp";
	}
	

}
