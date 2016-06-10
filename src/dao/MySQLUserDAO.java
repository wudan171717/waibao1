package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Repository;

import entity.User;

@Repository("userDAO")
// ָ���ض���BEAN ID ����setUserDaoע��
public class MySQLUserDAO implements UserDAO, Serializable {
	private JdbcDataSource dataSource;

	public MySQLUserDAO() {
	}

	public JdbcDataSource getDataSource() {
		return dataSource;
	}

	@Inject
	public void setDataSource(@Named("jdbcDataSource") JdbcDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public User findByName(String username) {
		String sql = "select * from geren where username=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			User user = null;
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setActivity(rs.getString("activity"));
				user.setClasses(rs.getString("classes"));
				user.setCommunity(rs.getString("community"));
				user.setCourse(rs.getString("course"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("gender"));
				user.setMajor(rs.getString("major"));
				user.setPhoto(rs.getString("photo"));
				user.setSystem(rs.getString("system"));
				user.setTeacher(rs.getString("teacher"));
				user.setUsername(rs.getString("username"));
			}
			pstmt.close();
			rs.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			dataSource.close(conn);
		}
	}

	public void register(String username, String pwd, String name,
			String gender, String classes, String major, String email) {
		String sql = "INSERT INTO geren (name,username,pwd,gender,classes,major,email)VALUES(?,?,?,?,?,?,?);";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, username);
			pstmt.setString(3, pwd);
			pstmt.setString(4, gender);
			pstmt.setString(5, classes);
			pstmt.setString(6, major);
			pstmt.setString(7, email);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			dataSource.close(conn);
		}
	}

	@Override
	public void appoint(String gender, int number, String major, int classes,
			String email, int photo) {
		String sql = "INSERT INTO yuyue (gender,number,major,classes,email,photo)VALUES(?,?,?,?,?,?);";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gender);
			pstmt.setInt(2, number);
			pstmt.setString(3, major);
			pstmt.setInt(4, classes);
			pstmt.setString(5, email);
			pstmt.setInt(6, photo);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			dataSource.close(conn);
		}
	}

}
