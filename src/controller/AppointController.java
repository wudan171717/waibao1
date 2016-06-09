package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.UserService;

@Controller
@RequestMapping()
public class AppointController {
	@Resource//请求spring注入资源userService
	private UserService userService;
	
	@RequestMapping("/apoint-action.form")
	public String Register(HttpServletRequest req) {
		String gender=req.getParameter("gender");
		System.out.println(gender);
		int number=Integer.parseInt(req.getParameter("number"));
		String major=req.getParameter("major");
		int classes=Integer.parseInt(req.getParameter("classes")) ;
		String email=req.getParameter("email");
		int photo=Integer.parseInt(req.getParameter("photo")) ;
		try {
			userService.appoint(gender, number,major,classes,email,photo);
			return "redirect:/jsp/onlineService.jsp";
		} 
		catch (RuntimeException e){
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";}

	}
}
