package dao;

import java.util.List;

import entity.Examination;


public interface ExamDAO {
	public List<Examination> findByTeacher(String publishTeacher);
}