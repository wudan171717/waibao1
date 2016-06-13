package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Community;
import service.ActiveService;

@Controller
@RequestMapping()
public class ActiveController {
	@Resource//请求spring注入资源userService
	private ActiveService activeService;
	
	@RequestMapping("/activeFindAll-action.form")
	public String ActiveFindAll(HttpServletRequest req) {
		try {
			List <Community> communities=activeService.activeFindAll();
			req.getSession().setAttribute("communities", communities);
			return "redirect:/jsp/active.jsp";
		} 
		catch (RuntimeException e){
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";}

	}
	
	@RequestMapping("/activeFindByType-action.form")
	public String ActiveFindByType(HttpServletRequest req) {
		String type=req.getParameter("type");
		try {
			List <Community> communities=activeService.activeFindByType(type);
			req.getSession().setAttribute("communities", communities);
			return "redirect:/jsp/active.jsp";
		} 
		catch (RuntimeException e){
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";}

	}
	
	@RequestMapping("/activeFindStatue-action.form")
	public String ActiveFindByStatue(HttpServletRequest req) {
		String statue=req.getParameter("statue");
		try {
			List <Community> communities=activeService.activeFindByStatue(statue);
			req.getSession().setAttribute("communities", communities);
			return "redirect:/jsp/active.jsp";
		} 
		catch (RuntimeException e){
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";}

	}
	@RequestMapping("/activeFindByWriter-action.form")
	public String ActiveFindByWriter(HttpServletRequest req) {
		String writer=req.getParameter("writer");
		try {
			List <Community> communities=activeService.activeFindByWriter(writer);
			req.getSession().setAttribute("communities", communities);
			return "redirect:/jsp/active.jsp";
		} 
		catch (RuntimeException e){
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";}

	}
	@RequestMapping("/activeFindById-action.form")
	public String ActiveFindById(HttpServletRequest req) {
		String id=req.getParameter("id");
		try {
			Community community=activeService.ActiveFindById(id);
			req.getSession().setAttribute("community", community);
			return "redirect:/jsp/还没写.jsp";
		} 
		catch (RuntimeException e){
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";}

	}
}
