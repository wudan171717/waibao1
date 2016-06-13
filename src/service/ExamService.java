package service;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import dao.ExamDAO;
import entity.Examination;

@Service("examService")//默认的ID为examService
public class ExamService implements Serializable{
	private ExamDAO examDAO;

	public ExamDAO getExamDAO() {
		return examDAO;
	}
@Resource//自动匹配对象并注入
	public void setExamDAO(ExamDAO examDAO) {
		this.examDAO = examDAO;
	}
public List<Examination> findByTeacher(String publishTeacher) {
	List<Examination> exams=examDAO.findByTeacher(publishTeacher);
	return exams;
}
}
