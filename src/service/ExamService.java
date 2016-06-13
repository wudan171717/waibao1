package service;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import dao.ExamDAO;
import entity.Examination;

@Service("examService")//Ĭ�ϵ�IDΪexamService
public class ExamService implements Serializable{
	private ExamDAO examDAO;

	public ExamDAO getExamDAO() {
		return examDAO;
	}
@Resource//�Զ�ƥ�����ע��
	public void setExamDAO(ExamDAO examDAO) {
		this.examDAO = examDAO;
	}
public List<Examination> findByTeacher(String publishTeacher) {
	List<Examination> exams=examDAO.findByTeacher(publishTeacher);
	return exams;
}
}
