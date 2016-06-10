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

	@Resource//����springע����ԴuserService
	private UserService userService;
	
	@RequestMapping("/login.form")
	public String loginForm(){
		//����������洫��һЩ����
		return "login";//ӳ�䵽login.jsp
		}
	//����һ
	@RequestMapping("/login-action.form")//spring MVC �Զ�ע��HTTPSERVLETREQUSET
	
	//�е�ֱ�ӣ�ȱ����Ҫ�Լ�������������ת������֧���ļ��ϴ�����
	public String checkLogin(HttpServletRequest req) {
		
		//�����ָ���쳣
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
