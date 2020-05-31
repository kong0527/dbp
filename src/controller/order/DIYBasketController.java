package controller.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.DIY;
import model.Lineitem;

public class DIYBasketController  implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		ArrayList<DIY> DIYList = null;
		if(session.getAttribute("DIYList") == null )
			DIYList = new ArrayList<DIY>();
		else
			DIYList = (ArrayList<DIY>)session.getAttribute("DIYList");
		
		int index = DIYList.size();
			
		//name을 id로 바꾸기 
		DIY diy = new DIY();
		diy.setDiy_itemno(index);
		diy.setDiy_name((String)request.getParameter("diy_name"));
		diy.setDiy_amount(Integer.parseInt(request.getParameter("count")));
		diy.setScenttype((String)request.getParameter("scent"));
		diy.setDecotype((String)request.getParameter("deco"));
		diy.setColortype((String)request.getParameter("color"));
		diy.setGluetype((String)request.getParameter("glue"));
		diy.setDiy_price(Integer.parseInt(request.getParameter("Price")));
		diy.setDiy_total_price(Integer.parseInt(request.getParameter("totalPrice")));
		
		DIYList.add(diy);
     
		session.setAttribute("DIYList", DIYList);
		// TODO Auto-generated method stub
		return "/view/item/basket.jsp";
	}
	

}
