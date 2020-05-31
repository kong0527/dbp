package controller.item;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Item;
import model.service.ItemManager;

public class ShowAllController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ItemManager manager = ItemManager.getInstance();
		List<Item> itemList = manager.itemList();
		
		request.setAttribute("itemList", itemList);
		
		return "/view/item/showAll.jsp";
	}

}
