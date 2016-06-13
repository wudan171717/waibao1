package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Repository;

import entity.Examination;
@Repository("examDAO")
public class MySQLExamDAO implements Serializable, ExamDAO {
	private JdbcDataSource dataSource;

	public MySQLExamDAO() {
	}

	public JdbcDataSource getDataSource() {
		return dataSource;
	}

	@Inject
	public void setDataSource(@Named("jdbcDataSource") JdbcDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Examination> findByTeacher(String publishTeacher) {
		List<Examination> exams=new ArrayList<Examination>();
		String sql = "select * from kaoshi where publishTeacher=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Examination exam=null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publishTeacher);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				exam = new Examination();
				exam.setId(rs.getInt("id"));
				exam.setTitle(rs.getString("title"));
				exam.setEndTime(rs.getString("endTime"));
				exam.setGrade(rs.getInt("grade"));
				exam.setImg(rs.getString("img"));
				exam.setOverPeople(rs.getInt("overPeople"));
				exam.setPeople(rs.getInt("people"));
				exam.setPublishTeacher(rs.getString("publishTeacher"));
				exam.setRange(rs.getString("range"));
				exam.setStartTime(rs.getString("startTime"));
				exam.setStatue(rs.getString("statue"));
				exams.add(exam);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			dataSource.close(conn);
		}
		System.out.println(exams);
		return exams;
	}


}
