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

import entity.Teacher;
import entity.User;

@Repository("teacherCardDAO")
//指定特定的BEAN ID 方便setUserDao注入
public class MySQLTeacherCardDAO implements Serializable, TeacherCardDAO {
	private JdbcDataSource dataSource;

	public MySQLTeacherCardDAO() {
	}

	public JdbcDataSource getDataSource() {
		return dataSource;
	}

	@Inject
	public void setDataSource(@Named("jdbcDataSource") JdbcDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Teacher> findTeacher(Teacher teacher) {
		List<Teacher> teachers=new ArrayList<Teacher>();
		String sql = "select * from jiaogong where tname=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String tname= teacher.getName();
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("tname"));
				teacher.setEmail(rs.getString("email"));
				teacher.setAddress(rs.getString("address"));
				teacher.setFirstname(rs.getString("firstname"));
				teacher.setPosition(rs.getString("position"));
				teacher.setType(rs.getString("type"));
			teachers.add(teacher);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			dataSource.close(conn);
		}
		return teachers;
	}

	@Override
	public List<Teacher> findTeacherByCondition(Teacher teacher) {
		List<Teacher> teachers=new ArrayList<Teacher>();
		String sql1 = "select * from jiaogong where position=?";
		String sql2 = "select * from jiaogong where position=? and firstname=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String position= teacher.getPosition();
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, position);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("tname"));
				teacher.setEmail(rs.getString("email"));
				teacher.setAddress(rs.getString("address"));
				teacher.setFirstname(rs.getString("firstname"));
				teacher.setPosition(rs.getString("position"));
				teacher.setType(rs.getString("type"));
			teachers.add(teacher);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			dataSource.close(conn);
		}
		return teachers;
	}

	@Override
	public List<Teacher> findAllTeacher() {
		List<Teacher> teachers=new ArrayList<Teacher>();
		String sql = "select * from jiaogong ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Teacher teacher=null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("tname"));
				teacher.setEmail(rs.getString("email"));
				teacher.setAddress(rs.getString("address"));
				teacher.setFirstname(rs.getString("firstname"));
				teacher.setPosition(rs.getString("position"));
				teacher.setType(rs.getString("type"));
			teachers.add(teacher);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			dataSource.close(conn);
		}
		return teachers;
	}

}
