package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Teacher;
import service.TeacherCardService;
import service.UserService;

@Controller
@RequestMapping()
public class TeacherCardController {
	@Resource//����springע����ԴuserService
	private TeacherCardService teacherCardService;
	
	@RequestMapping("/teacherCard-action.form")
	public String teacherCard(HttpServletRequest req) {
		String tname=req.getParameter("tname");
		Teacher teacher=new Teacher();
		teacher.setName(tname);
		try {
			List <Teacher> teachers=teacherCardService.findTeacher(teacher);
			req.getSession().setAttribute("teachers", teachers);
			return "redirect:/jsp/teacherCard.jsp";
		} 
		catch (RuntimeException e){
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";}

	}
	
	@RequestMapping("/teacherCardByCondition-action.form")
	public String teacherCardByCondition(HttpServletRequest req) {
		String position=req.getParameter("postion");
		String firstname=req.getParameter("firstname");
		Teacher teacher=new Teacher();
		teacher.setPosition(position);
		teacher.setFirstname(firstname);
		try {
			List <Teacher> teachers=teacherCardService.findTeacherByCondition(teacher);
			req.getSession().setAttribute("teachers", teachers);
			return "redirect:/jsp/teacherCard.jsp";
		} 
		catch (RuntimeException e){
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";}

	}
	
	@RequestMapping("/teacherCardFindAll-action.form")
	public String teacherCardFindAll(HttpServletRequest req) {
		try {
			List <Teacher> teachers=teacherCardService.findAllTeacher();
			req.getSession().setAttribute("teachers", teachers);
			return "redirect:/jsp/teacherCard.jsp";
		} 
		catch (RuntimeException e){
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";}

	}
	
}
