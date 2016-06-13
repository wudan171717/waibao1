package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Examination;
import entity.Teacher;
import service.ExamService;
import service.TeacherCardService;
import service.UserService;

@Controller
@RequestMapping()
public class ExamController {
	@Resource//请求spring注入资源userService
	private ExamService examService;
	
	
	@RequestMapping("/examFindByTeacher-action.form")
	public String ExamFindByTeacher(HttpServletRequest req) {
		HttpSession session=req.getSession();
		String publishTeacher=session.getAttribute("name").toString();
		try {
			List <Examination> exams=examService.findByTeacher(publishTeacher);
			req.getSession().setAttribute("exams", exams);
			return "redirect:/jsp/myTests.jsp";
		} 
		catch (RuntimeException e){
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
			return "error";}

	}
	
}
