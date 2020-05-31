package controller.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;
import model.service.ItemManager;
import controller.Controller;

public class ShowDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Item item = null;
		ItemManager manager = ItemManager.getInstance();
		String item_name = request.getParameter("item_name");
		
		try {
			item = manager.showDetail(item_name);
			
			request.setAttribute("item", item);
			return "/view/item/itemDetail.jsp";
		} catch (Exception e) {
			return "redirect:/view/item/list";
		}
		
		
	}
}
