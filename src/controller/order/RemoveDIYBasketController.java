package controller.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.DIY;

public class RemoveDIYBasketController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int index = Integer.parseInt(request.getParameter("dIndex"));
		HttpSession session = request.getSession();
		ArrayList<DIY> DIYList = (ArrayList<DIY>) session.getAttribute("DIYList");
			
		if(DIYList == null || DIYList.size() <= index || index < 0) {
			return "redirect:/view/item/basket";
		}
		
		
		DIYList.remove(index);
     
		session.setAttribute("DIYList", DIYList);
		// TODO Auto-generated method stub
		return "/view/item/basket.jsp";
	}
	

}
