package controller;

import java.util.HashMap;
import controller.user.*;
import controller.board.*;
import controller.item.*;
import controller.order.*;

import java.util.Map;
import org.slf4j.*;

public class RequestMapping {
	private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
	
	private Map<String, Controller> mappings = new HashMap<String, Controller>();
	
	public void initMapping() {
		mappings.put("/", new ForwardController("index.jsp"));
		mappings.put("/view/item/list", new ShowAllController());
		mappings.put("/view/item/detail", new ShowDetailController());
		mappings.put("/view/user/login", new LoginController());
		mappings.put("/view/user/login/form", new ForwardController("/view/user/loginForm.jsp"));
		mappings.put("/user/logout", new LogoutController());
		mappings.put("/view/user/list", new UserListController());
		mappings.put("/view/user/register", new RegisterUserController());
		mappings.put("/view/user/register/form", new ForwardController("/view/user/registerForm.jsp"));
		mappings.put("/view/user/myPage", new MyPageController());
		mappings.put("/view/item/showAll", new ShowAllController());
		mappings.put("/view/item/basket", new ForwardController("/view/item/basket.jsp"));
		mappings.put("/view/item/itemBasket", new ItemBasketController());
		mappings.put("/view/item/diyBasket", new DIYBasketController());
		mappings.put("/view/item/removeItemBasket", new RemoveItemBasketController());
		mappings.put("/view/item/removeDiyBasket", new RemoveDIYBasketController());
		mappings.put("/view/item/diy", new DIYController());
		mappings.put("/view/order/form", new OrderController());
		mappings.put("/view/order/complete", new CompleteOrderController());
		mappings.put("/view/order/detail", new OrderListDetailController());
		mappings.put("/view/board/list", new ShowBoardController());
		mappings.put("/view/board/upload/form", new ForwardController("/view/board/uploadForm.jsp"));
		mappings.put("/view/board/upload", new UploadController());
		mappings.put("/view/board/detail", new ShowBoardDetailController());
		mappings.put("/view/board/remove", new RemoveController());
		mappings.put("/view/board/update/form",new UpdateBoardController());
		mappings.put("/view/board/update", new UpdateBoardController());
		mappings.put("/view/board/answer/form", new AnswerController());
		mappings.put("/view/board/answer", new AnswerController());
		
		logger.info("Initialized Request Mapping!");
	}
	
    public Controller findController(String uri) {	
    	// �־��� uri�� �����Ǵ� controller ��ü�� ã�� ��ȯ
        return mappings.get(uri);
    }
	
}
