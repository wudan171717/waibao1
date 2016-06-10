package service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.TeacherCardDAO;
import entity.Teacher;

@Service("teacherCardService")//默认的ID为userService
public class TeacherCardService implements Serializable{
	private TeacherCardDAO teacherCardDao;

	public TeacherCardDAO getTeacherCardDAO() {
		return teacherCardDao;
	}
@Resource//自动匹配userDao对象并注入
	public void setTeacherCardDAO(TeacherCardDAO teacherCardDao) {
		this.teacherCardDao = teacherCardDao;
	}
public List<Teacher> findTeacher(Teacher teacher) {
	List<Teacher> teachers=teacherCardDao.findTeacher(teacher);
	return teachers;
}
public List<Teacher> findTeacherByCondition(Teacher teacher) {
	List<Teacher> teachers=teacherCardDao.findTeacherByCondition(teacher);
	return teachers;
}
public List<Teacher> findAllTeacher() {
	List<Teacher> teachers=teacherCardDao.findAllTeacher();
	return teachers;
}

	}






