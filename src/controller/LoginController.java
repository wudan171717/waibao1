package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;
import service.NameOrPwdException;
import service.NullParamException;
import service.UserService;
@Controller
@RequestMapping()
public class LoginController{

	@Resource//请求spring注入资源userService
	private UserService userService;
	
	@RequestMapping("/login.form")
	public String loginForm(){
		//可以向表单界面传递一些参数
		return "login";//映射到login.jsp
		}
	//方法一
	@RequestMapping("/login-action.form")//spring MVC 自动注入HTTPSERVLETREQUSET
	
	//有点直接，缺点需要自己处理数据类型转换，不支持文件上传功能
	public String checkLogin(HttpServletRequest req) {
		
		//制造空指针异常
		/*String s=null;
		s.length();*/
		
		String username=req.getParameter("username");
     	String pwd=req.getParameter("pwd");
		try {
			User user=userService.login(username, pwd);
			req.getSession().setAttribute("name", user.getName());
			req.getSession().setAttribute("usename", user.getUsername());
			req.getSession().setAttribute("pwd", user.getPwd());
			req.getSession().setAttribute("photo", user.getPhoto());
			req.getSession().setAttribute("classes", user.getClasses());
			req.getSession().setAttribute("major", user.getName());
			req.getSession().setAttribute("email", user.getEmail());
			req.getSession().setAttribute("grade", user.getGender());
			req.getSession().setAttribute("gender", user.getGender());
			return "redirect:/jsp/onlineService.jsp";
		} catch (NameOrPwdException e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "login";
		}catch (RuntimeException e){
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";
		}catch(NullParamException e){
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "redirect:error.jsp";
		}

	}

	}
