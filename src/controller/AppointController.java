package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.AppointService;

@Controller
@RequestMapping()
public class AppointController {
	@Resource//请求spring注入资源userService
	private AppointService appointService;
	
	@RequestMapping("/appoint-action.form")
	public String Register(HttpServletRequest req) {
		String content=req.getParameter("content");
		HttpSession session=req.getSession();
		String usename=session.getAttribute("usename").toString();
		String name=session.getAttribute("name").toString();
		try {
			appointService.appoint(content,usename,name);
			return "redirect:/jsp/onlineService.jsp";
		} 
		catch (RuntimeException e){
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";}

	}
}
