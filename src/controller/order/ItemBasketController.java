package controller.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Lineitem;
import model.service.ItemManager;

public class ItemBasketController  implements Controller {

	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		ArrayList<Lineitem> lineItemList = null; 
			
		if(session.getAttribute("lineItemList") == null) 
			lineItemList = new ArrayList<Lineitem>();
		else
			lineItemList = (ArrayList<Lineitem>)session.getAttribute("lineItemList");
		
		int index = lineItemList.size();
		
		Lineitem lineItem = new Lineitem();
		
		lineItem.setLineitemno(index);
		
		
		lineItem.setLineitemno(index);
		lineItem.setItem_no(Integer.parseInt(request.getParameter("item_no")));
		lineItem.setItem_name((String)request.getParameter("item_name"));
		lineItem.setItem_price(Integer.parseInt(request.getParameter("item_price")));
		lineItem.setItem_amount(Integer.parseInt(request.getParameter("count")));
		lineItem.setItem_total_price(Integer.parseInt(request.getParameter("totalPrice")));
		lineItemList.add(lineItem);
     
		session.setAttribute("lineItemList", lineItemList);
		return "redirect:/view/item/basket";
	}
	

}
