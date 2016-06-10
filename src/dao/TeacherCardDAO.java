package dao;

import java.util.List;

import entity.Teacher;

public interface TeacherCardDAO {

	public List<Teacher> findTeacher(Teacher teacher);

	public List<Teacher> findTeacherByCondition(Teacher teacher);

	public List<Teacher> findAllTeacher();
}
