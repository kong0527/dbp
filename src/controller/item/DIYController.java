package controller.item;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Color;
import model.Deco;
import model.Glue;
import model.Scent;
import model.service.DIYManager;

public class DIYController implements Controller {
	

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    		DIYManager diyManager = new DIYManager();
    		List<Scent> scentList = diyManager.findScent();
        	List<Deco> decoList = diyManager.findDeco();
        	List<Color> colorList = diyManager.findColor();
        	List<Glue> glueList = diyManager.findGlue();
        	
        	request.setAttribute("scentList", scentList);
        	request.setAttribute("decoList", decoList);
        	request.setAttribute("colorList", colorList);
        	request.setAttribute("glueList", glueList);
        	
        	return "/view/item/diy.jsp";
     
    }
	

}
